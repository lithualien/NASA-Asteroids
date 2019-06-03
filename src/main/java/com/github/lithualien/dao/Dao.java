package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;
import com.github.lithualien.data.CloseApproach;

import java.util.List;

/**
 * Class to transfer data to the web service.
 * @author Vygandas Eidukis
 * @author Tomas Dominauskas
 */
public interface Dao {
    List<Asteroid> getAsteroids();
    Asteroid getAsteroid(int ID);
    List<Asteroid> getAsteroidsByDiameterPlus(double from, double to);
    List<Asteroid> getAsteroidsByVelocity(double from, double to);
    List<Asteroid> getHazardousAsteroids();
    List<CloseApproach> getFastestCloseApproaches(int size);
    List<CloseApproach> getBiggestProbOfHitting(int size);
    List<CloseApproach> getMissDistanceOfCloseApproach(double from);
    List<CloseApproach> getCloseApproachesOfPlanets(String planetName);
    List<Asteroid> getBiggestAsteroids(int size);
    List<Asteroid> getSmallestAsteroids(int size);

    /**
     * Get all asteroid's close approaches in the past and the future.
     * @param asteroidID the id of the asteroid.
     * @return the list of all close approaches.
     */
    List<CloseApproach> getCloseApproaches(int asteroidID);

    /**
     * Get all close approaches today.
     * @return the list of all close approaches today.
     */
    List<CloseApproach> getCloseApproachesToday();

    /**
     * Get close approaches in the past of selected quantity, ordered from oldest to earliest.
     * @param quantity the quantity of results.
     * @return the list of all close approaches of past approaches by selected size.
     */
    List<CloseApproach> getPastCloseApproaches(int quantity);

    /**
     * Get close approaches in the future of selected quantity, ordered from oldest to earliest.
     * @param quantity the quantity of results.
     * @return the list of all close approaches of past approaches by selected size.
     */
    List<CloseApproach> getFutureCloseApproaches(int quantity);
    
    /**
     * Delete asteroid and its close approaches
     * @param id of asteroid
     * @return true if succesfully deleted and false if not
     */
    boolean deleteAsteroid(int id);
    
    /**
     * Gets asteroid by its name
     * @param name of the asteroid 
     * @return asteroid object
     */
     List<Asteroid> getAsteroidByName(String name);
    
}
