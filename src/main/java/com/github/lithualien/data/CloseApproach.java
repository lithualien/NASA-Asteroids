/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lithualien.data;

/**
 *
 * @author Tautvydas
 */
public class CloseApproach {
    
    int id;
    int asteroidId;
    String closeApproachData;
    double relativeVelocity;
    double missDistance;
    String orbitBody;

    /**
     * 
     * @param id
     * @param asteroidId
     * @param closeApproachData
     * @param relativeVelocity
     * @param missDistance
     * @param orbitBody
     */
    public CloseApproach(int id, int asteroidId, String closeApproachData, double relativeVelocity, double missDistance, String orbitBody) {
        this.id = id;
        this.asteroidId = asteroidId;
        this.closeApproachData = closeApproachData;
        this.relativeVelocity = relativeVelocity;
        this.missDistance = missDistance;
        this.orbitBody = orbitBody;
    }
    
    /**
     * Default constructor
     */
    public CloseApproach() {
        
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
    public int getAsteroidId() {
        return asteroidId;
    }

    /**
     * Set asteroid id
     * @param asteroidId
     */
    public void setAsteroidId(int asteroidId) {
        this.asteroidId = asteroidId;
    }
    

    /**
     * Get apprach appraoch data
     * @return 
     */
    public String getCloseApproachData() {
        return closeApproachData;
    }

    /**
     * Set close approach data
     * @param closeApproachData
     */
    public void setCloseApproachData(String closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    /**
     * get relative velocity
     * @return 
     */
    public double getRelativeVelocity() {
        return relativeVelocity;
    }

    /**
     * set relative velocity
     * @param relativeVelocity
     */
    public void setRelativeVelocity(double relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    /**
     * get miss distance
     * @return 
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * set miss distance
     * @param missDistance
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * get orbit data
     * @return 
     */
    public String getOrbitBody() {
        return orbitBody;
    }

    /**
     * set orbit data
     * @param orbitBody
     */
    public void setOrbitBody(String orbitBody) {
        this.orbitBody = orbitBody;
    }
    
}
