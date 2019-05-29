package com.github.lithualien;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 1000; i++){
            URL url = new URL("https://www.neowsapp.com/rest/v1/neo/browse?page="+i+"&size=1");
            URLConnection request = url.openConnection();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            //List<String>
           // System.out.println(rootobj.getAsJsonArray("near_earth_objects").get(0).getAsJsonObject().get("name"));
            //if(rootobj.getAsJsonArray("near_earth_objects").get(0).getAsJsonArray().get(0).getAsJsonObject().get("orbiting_body").getAsString().equals(""))
            //System.out.println(rootobj.getAsJsonArray("near_earth_objects").get(0).getAsJsonArray().get(0).getAsJsonObject().get("orbiting_body"));
            if(!rootobj.getAsJsonArray("near_earth_objects").get(0).getAsJsonObject().isJsonNull()) {
                System.out.println(rootobj.getAsJsonArray("near_earth_objects").get(0).getAsJsonArray().get(0).getAsJsonObject().get("orbiting_body"));
            }

           // System.out.println(rootobj.getAsJsonArray("near_earth_objects").get(0).getAsJsonObject().get("name"));//.getAsJsonArray("close_approach_data").get(0).getAsJsonObject().get("close_approach_date").getAsString();
        }

    }
}
