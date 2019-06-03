package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;
import com.github.lithualien.data.CloseApproach;
import com.github.lithualien.data.Links;

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
            Links link1 = new Links("http://localhost:8080/NASA-Asteroids/services/asteroids/" + result.getInt("ID"), result.getString("object_link"));
            Asteroid asteroid = new Asteroid(
                    result.getInt("ID"),
                    result.getString("name"),
                    result.getDouble("vInfinity"),
                    result.getDouble("estimated_diameter_max"),
                    result.getDouble("estimated_diameter_min"),
                    result.getBoolean("potential_hazardous")
            );
            
            asteroid.addLink(link1);
            asteroids.add(asteroid);
        }
    }

    private void setAsteroid(Asteroid asteroid) throws SQLException {
        while(result.next()) {
            Links link1 = new Links(result.getString("object_link"));
            asteroid.addLink(link1);
            asteroid.setID(result.getInt("ID"));
            asteroid.setVInfinity(result.getDouble("vInfinity"));
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
    
     private void setCloseApproachData(List<CloseApproach> closeApproachList) throws SQLException {
        while(result.next()) {
            Links link = new Links("http://localhost:8080/NASA-Asteroids/services/asteroids/" + result.getInt("asteroid_Id"));
            CloseApproach closeApproach = new CloseApproach(
                    result.getInt("id"),
                    result.getInt("asteroid_Id"),
                    result.getString("close_approach_date"),
                    result.getDouble("relative_velocity"),
                    result.getDouble("miss_distance"),
                    result.getString("orbit_body"),
                    result.getDouble("impact_probability"),
                    "http://localhost:8080/NASA-Asteroids/services/asteroids/" + result.getInt("asteroid_Id")
                    result.getDouble("impact_propability")
            );
            closeApproach.addLink(link);
            closeApproachList.add(closeApproach);
        }
    }
    
    @Override
    public List<CloseApproach> getFastestCloseApproaches(int size) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach ORDER BY relative_velocity DESC limit " + size;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
        }
        return closeApproachList;
    }
    
    @Override
    public List<CloseApproach> getBiggestProbOfHitting(int size) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach ORDER BY impact_propability DESC limit " + size;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
        }
        return closeApproachList;
    }
    
    @Override
    public List<CloseApproach> getMissDistanceOfCloseApproach(double from) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach WHERE miss_distance >= " + from + " ORDER BY miss_distance DESC";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
        }
        return closeApproachList;
    }

    @Override
    public List<CloseApproach> getCloseApproachesOfPlanets(String planetName) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach WHERE orbit_body = " + "'" + planetName + "'";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
        }
        return closeApproachList;
    }

    /**
     * Get all asteroid's close approaches in the past and the future.
     * @param asteroidID the id of the asteroid.
     * @return the list of all close approaches.
     */
    public List<CloseApproach> getCloseApproach(int asteroidID) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach WHERE asteroid_id = '" + asteroidID + "';";
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
        }
        return closeApproachList;
    }
    
    @Override
    public List<Asteroid> getBiggestAsteroids(int size) {
        List<Asteroid> AsteroidsList = new ArrayList<>();
        String query = "SELECT * FROM `asteroidas` ORDER BY estimated_diameter_max DESC limit " + size;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroids(AsteroidsList);
        }
        catch (SQLException ex) {
        }
        return AsteroidsList;
    }
    
     @Override
    public List<Asteroid> getSmallestAsteroids(int size) {
        List<Asteroid> AsteroidsList = new ArrayList<>();
        String query = "SELECT * FROM `asteroidas` ORDER BY estimated_diameter_min ASC limit " + size;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setAsteroids(AsteroidsList);
        }
        catch (SQLException ex) {
        }
        return AsteroidsList;
    }
}
