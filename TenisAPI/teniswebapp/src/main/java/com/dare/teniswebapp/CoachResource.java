package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Coach;
import com.dare.teniswebapp.repository.CoachRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("coaches")
public class CoachResource {

    private CoachRepository coachRepository = new CoachRepository();

    @OPTIONS
    public Response options(){
        Response r = Response.ok()
                .build();
        return r;
    }

    //Create coach - POST http://serveraddress/v1/coaches
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Coach createCoach(Coach coach) {

        try {
            coachRepository.create(coach);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return coach;
    }

    //Retrieves CoachID, CoachFirstName, CoachLastName for all coaches - GET http://serveraddress/v1/coaches
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coach> getCoaches() {

        List<Coach> coaches = new ArrayList<>();
        try {
            coaches = coachRepository.getCoaches();
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return coaches;
    }

    //Retrieve all details for specific coach - GET http://serveraddress/v1/coaches/coachId
    @GET
    @Path("{coachId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Coach getCoach(@PathParam("coachId") int coachId) {

        Coach coach = new Coach();

        try {
            coach = coachRepository.getCoach(coachId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return coach;
    }

    //Delete specific coach - DELETE http://serveraddress/v1/coaches/coachId
    @DELETE
    @Path("{coachId}")
    public void deleteCoach(@PathParam("coachId") int coachId) {

        try {
            coachRepository.delete(coachId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }
    }

    //Update specific coach - PUT http://serveraddress/v1/coaches/coachId
    @PUT
    @Path("{coachId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Coach updateCoach(@PathParam("coachId") int coachId, Coach update) {

        try {
            coachRepository.update(coachId, update);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return update;
    }
}
