/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lithualien.data;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Šarūnas
 */
public class LinksTest {

    private Links instance;

    /**
     *This class creates an instance.
     */
    @Before
    public void setUp() {
        instance = new Links();
    }

    /**
     * This class makes instance null;
     */
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     *This class tests GetNasa method.
     */
    @Test
    public void testGetNasa() {
        instance.setNasa("nasa");
        assertEquals(instance.getNasa(), "nasa");
    }

    /**
     *This class tests GetSelf method.
     */
    @Test
    public void testGetSelf() {
        instance.setSelf("self");
        assertEquals(instance.getSelf(), "self");
    }

}
