package com.github.lithualien.ws;

public class CloseApproachResource {
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tautvydas
 */
@Path("/CloseApproarch")
public class CloseApproachResource {
    
    //private Dao dao = new DaoImpl();
    
    @GET
    @Path("/fastest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFastest(
                @QueryParam("size") int size) {
                
        return Response.ok()
                .entity(dao.))
                .build();
    }
    
    
    
    @GET
    @Path("/biggestProb")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChangeOfHitting(
                @QueryParam("size") int size) {
                
        return Response.ok()
                .entity(dao.))
                .build();
    }
    
    
    
}
