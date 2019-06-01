package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;

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
}
