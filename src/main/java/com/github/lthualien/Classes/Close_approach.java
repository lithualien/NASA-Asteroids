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

    /**
     * 
     * @param id
     * @param asteroid_id
     * @param close_approach_data
     * @param relative_velocity
     * @param miss_distance
     * @param orbit_body 
     */
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
    
    /**
     * Geting ID
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Setting ID
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get asteroid id
     * @return 
     */
    public int getAsteroid_id() {
        return asteroid_id;
    }

    /**
     * Set asteroid id
     * @param asteroid_id 
     */
    public void setAsteroid_id(int asteroid_id) {
        this.asteroid_id = asteroid_id;
    }
    

    /**
     * Get apprach appraoch data
     * @return 
     */
    public String getClose_approach_data() {
        return close_approach_data;
    }

    /**
     * Set close approach data
     * @param close_approach_data 
     */
    public void setClose_approach_data(String close_approach_data) {
        this.close_approach_data = close_approach_data;
    }

    /**
     * get relative velocity
     * @return 
     */
    public double getRelative_velocity() {
        return relative_velocity;
    }

    /**
     * set relative velocity
     * @param relative_velocity 
     */
    public void setRelative_velocity(double relative_velocity) {
        this.relative_velocity = relative_velocity;
    }

    /**
     * get miss distance
     * @return 
     */
    public double getMiss_distance() {
        return miss_distance;
    }

    /**
     * set miss distance
     * @param miss_distance 
     */
    public void setMiss_distance(double miss_distance) {
        this.miss_distance = miss_distance;
    }

    /**
     * get orbit data
     * @return 
     */
    public String getOrbit_body() {
        return orbit_body;
    }

    /**
     * set orbit data
     * @param orbit_body 
     */
    public void setOrbit_body(String orbit_body) {
        this.orbit_body = orbit_body;
    }
    
}
