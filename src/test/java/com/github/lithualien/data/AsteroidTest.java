/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lithualien.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Šarūnas
 */
public class AsteroidTest {

    private Asteroid instance;

    /**
     *This class creates an instance.
     */
    @Before
    public void setUp() {
        instance = new Asteroid();
    }

    /**
     *This class makes instance null;
     */
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     *This class tests GetLinks method.
     */
    @Test
    public void testGetLinks() {
        Links link = new Links("www.Linkas.com");
        instance.addLink(link);
        assertTrue(instance.getLinks().contains(link));
    }

    /**
     *This class tests GetID method.
     */
    @Test
    public void testGetID() {
        instance.setID(1);
        assertEquals(1, instance.getID());
    }

    /**
     *This class tests GetObjectLink method.
     */
    @Test
    public void testGetObjectLink() {
        instance.setObjectLink("www.Linkas.com");
        assertEquals(instance.getObjectLink(), "www.Linkas.com");
    }

    /**
     *This class tests GetName method.
     */
    @Test
    public void testGetName() {
        instance.setName("Asteroidas");
        assertEquals(instance.getName(), "Asteroidas");
    }

    /**
     *This class tests GetVInfinity method.
     */
    @Test
    public void testGetVInfinity() {
        instance.setVInfinity(999);
        assertEquals(999, 999, instance.getVInfinity());
    }

    /**
     *This class tests GetEstimatedDiameterMax method.
     */
    @Test
    public void testGetEstimatedDiameterMax() {
        instance.setEstimatedDiameterMax(100);
        assertEquals(100, 100, instance.getEstimatedDiameterMax());
    }

    /**
     *This class tests GetEstimatedDiameterMin method.
     */
    @Test
    public void testGetEstimatedDiameterMin() {
        instance.setEstimatedDiameterMin(10);
        assertEquals(10, 10, instance.getEstimatedDiameterMin());
    }

    /**
     *This class tests GetPotentialHazardous method.
     */
    @Test
    public void testGetPotentialHazardous() {
        instance.setPotentialHazardous(true);
        assertEquals(instance.getPotentialHazardous(), true);
    }

}
