/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lthualien.Classes;

/**
 *
 * @author Tautvydas
 */
public class Close_approach {
    
    int id;
    int asteroid_id;
    String close_approach_data;
    double relative_velocity;
    double miss_distance;
    String orbit_body;

    public Close_approach(int id, int asteroid_id, String close_approach_data, double relative_velocity, double miss_distance, String orbit_body) {
        this.id = id;
        this.asteroid_id = asteroid_id;
        this.close_approach_data = close_approach_data;
        this.relative_velocity = relative_velocity;
        this.miss_distance = miss_distance;
        this.orbit_body = orbit_body;
    }
    
    /**
     * Default constructor
     */
    public Close_approach() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAsteroid_id() {
        return asteroid_id;
    }

    public void setAsteroid_id(int asteroid_id) {
        this.asteroid_id = asteroid_id;
    }

    public String getClose_approach_data() {
        return close_approach_data;
    }

    public void setClose_approach_data(String close_approach_data) {
        this.close_approach_data = close_approach_data;
    }

    public double getRelative_velocity() {
        return relative_velocity;
    }

    public void setRelative_velocity(double relative_velocity) {
        this.relative_velocity = relative_velocity;
    }

    public double getMiss_distance() {
        return miss_distance;
    }

    public void setMiss_distance(double miss_distance) {
        this.miss_distance = miss_distance;
    }

    public String getOrbit_body() {
        return orbit_body;
    }

    public void setOrbit_body(String orbit_body) {
        this.orbit_body = orbit_body;
    }
    
}
