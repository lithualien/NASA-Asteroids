package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;
import com.github.lithualien.database.DatabaseObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {
    @Override
    public List<Asteroid> getAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();
        DatabaseObject databaseObject = new DatabaseObject();
        String query = "SELECT * FROM asteroidas";

        Statement st = null;
        try
        {
            st = databaseObject.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                Asteroid asteroid = new Asteroid();
                asteroid.setID(rs.getInt("ID"));
                asteroid.setVInfinity(rs.getDouble("vInfinity"));
                asteroid.setObjectLink(rs.getString("object_link"));
                asteroid.setName(rs.getString("name"));
                asteroid.setPotentialHazardous(rs.getBoolean("potential_hazardous"));
                asteroid.setEstimatedDiameterMax(rs.getDouble("estimated_diameter_max"));
                asteroid.setEstimatedDiameterMin(rs.getDouble("estimated_diameter_min"));
                asteroids.add(asteroid);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return  asteroids;
    }

    @Override
    public Asteroid getAsteroid(int ID) {
        Asteroid asteroid = new Asteroid();
        DatabaseObject databaseObject = new DatabaseObject();
        String query = String.format("SELECT * FROM asteroidas WHERE ID = %d", ID);

        Statement st = null;
        try
        {
            st = databaseObject.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                asteroid = new Asteroid();
                asteroid.setID(rs.getInt("ID"));
                asteroid.setVInfinity(rs.getDouble("vInfinity"));
                asteroid.setObjectLink(rs.getString("object_link"));
                asteroid.setName(rs.getString("name"));
                asteroid.setPotentialHazardous(rs.getBoolean("potential_hazardous"));
                asteroid.setEstimatedDiameterMax(rs.getDouble("estimated_diameter_max"));
                asteroid.setEstimatedDiameterMin(rs.getDouble("estimated_diameter_min"));
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return  asteroid;
    }

    @Override
    public List<Asteroid> getAsteroidsByDiameterPlus(double diameter) {
        List<Asteroid> asteroids = new ArrayList<>();
        DatabaseObject databaseObject = new DatabaseObject();
        String query = String.format("SELECT * FROM asteroidas WHERE estimated_diameter_min >= %f", diameter);
        Statement st = null;
        try
        {
            st = databaseObject.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                Asteroid asteroid = new Asteroid();
                asteroid.setID(rs.getInt("ID"));
                asteroid.setVInfinity(rs.getDouble("vInfinity"));
                asteroid.setObjectLink(rs.getString("object_link"));
                asteroid.setName(rs.getString("name"));
                asteroid.setPotentialHazardous(rs.getBoolean("potential_hazardous"));
                asteroid.setEstimatedDiameterMax(rs.getDouble("estimated_diameter_max"));
                asteroid.setEstimatedDiameterMin(rs.getDouble("estimated_diameter_min"));
                asteroids.add(asteroid);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return  asteroids;
    }

    @Override
    public List<Asteroid> getAsteroidsByVelocityPlus(double velocity) {
        List<Asteroid> asteroids = new ArrayList<>();
        DatabaseObject databaseObject = new DatabaseObject();
        String query = String.format("SELECT * FROM close_approach WHERE relative_velocity >= %f", velocity);
        Statement st = null;
        try
        {
            st = databaseObject.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                asteroids.add(getAsteroid(rs.getInt("asteroid_id")));
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return  asteroids;
    }

    @Override
    public List<Asteroid> getHazardusAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();
        DatabaseObject databaseObject = new DatabaseObject();
        String query = "SELECT * FROM asteroidas where potential_hazardous = 'true'";
        Statement st = null;
        try
        {
            st = databaseObject.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                Asteroid asteroid = new Asteroid();
                asteroid.setID(rs.getInt("ID"));
                asteroid.setVInfinity(rs.getDouble("vInfinity"));
                asteroid.setObjectLink(rs.getString("object_link"));
                asteroid.setName(rs.getString("name"));
                asteroid.setPotentialHazardous(rs.getBoolean("potential_hazardous"));
                asteroid.setEstimatedDiameterMax(rs.getDouble("estimated_diameter_max"));
                asteroid.setEstimatedDiameterMin(rs.getDouble("estimated_diameter_min"));
                asteroids.add(asteroid);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return  asteroids;
    }
}
