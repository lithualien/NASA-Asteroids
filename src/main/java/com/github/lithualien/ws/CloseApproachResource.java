package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;

import javax.enterprise.inject.Default;
import javax.print.attribute.standard.Media;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Class for Close approaches information
 * @author Tautvydas
 */
@Path("/close-approach")
public class CloseApproachResource {
    private Dao dao = new DaoImpl();
    
    /**
     * Web service method for getting fastest close approaches
     * @param size the amounnt of object to be returned in descending order
     * @return Response
     */
    @GET
    @Path("/fastest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFastestCloseApproaches(
                @DefaultValue("5") @QueryParam("size") int size) {
        return Response.ok(200)
                .entity(dao.getFastestCloseApproaches(size))
                .build();
    }
    
    /**
     * Web service method for getting the biggest propability of hitting the orbiting body
     * @param size the amounnt of object to be returned in descending order
     * @return Response
     */
    @GET
    @Path("/biggest-prop")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBiggestProbOfHitting(
               @DefaultValue("5") @QueryParam("size") int size) {
         return Response.ok(200)
                .entity(dao.getBiggestProbOfHitting(size))
                .build();
    }
    
    /**
     * Web service method for getting all approaches from certain height
     * @param from heigh of approaches
     * @return Response
     */
    @GET
    @Path("/miss-distance")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMissDistanceOfCloseApproach(
                @QueryParam("from") double from) {

         return Response.ok(200)
                .entity(dao.getMissDistanceOfCloseApproach(from))
                .build();
    }
    
    /**
     * Web service method for getting close approaches of orbitting body
     * @param planetName name of the planet 
     * @return Response
     */
    @GET
    @Path("/orbit-body")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCloseApproachesOfPlanets(
                @QueryParam("planet_name") String planetName) {
                
         return Response.ok(200)
                .entity(dao.getCloseApproachesOfPlanets(planetName))
                .build();
    }

    /**
     * Web service method to get all close approaches today.
     * @return the list of all close approaches today.
     */
    @GET
    @Path("/today")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCloseApproachToday() {
        return Response.ok(200)
                .entity(dao.getCloseApproachesToday())
                .build();
    }

    /**
     * Web service method to get all past approaches ordered by date from earliest to oldest.
     * @param quantity the quantity of results.
     * @return the list of all close approaches of past approaches by selected size.
     */
    @GET
    @Path("/past")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPastCloseApproaches(@DefaultValue("5") @QueryParam("quantity") int quantity) {
        return Response.ok(200)
                .entity(dao.getPastCloseApproaches(quantity))
                .build();
    }

    /**
     * Web service method to get all future approaches ordered by date from oldest earliest to earliest.
     * @param quantity the quantity of results.
     * @return the list of all close approaches of future approaches by selected size.
     */
    @GET
    @Path("/future")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFutureCloseApproaches(@DefaultValue("5") @QueryParam("quantity") int quantity) {
        return Response.ok(200)
                .entity(dao.getFutureCloseApproaches(quantity))
                .build();
    }
}
