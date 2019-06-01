package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to transfer data to the web service.
 * @author Vygandas Eidukis
 * @author Tomas Dominauskas
 */

public class DaoImpl implements Dao {
    private Connection connection;
    private ResultSet result;

    public DaoImpl() {
        connToDB();
    }

    private void connToDB() {
        InitialContext ctx;
        DataSource ds;
        try {
            ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("jdbc/jax-rs");
            connection = ds.getConnection();
        }
        catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Asteroid> getAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();
        String query = "SELECT * FROM asteroidas";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroids(asteroids);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return asteroids;
    }

    private void setAsteroids(List<Asteroid> asteroids) throws SQLException {
        while(result.next()) {
            Asteroid asteroid = new Asteroid(
                    result.getInt("ID"),
                    result.getString("object_link"),
                    result.getString("name"),
                    result.getDouble("vInfinity"),
                    result.getDouble("estimated_diameter_max"),
                    result.getDouble("estimated_diameter_min"),
                    result.getBoolean("potential_hazardous")
            );
            asteroids.add(asteroid);
        }
    }

    private void setAsteroid(Asteroid asteroid) throws SQLException {
        while(result.next()) {
            asteroid.setID(result.getInt("ID"));
            asteroid.setVInfinity(result.getDouble("vInfinity"));
            asteroid.setObjectLink(result.getString("object_link"));
            asteroid.setName(result.getString("name"));
            asteroid.setPotentialHazardous(result.getBoolean("potential_hazardous"));
            asteroid.setEstimatedDiameterMax(result.getDouble("estimated_diameter_max"));
            asteroid.setEstimatedDiameterMin(result.getDouble("estimated_diameter_min"));
        }
    }

    @Override
    public Asteroid getAsteroid(int ID) {
        Asteroid asteroid = new Asteroid();
        String query = String.format("SELECT * FROM asteroidas WHERE ID = %d", ID);
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroid(asteroid);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return asteroid;
    }

    @Override
    public List<Asteroid> getAsteroidsByDiameterPlus(double from, double to) {
        List<Asteroid> asteroids = new ArrayList<>();
        String query = "SELECT * FROM asteroidas WHERE estimated_diameter_min >= '" + from + "' AND '" + to + "'";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroids(asteroids);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return asteroids;
    }

    @Override
    public List<Asteroid> getAsteroidsByVelocity(double from, double to) {
        List<Asteroid> asteroids = new ArrayList<>();
        String query = "SELECT * FROM asteroidas WHERE vInfinity >=  '" + from + "' AND vInfinity <= '" + to + "'";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroids(asteroids);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return asteroids;
    }

    @Override
    public List<Asteroid> getHazardousAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();
        String query = "SELECT * FROM asteroidas where potential_hazardous = 'true'";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroids(asteroids);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return asteroids;
    }
}
