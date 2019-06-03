package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;
import com.github.lithualien.data.CloseApproach;

import java.util.List;

/**
 * Class to transfer data to the web service.
 * @author Vygandas Eidukis
 * @author Tomas Dominauskas
 * @author Andrius Venckus 
 */
public interface Dao {
     /**
     * This method gets all asteroids 
     * @return the asteroids of the all asteroids 
     */
    List<Asteroid> getAsteroids();
    /**
     * This method get asteroid
     * @param ID is the ad of the asteroid
     * @return the asteroid 
     */
    Asteroid getAsteroid(int ID);
    /**
     * This method get Asteroids By Diameter
     * @param from is the from diameter from one to another
     * @param to  is the to diameter from one to another
     * @return the asteroids 
     */
    List<Asteroid> getAsteroidsByDiameterPlus(double from, double to);
     /**
     * This method get Asteroids By Velocity 
     * @param from is from one Velocity asteroid to another 
     * @param to is to from one Velocity asteroid to another 
     * @return the asteroids 
     */
    List<Asteroid> getAsteroidsByVelocity(double from, double to);
     /**
     * This method get tHazardous Asteroids 
     * @return the asteroids
     */
    List<Asteroid> getHazardousAsteroids();
    /**
     * This method get fastest close approaches
     * @param size is the size of the close approaches
     * @return the close approach list 
     */
    List<CloseApproach> getFastestCloseApproaches(int size);
     /**
     * This method get Biggest probability Of Hitting 
     * @param size is the size of the biggest probability Of Hitting 
     * @return
     */
    List<CloseApproach> getBiggestProbOfHitting(int size);
      /**
     * This method get miss distance of close approach
     * @return miss distance of close approach
     */
    List<CloseApproach> getMissDistanceOfCloseApproach(double from);
      /**
     * This method  get close approaches of planets
     * @param planetName is the planet name of the close approach
     * @return  closeApproachList of the close approach list 
     */
    List<CloseApproach> getCloseApproachesOfPlanets(String planetName);
     /**
     * This method get biggest asteroids
     * @param size of the size of the biggest asteroids 
     * @return AsteroidsList is AsteroidsList of the biggest Asteroids 
     */
    List<Asteroid> getBiggestAsteroids(int size);
    /**
     * This method get smallest asteroids
     * @param size is the size of the smallest asteroids 
     * @return  AsteroidsList is AsteroidsList of the smallest Asteroids 
     */
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
    
}
