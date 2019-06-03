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
    public Response getAsteroidsByDiameter(@QueryParam("from") double from,
                                           @QueryParam("to") double to) {
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
    public Response getAsteroidsByVelocity(@QueryParam("from") double from,
                                           @QueryParam("to") double to) {
        return Response.ok(200)
                .entity(dao.getAsteroidsByVelocity(from, to))
                .build();
    }

    /**
     * Web service method to fetch hazardous asteroids.
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
     * Web service method to forward the web service to another class, see AsteroidApproachDataResource.
     * @param asteroidID the id of the asteroid.
     * @return the AsteroidApproachDataResource class object.
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{asteroidID}/approach-data")
    public AsteroidApproachDataResource getApproachData(@PathParam("asteroidID") int asteroidID) {
        return new AsteroidApproachDataResource();
    }
}
