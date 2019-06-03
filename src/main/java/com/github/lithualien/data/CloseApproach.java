/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lithualien.data;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tautvydas
 */
public class CloseApproach {

    private int id;
    private int asteroidId;
    private String closeApproachDate;
    private double relativeVelocity;
    private double missDistance;
    private String orbitBody;
    private String linkOfAsteroid;
    private double impactPropability; 
    private List<Links> links = new ArrayList();


    /**
     * 
     * @param id - id of asteroid approach data
     * @param asteroidId - id of asteroid
     * @param closeApproachDate - asteroid close approach date 
     * @param relativeVelocity - asteroid relative velocity
     * @param missDistance - asteroid miss distance
     * @param orbitBody - asteroid orbiting body
     * @param impactPropability - propability of hitting the orbiting body
     */
    public CloseApproach(int id, int asteroidId, String closeApproachDate, double relativeVelocity, double missDistance, String orbitBody, double impactPropability) {
        this.id = id;
        this.asteroidId = asteroidId;
        this.closeApproachDate = closeApproachDate;
        this.relativeVelocity = relativeVelocity;
        this.missDistance = missDistance;
        this.orbitBody = orbitBody;
        this.impactPropability = impactPropability;
    }

    /**
     * Gets impact probability
     * @return 
     */
    public double getImpactPropability() {
        return impactPropability;
    }
    
  
     public List<Links> getLink() {
        return links;
    }

    public void addLink(Links link) {
        links.add(link);
    }

    /**
     * Sets impact probability
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
     * Sets Link of asteroid
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
     * Getting ID
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
     * Get approach of approach data
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
    
      /**
     * Method to get the information about the close approach.
     * @return Returns all the data about the close approach to a single String variable.
     */
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return id + ". Asteroid id: " + asteroidId + " | Close Approach Date: " + closeApproachDate + " | Eelative Velocity: " + relativeVelocity + " | Miss Distance: " + missDistance + " | Orbit Body: " + orbitBody + "\n";
    }

}
