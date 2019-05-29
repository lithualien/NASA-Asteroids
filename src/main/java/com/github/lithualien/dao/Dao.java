package com.github.lithualien.dao;

import com.github.lithualien.data.Asteroid;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public interface Dao {
    public List<Asteroid> getAsteroids();
    public Asteroid getAsteroid(int ID);
    public List<Asteroid> getAsteroidsByDiameterPlus(double diameter);
    public List<Asteroid> getAsteroidsByVelocityPlus(double velocity);
    public List<Asteroid> getHazardusAsteroids();
}
