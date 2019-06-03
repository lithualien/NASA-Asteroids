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
public class CloseApproachTest {

    private CloseApproach instance;

    /**
     * This class creates an instance.
     */
    @Before
    public void setUp() {

        instance = new CloseApproach();
    }

    /**
     * This class makes instance null;
     */
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * This class tests ImpactProbability method.
     */
    @Test
    public void testGetImpactProbability() {
        instance.setImpactPropability(1);
        assertEquals(1, 1, instance.getImpactPropability());
    }

    /**
     * This class tests GetLink method.
     */
    @Test
    public void testGetLink() {
        Links link = new Links("www.Linkas.com");
        instance.addLink(link);
        assertTrue(instance.getLink().contains(link));
    }

    /**
     * This class tests GetLinkOfAsteroids method.
     */
    @Test
    public void testGetLinkOfAsteroid() {
        instance.setLinkOfAsteroid("Asteroid");
        assertEquals(instance.getLinkOfAsteroid(), "Asteroid");
    }

    /**
     * This class tests GetID method.
     */
    @Test
    public void testGetId() {
        instance.setId(1);
        assertEquals(1, instance.getId());
    }

    /**
     * This class tests GetAsteroidID method.
     */
    @Test
    public void testGetAsteroidId() {
        instance.setId(1);
        assertEquals(1, instance.getId());
    }

    /**
     * This class tests CloseApproachDate method.
     */
    @Test
    public void testGetCloseApproachDate() {
        instance.setCloseApproachDate("2019-08-15");
        assertEquals(instance.getCloseApproachDate(), "2019-08-15");
    }

    /**
     * This class tests RealitiveVelocity method.
     */
    @Test
    public void testGetRelativeVelocity() {
        instance.setRelativeVelocity(1);
        assertEquals(1, 1, instance.getRelativeVelocity());
    }

    /**
     * This class tests MissDistance method.
     */
    @Test
    public void testGetMissDistance() {
        instance.setMissDistance(1);
        assertEquals(1, 1, instance.getMissDistance());
    }

    /**
     * This class tests GetOrbitBody method.
     */
    @Test
    public void testGetOrbitBody() {
        instance.setOrbitBody("Mars");
        assertEquals(instance.getOrbitBody(), "Mars");
    }

}
