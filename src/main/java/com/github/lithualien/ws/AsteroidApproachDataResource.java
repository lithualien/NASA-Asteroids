package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AsteroidApproachDataResource {
    private Dao dao = new DaoImpl();

    /**
     * Web service method to get all close approaches of specific asteroid.
     * @param asteroidID the id of the asteroid.
     * @return the list of all close approaches of specific asteroid.
     */
    @GET
    @PathParam(MediaType.APPLICATION_JSON)
    public Response getCloseApproach(@PathParam("asteroidID") int asteroidID) {
        return Response.ok(200)
                .entity(dao.getCloseApproaches(asteroidID))
                .build();
    }
}
