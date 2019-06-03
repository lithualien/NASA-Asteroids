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
    String closeApproachDate;
    double relativeVelocity;
    double missDistance;
    String orbitBody;
    String linkOfAsteroid;
    double impactPropability; 

    /**
     * 
     * @param id - id of asteroid approach data
     * @param asteroidId - id of asteroid
     * @param closeApproachDate - asteroid close approach date 
     * @param relativeVelocity - asteroid relative velocity
     * @param missDistance - asteroid miss distance
     * @param orbitBody - asteroid orbiting body
     * @param linkOfAsteroid - link of asteroid
     * @param impactPropability - propability of hitting the orbiting body
     */
    public CloseApproach(int id, int asteroidId, String closeApproachDate, double relativeVelocity, double missDistance, String orbitBody, double impactPropability, String linkOfAsteroid) {
        this.id = id;
        this.asteroidId = asteroidId;
        this.closeApproachDate = closeApproachDate;
        this.relativeVelocity = relativeVelocity;
        this.missDistance = missDistance;
        this.orbitBody = orbitBody;
        this.linkOfAsteroid = linkOfAsteroid;
        this.impactPropability = impactPropability;
    }

    /**
     * Gets impact propability
     * @return 
     */
    public double getImpactPropability() {
        return impactPropability;
    }

    /**
     * Sets impact propability
     * @param impactPropability 
     */
    public void setImpactPropability(double impactPropability) {
        this.impactPropability = impactPropability;
    }

    /**
     * Gets link of asteroid
     * @return 
     */
    public String getLinkOfAsteroid() {
        return linkOfAsteroid;
    }

    /**
     * Sets Ling of asteroid
     * @param linkOfAsteroid 
     */
    public void setLinkOfAsteroid(String linkOfAsteroid) {
        this.linkOfAsteroid = linkOfAsteroid;
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
    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    /**
     * Set close approach data
     * @param closeApproachDate
     */
    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
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
