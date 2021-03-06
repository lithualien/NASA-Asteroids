package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Web service to fetch data about the asteroids.
 * @author Tomas Dominauskas
 */
@Path("/asteroids")
public class AsteroidResource {
    private Dao dao = new DaoImpl();

    /**
     * Web service method to fetch all asteroids.
     * @return list of all asteroids in JSON format.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAsteroids(){
        return Response.ok(200)
                .entity(dao.getAsteroids())
                .build();
    }

    /**
     * Web service method to fetch a specific asteroid.
     * @param asteroidID the if of the asteroid.
     * @return asteroid object, of selected asteroid.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{asteroidID}")
    public Response getAsteroid(@PathParam("asteroidID") int asteroidID) {
        return Response.ok(200)
                .entity(dao.getAsteroid(asteroidID))
                .build();
    }

    /**
     * Web service method to fetch asteroids of specific entered diameter.
     * @param from the minimum diameter of the asteroid.
     * @param to the maximum diameter of the asteroid.
     * @return the list of asteroids, which qualify for the data.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/diameter")
    public Response getAsteroidsByDiameter(@DefaultValue("0") @QueryParam("from") double from,
                                           @DefaultValue("30")@QueryParam("to") double to) {
        return Response.ok(200)
                .entity(dao.getAsteroidsByDiameterPlus(from, to))
                .build();
    }

    /**
     * Web service method to fetch asteroids of specific entered velocity
     * @param from the minimum velocity of the asteroid.
     * @param to the maximum diameter of the asteroid.
     * @return The list of asteroids, which qualify for the data.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/velocity")
    public Response getAsteroidsByVelocity(@DefaultValue("1") @QueryParam("from") double from,
                                           @DefaultValue("5") @QueryParam("to") double to) {
        return Response.ok(200)
                .entity(dao.getAsteroidsByVelocity(from, to))
                .build();
    }

    /**
     * Web service method to fetch hazardous assteroids.
     * @return The list of hazardous asteroids.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hazardous")
    public Response getHazardousAsteroids() {
        return Response.ok(200)
                .entity(dao.getHazardousAsteroids())
                .build();
    }
    
    /**
     * Web service method for getting biggest asteroids by max diameter
     * @param size amount of returned objects
     * @return The list of the biggest asteroids.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/biggest-asteroids")
    public Response getBiggestAsteroids(
           @DefaultValue("3") @QueryParam("size") int size) {
        return Response.ok(200)
                .entity(dao.getBiggestAsteroids(size))
                .build();
    }
    /**
     * Web service method for getting biggest asteroids by max diameter
     * @param size amount of returned objects
     * @return the list of smallest asteroids.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/smallest-asteroids")
    public Response getSmallestAsteroids(
           @DefaultValue("3") @QueryParam("size") int size) {
        return Response.ok(200)
                .entity(dao.getSmallestAsteroids(size))
                .build();
    }

    /**
     * Web service method to forward the web service to another class, see AsteroidApproachDataResource.
     * @param asteroidID the id of the asteroid.
     * @return the AsteroidApproachDataResource class object.
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{asteroidID}/approach-data")
    public AsteroidApproachDataResource getApproachData(@PathParam("asteroidID") int asteroidID) {
        return new AsteroidApproachDataResource();
    }

    /**
     * Web service method to get the closes approaches.
     * @return The list of closes approaches.
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/close-approaches")
    public CloseApproachResource getCloseApproaches() {
        return new CloseApproachResource();

    }
    /**
     * Web service method for getting biggest asteroids by max diameter
     * @param id id of asteroid
     * @return the list of biggest asteroids.
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAsteroid(
           @PathParam("id") int id) {
        return Response.ok(200)
                .entity(dao.deleteAsteroid(id))
                .build();
    }
    
    /**
     * Web service method that finds asteroid by its name
     * @param name of the asteroid
     * @return asteroid object
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name")
    public Response getAsteroidByName(
           @DefaultValue("1991 BA") @QueryParam("name") String name) {
        return Response.ok(200)
                .entity(dao.getAsteroidByName(name))
                .build();
    }
}
