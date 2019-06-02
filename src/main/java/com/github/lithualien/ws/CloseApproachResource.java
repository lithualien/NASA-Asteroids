package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tautvydas
 */
@Path("/close_approarch")
public class CloseApproachResource {
    
    private Dao dao = new DaoImpl();
    
    @GET
    @Path("/fastest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFastestCloseApproaches(
                @QueryParam("size") int size) {
                
        return Response.ok(200)
                .entity(dao.getFastestCloseApproaches(size))
                .build();
    }
    
    @GET
    @Path("/biggest_prob")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBiggestProbOfHitting(
                @QueryParam("size") int size) {
                
         return Response.ok(200)
                .entity(dao.getBiggestProbOfHitting(size))
                .build();
    }
    
    @GET
    @Path("/miss_distance")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMissDistanceOfCloseApproach(
                @QueryParam("from") double from) {
                
         return Response.ok(200)
                .entity(dao.getMissDistanceOfCloseApproach(from))
                .build();
    }
}
