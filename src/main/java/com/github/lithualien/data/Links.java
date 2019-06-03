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
    
    public Links(String self)
    {
        this.self = self;
    }
    
    public Links(String self, String nasa, String closeApproach)
    {
        this.nasa = nasa;
        this.self = self;
        this.closeApproach = closeApproach;
    }
    
     public void setSelf(String self) {
        this.self = self;
    }
     

    public String getNasa() {
        return nasa;
    }

    public void setNasa(String nasa) {
        this.nasa = nasa;
    }
    
    public String getSelf() {
        return self;
    }
}
