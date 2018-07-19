package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Feedback;
import com.dare.teniswebapp.repository.FeedbackRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("feedback")
public class FeedbackResource {

    //TODO add requests

    private FeedbackRepository feedbackRepository = new FeedbackRepository();

    @POST
    @Path("add/{coachId}/{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Feedback createStudentParams(@PathParam("coachId") int coachId, @PathParam("studentId") int studentId, Feedback feedback) {

        try {
            feedbackRepository.create(coachId, studentId, feedback);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return feedback;
    }
}
