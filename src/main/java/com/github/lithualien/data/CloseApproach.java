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
 * Class to define all the attributes about the close Approach.
 * @author Tautvydas
 * @author Andrius Venckus
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
     * @param impactPropability - probability of hitting the orbiting body
     */
    public CloseApproach(int id, int asteroidId, String closeApproachDate, double relativeVelocity, double missDistance, double impactPropability) {
        this.id = id;
        this.asteroidId = asteroidId;
        this.closeApproachDate = closeApproachDate;
        this.relativeVelocity = relativeVelocity;
        this.missDistance = missDistance;
        this.impactPropability = impactPropability;
    }

    /**
     * Gets impact probability
     * @return impactPropability of the close Approach
     */
    public double getImpactPropability() {
        return impactPropability;
    }

    /**
     * Gets links of the close approach.
     * @return links of the close Approach
     */
     public List<Links> getLink() {
        return links;
    }
     
     public void setLinks(List<Links> links) {
        this.links = links;
    }

    /**
     * This method add to list
     * @param link add to links list
     */
    public void addLink(Links link) {
        links.add(link);
    }

    /**
     * This method sets impact probability for the close approach
     * @param impactPropability is the impactPropability of the close approach
     */
    public void setImpactPropability(double impactPropability) {
        this.impactPropability = impactPropability;
    }

    /**
     * This method gets link of asteroid
     * @return  the link of the asteroid
     */
    public String getLinkOfAsteroid() {
        return linkOfAsteroid;
    }

    /**
     * This method sets Link of asteroid
     * @param linkOfAsteroid set the link of the asteroid
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
     * This method getting ID of the close approach
     * @return id of the close approach
     */
    public int getId() {
        return id;
    }

    /**
     * This method setting ID of the close approach
     * @param id  is id of the close approach
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method get asteroid id of the close approach
     * @return  asteroidId of the close approach
     */
    public int getAsteroidId() {
        return asteroidId;
    }

    /**
     * This method set asteroid id for the close approach
     * @param asteroidId get asteroid id
     */
    public void setAsteroidId(int asteroidId) {
        this.asteroidId = asteroidId;
    }


    /**
     * This method get approach of approach data
     * @return closeApproachDate of the close approach date
     */
    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    /**
     * This method set close approach data
     * @param closeApproachDate is close approach date of the approach data
     */
    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    /**
     * This method get relative velocity
     * @return relativeVelocity of the relative velocity
     */
    public double getRelativeVelocity() {
        return relativeVelocity;
    }

    /**
     * This method set relative velocity
     * @param relativeVelocity
     */
    public void setRelativeVelocity(double relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    /**
     *  This method get miss distance
     * @return missDistance of the close approach
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * This method set miss distance
     * @param missDistance of the close approach
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * This method get orbit data
     * @return orbitBody of the close approach
     */
    public String getOrbitBody() {
        return orbitBody;
    }

    /**
     * This method set orbit data
     * @param orbitBody is the orbit Body of the close approach
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
