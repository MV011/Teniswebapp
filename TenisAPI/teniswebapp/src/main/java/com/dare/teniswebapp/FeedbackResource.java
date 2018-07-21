package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Feedback;
import com.dare.teniswebapp.repository.FeedbackRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("feedback")
public class FeedbackResource {

    //TODO add requests

    private FeedbackRepository feedbackRepository = new FeedbackRepository();

    //Create feedback - POST http://serveraddress/v1/feedback/coachId/studentId
    @POST
    @Path("{coachId}/{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Feedback createFeedback(@PathParam("coachId") int coachId, @PathParam("studentId") int studentId, Feedback feedback) {

        try {
            feedbackRepository.create(coachId, studentId, feedback);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return feedback;
    }

    //Retrieve feedback summary for coach - GET http://serveraddress/v1/feedback/coachId
    @GET
    @Path("{coachId}")
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public List<Feedback> getCoachFeedback(@PathParam("coachId") int coachId) {

        List<Feedback> results = new ArrayList<>();
        try {
            results = feedbackRepository.getSummary(coachId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return results;
    }

    //Retrieve feedback details - GET http://serveraddress/v1/feedback/details/feedbackId
    @GET
    @Path("details/{feedbackId}")
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Feedback getDetails(@PathParam("feedbackId") int feedbackId) {

        Feedback result = new Feedback();

        try {
            result = feedbackRepository.getDetails(feedbackId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return result;
    }
}
