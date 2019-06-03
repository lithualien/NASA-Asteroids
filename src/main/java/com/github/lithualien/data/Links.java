/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lithualien.data;

/**
 * This class create links
 * @author Tautvydas
 * @author Andrius Venckus
 */
public class Links {
    private String self;
    private String nasa;
    private String closeApproach;

    
    public String getCloseApproach() {
        return closeApproach;
    }

    public void setCloseApproach(String closeApproach) {
        this.closeApproach = closeApproach;
    }
    
       /**
     * Constructor to set the variables about the link.
     * @param self is self of the link to the nasa website of the asteroid 
     */
    public Links(String self)
    {
        this.self = self;
    }
    
    public Links(String self, String nasa, String closeApproach)
    /**
     * Constructor to set the variables about the link.
     * @param self is self of the link to the nasa website of the asteroid 
     * @param nasa is nasa of the link to the nasa website of the asteroid 
     * @param closeApproach link of close approach 
     */
    {
        this.nasa = nasa;
        this.self = self;
        this.closeApproach = closeApproach;
    }
    
    /**
     * Constructor to set the variables about the link.
     * @param self is self of the link to the nasa website of the asteroid 
     */
    public void setSelf(String self) {
        this.self = self;
    }
     
    /**
     * Method to get the link .
     * @return  the nasa of the link
     */
    public String getNasa() {
        return nasa;
    }

    /**
     * Constructor to set the variables about the link.
     * @param nasa is nasa of the link to the nasa website of the asteroid 
     */
    public void setNasa(String nasa) {
        this.nasa = nasa;
    }
    
    /**
     * Method to get the link .
     * @return  the self of the link
     */
    public String getSelf() {
        return self;
    }
}
