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
 * Class to define all the attributes about the asteroid.
 * @author Andrius Venckus
 */
public class Asteroid {
    
    // variables
    private int ID;
    private String object_link, name;
    private double vInfinity, estimated_diameter_max, estimated_diameter_min;
    private boolean potential_hazardous;
    private List<Links> links = new ArrayList();

    /**
     * Class constructor
     */
    public Asteroid() {

    }

    /**
     * Class constructor to set all the variables about the asteroid.
     * @param ID the id of the asteroid.
     * @param name the name of the asteroid.
     * @param vInfinity the vInfinity of the asteroid.
     * @param estimated_diameter_max the estimated_diameter_max of the asteroid.
     * @param estimated_diameter_min the estimated_diameter_min of the asteroid.
     * @param potential_hazardous the potential_hazardous of the asteroid.
     */
    public Asteroid(int ID, String name, double vInfinity, double estimated_diameter_max, double estimated_diameter_min, boolean potential_hazardous) {
        this.ID = ID;
        this.name = name;
        this.vInfinity = vInfinity;
        this.estimated_diameter_max = estimated_diameter_max;
        this.estimated_diameter_min = estimated_diameter_min;
        this.potential_hazardous = potential_hazardous;
    }

    /**
     * Method to set the id of the asteroid.
     * @param ID the id of the asteroid.
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Adds link to LinksList 
     * @param link link of object
     */
    public void addLink(Links link) {
        links.add(link);
    }
    
    /**
     * Returns List of objects 
     * @return links list
     */
     public List<Links> getLinks() {
        return links;
    }

    /**
     * Method to set the object_link of the asteroid.
     * @param object_link the object link of the asteroid.
     */
    public void setObjectLink(String object_link) {
        this.object_link = object_link;
    }

    /**
     * Method to set the name of the asteroid.
     * @param name the name of the asteroid.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to set the vInfinity of the asteroid.
     * @param vInfinity the vInfinity of the asteroid.
     */
    public void setVInfinity(double vInfinity) {
        this.vInfinity = vInfinity;
    }

    /**
     * Method to set the estimated_diameter_max of the asteroid.
     * @param estimated_diameter_max the estimated_diameter_max of the asteroid.
     */
    public void setEstimatedDiameterMax(double estimated_diameter_max) {
        this.estimated_diameter_max = estimated_diameter_max;
    }

    /**
     * Method to set the amount of estimated_diameter_min of the asteroid.
     * @param estimated_diameter_min the estimated_diameter_min of the asteroid
     */
    public void setEstimatedDiameterMin(double estimated_diameter_min) {
        this.estimated_diameter_min = estimated_diameter_min;
    }

    /**
     * Method to set the potential_hazardous of the asteroid.
     * @param potential_hazardous the potential_hazardous  of the asteroid.
     */
    public void setPotentialHazardous(boolean potential_hazardous) {
        this.potential_hazardous = potential_hazardous;
    }
    
    /**
     * Method to get the ID of the asteroid.
     * @return the value of the ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Method to get the object_link of the asteroid.
     * @return the value of the object_link.
     */
    public String getObjectLink() {
        return object_link;
    }

    /**
     * Method to get the name of the asteroid.
     * @return the value of the name type.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the vInfinity of the asteroid.
     * @return the vInfinity of the asteroid.
     */
    public double getVInfinity() {
        return vInfinity;
    }

    /**
     * Method to get the estimated_diameter_max of the asteroid.
     * @return the estimated_diameter_max of the asteroid.
     */
    public double getEstimatedDiameterMax() {
        return estimated_diameter_max;
    }

    /**
     * Method to get the estimated_diameter_min of the asteroid.
     * @return the estimated_diameter_min of the asteroid.
     */
    public double getEstimatedDiameterMin() {
        return estimated_diameter_min;
    }

    /**
     * Method to get the potential_hazardous true or false of the asteroid.
     * @return the potential_hazardous return true or false of the asteroid
     */
    public boolean getPotentialHazardous() {
        return potential_hazardous;
    }

    /**
     * Method to get the information about the asteroid.
     * @return Returns all the data about the asteroid to a single String variable.
     */
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return ID + ". Object link: " + object_link + " | Name: " + name + " | vInfinity: " + vInfinity + " | Estimated Diameter Max: " + estimated_diameter_max + " | Estimated Diameter Min: " + estimated_diameter_min + " | Potential Hazardous: " + potential_hazardous + "\n";
    }

}
