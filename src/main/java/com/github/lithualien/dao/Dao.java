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
    
}
