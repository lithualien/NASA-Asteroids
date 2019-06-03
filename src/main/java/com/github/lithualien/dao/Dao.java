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

    /**
     * Get all asteroid's close approaches in the past and the future.
     * @param asteroidID the id of the asteroid.
     * @return the list of all close approaches.
     */
    List<CloseApproach> getCloseApproach(int asteroidID);
}
