package com.github.lithualien;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String vInfinity, object_link = null, name, orbit_body = null, potential_hazardous = null, estimated_diameter_max = null, estimated_diameter_min = null, close_aproach_date = null, relative_velocity = null, miss_distance = null, impact_propability, asteroid_id;
        connectToDatabase();
        for(int i = 0; i < 918; i++){
            URL url = new URL("https://www.neowsapp.com/rest/v1/neo/sentry?is_active=true&page=" + i + "&size=1&api_key=E7e4qfUGm21lifyUhLRE7eBqYl8lrLYwJvQZpasG\n");
            URLConnection request = url.openConnection();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();

            asteroid_id = rootobj.getAsJsonArray("sentry_objects").get(0).getAsJsonObject().get("spkId").getAsString();
            name = rootobj.getAsJsonArray("sentry_objects").get(0).getAsJsonObject().get("designation").getAsString();
            impact_propability = rootobj.getAsJsonArray("sentry_objects").get(0).getAsJsonObject().get("impact_probability").getAsString();
            vInfinity = rootobj.getAsJsonArray("sentry_objects").get(0).getAsJsonObject().get("v_infinity").getAsString();

            url = new URL("https://www.neowsapp.com/rest/v1/neo/" + asteroid_id + "?api_key=E7e4qfUGm21lifyUhLRE7eBqYl8lrLYwJvQZpasG");
            request = url.openConnection();
            root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            rootobj = root.getAsJsonObject();
            try{
                object_link = rootobj.get("nasa_jpl_url").getAsString();
                estimated_diameter_min = rootobj.getAsJsonObject("estimated_diameter").get("meters").getAsJsonObject().get("estimated_diameter_min").getAsString();
                estimated_diameter_max = rootobj.getAsJsonObject("estimated_diameter").get("meters").getAsJsonObject().get("estimated_diameter_max").getAsString();
                potential_hazardous = rootobj.get("is_potentially_hazardous_asteroid").getAsString();
            }catch(Exception e)
            {
                System.out.println("asd");
            }

            insertOrderToDB(Integer.parseInt(asteroid_id), Double.parseDouble(vInfinity), object_link, name, potential_hazardous, Double.parseDouble(estimated_diameter_max), Double.parseDouble(estimated_diameter_min));

            if(rootobj.getAsJsonArray("close_approach_data").size() > 0) {
                for(int j = 0; j < rootobj.getAsJsonArray("close_approach_data").size(); j++) {
                    close_aproach_date = rootobj.getAsJsonArray("close_approach_data").get(j).getAsJsonObject().get("close_approach_date").getAsString();
                    miss_distance = rootobj.getAsJsonArray("close_approach_data").get(j).getAsJsonObject().get("miss_distance").getAsJsonObject().get("kilometers").getAsString();
                    orbit_body = rootobj.getAsJsonArray("close_approach_data").get(j).getAsJsonObject().get("orbiting_body").getAsString();
                    relative_velocity = rootobj.getAsJsonArray("close_approach_data").get(j).getAsJsonObject().get("relative_velocity").getAsJsonObject().get("kilometers_per_hour").getAsString();
                    insertToSADASd(Integer.parseInt(asteroid_id), close_aproach_date, Double.parseDouble(relative_velocity), Double.parseDouble(miss_distance), Double.parseDouble(impact_propability), orbit_body);
                }
            }
        }


    }

    private static Connection myConn;

    private static void connectToDatabase()
        {
        try
        {
            myConn = getConnection("jdbc:mysql://localhost:3306/nasa?autoReconnect=true&useSSL=false", "root", "123456");
        }
        catch (SQLException e)
        {
            System.out.println("Bad connection in show products");
        }
    }

    private static PreparedStatement myStatement;

    private static void insertOrderToDB(int asteroid_id, double vInfinity, String object_link, String name, String potential_hazardous, double estimated_diameter_max, double estimated_diameter_min)
    {
        try
        {
            myStatement = myConn.prepareStatement("INSERT into nasa.asteroidas(ID, vInfinity, object_link, name, potential_hazardous, estimated_diameter_max, estimated_diameter_min) values ('"+ asteroid_id +"'," +
                    " '"+ vInfinity +"', '"+ object_link +"', '"+ name +"', '"+ potential_hazardous +"', '"+ estimated_diameter_max +"', '"+ estimated_diameter_min +"')");
            myStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void insertToSADASd(int asteroid_id, String date, double relative_velocity, double miss_distance, double impact_probability, String orbit_body)
    {
        try
        {
            myStatement = myConn.prepareStatement("INSERT into nasa.close_approach(asteroid_id, close_approach_date, relative_velocity, miss_distance, impact_probability, orbit_body) values ('"+ asteroid_id +"'," +
                    " '"+ date +"', '"+ relative_velocity +"', '"+ miss_distance +"', '"+ impact_probability +"', '"+ orbit_body + "')");
            myStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
