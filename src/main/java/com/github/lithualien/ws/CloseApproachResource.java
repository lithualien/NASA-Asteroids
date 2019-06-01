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
@Path("/CloseApproarch")
public class CloseApproachResource {
    
    private Dao dao = new DaoImpl();
    
    @GET
    @Path("/fastest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFastest(
                @QueryParam("size") int size) {
                
        return null;
    }
    
    
    
    @GET
    @Path("/biggestProb")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChangeOfHitting(
                @QueryParam("size") int size) {
                
        return null;
    }
    
    
    
}
