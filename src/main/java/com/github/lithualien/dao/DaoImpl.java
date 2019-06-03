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
 * @author Andrius Venckus
 */

public class DaoImpl implements Dao {
    private Connection connection;
    private ResultSet result;

    /**
     * Constructor to connect to database 
     */
    public DaoImpl() {
        connToDB();
    }
     /**
     * Connect to database 
     */
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

    /**
     * This method gets all asteroids 
     * @return the asteroids of the all asteroids 
     */
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
    /**
     * This method set  asteroids 
     * @param asteroids of the asteroid
     */
    private void setAsteroids(List<Asteroid> asteroids) throws SQLException {
        while(result.next()) {
            Links link1 = new Links("http://localhost:8080/NASA-Asteroids/services/asteroids/" + result.getInt("ID"), result.getString("object_link"), "http://localhost:8080/NASA-Asteroids/services/asteroids/"+ result.getInt("ID") +"/approach-data");
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
      /**
     * This method set  asteroid
     * @param asteroid of the asteroid 
     */
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

    /**
     * This method get asteroid
     * @param ID is the ad of the asteroid
     * @return the asteroid 
     */
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

    /**
     * This method get Asteroids By Diameter
     * @param from is the from diameter from one to another
     * @param to  is the to diameter from one to another
     * @return the asteroids 
     */
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

    /**
     * This method get Asteroids By Velocity 
     * @param from is from one Velocity asteroid to another 
     * @param to is to from one Velocity asteroid to another 
     * @return the asteroids 
     */
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

    /**
     * This method get tHazardous Asteroids 
     * @return the asteroids
     */
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
     /**
     * This method set close approach data 
     * @param closeApproachList is the link of the close approach data
     */
     private void setCloseApproachData(List<CloseApproach> closeApproachList) throws SQLException {
        while(result.next()) {
            Links link = new Links("http://localhost:8080/NASA-Asteroids/services/asteroids/" + result.getInt("asteroid_Id"));
            CloseApproach closeApproach = new CloseApproach(
                    result.getInt("id"),
                    result.getInt("asteroid_Id"),
                    result.getString("close_approach_date"),
                    result.getDouble("relative_velocity"),
                    result.getDouble("miss_distance"),
                    result.getDouble("impact_probability")
            );
            closeApproach.addLink(link);
            closeApproachList.add(closeApproach);
        }
    }
    
    /**
     * This method get fastest close approaches
     * @param size is the size of the close approaches
     * @return the close approach list 
     */
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
    
    /**
     * This method get Biggest probability Of Hitting 
     * @param size is the size of the biggest probability Of Hitting 
     * @return
     */
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
    
     /**
     * This method get miss distance of close approach
     * @return miss distance of close approach
     */
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

    /**
     * This method  get close approaches of planets
     * @param planetName is the planet name of the close approach
     * @return  closeApproachList of the close approach list 
     */
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
    public List<CloseApproach> getCloseApproaches(int asteroidID) {
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

    /**
     * Get all close approaches today.
     * @return the list of all close approaches today.
     */
    public List<CloseApproach> getCloseApproachesToday() {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach WHERE close_approach_date = current_date();";
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
     * Get close approaches in the past of selected quantity, ordered from oldest to earliest.
     * @param quantity the quantity of results.
     * @return the list of all close approaches of past approaches by selected size.
     */
    public List<CloseApproach> getPastCloseApproaches(int quantity) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach WHERE close_approach_date < current_date() ORDER BY close_approach_date DESC limit " + quantity;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return closeApproachList;
    }

    /**
     * Get close approaches in the future of selected quantity, ordered from oldest to earliest.
     * @param quantity the quantity of results.
     * @return the list of all close approaches of past approaches by selected size.
     */
    public List<CloseApproach> getFutureCloseApproaches(int quantity) {
        List<CloseApproach> closeApproachList = new ArrayList<>();
        String query = "SELECT * FROM close_approach WHERE close_approach_date > current_date() ORDER BY close_approach_date ASC limit " + quantity;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
            setCloseApproachData(closeApproachList);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return closeApproachList;
    }

    /**
     * This method get biggest asteroids
     * @param size of the size of the biggest asteroids 
     * @return AsteroidsList is AsteroidsList of the biggest Asteroids 
     */
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
    
    /**
     * This method get smallest asteroids
     * @param size is the size of the smallest asteroids 
     * @return  AsteroidsList is AsteroidsList of the smallest Asteroids 
     */
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
      /**
     * This method delete asteroid
     * @param id is the id of asteroid 
     */
    @Override
    public boolean deleteAsteroid(int id) {
        String query = "DELETE asteroidas, close_approach FROM asteroidas INNER JOIN close_approach ON close_approach.asteroid_id = asteroidas.ID WHERE asteroidas.ID = " + id;
        Statement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
            return true;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     * Gets asteroid by its name
     * @param name of the asteroid 
     * @return asteroid object
     */
    @Override
    public List<Asteroid> getAsteroidByName(String name) {
        List<Asteroid> AsteroidsList = new ArrayList<>();
        String query = "SELECT * FROM `asteroidas` WHERE name = '" + name + "'";
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
