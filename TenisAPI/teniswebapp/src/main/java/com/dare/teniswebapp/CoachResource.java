package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Coach;
import com.dare.teniswebapp.repository.CoachRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("coaches")
public class CoachResource {

    CoachRepository coachRepository = new CoachRepository();

    @POST
    @Path("coach")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Coach createCoach(Coach coach) {

        try {
            coachRepository.create(coach);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return coach;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
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
}
