package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Team;
import com.dare.teniswebapp.repository.TeamRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("teams")
public class TeamResource {

    private TeamRepository teamRepository = new TeamRepository();

    //Create a new team - POST http://serveraddress/v1/teams
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Team createTeam(Team team) {

        try {
            teamRepository.create(team);
        } catch (Throwable e) {
            System.out.println(e);
        }

        return team;
    }

    //Retrieve all teams summary - GET http://serveraddress/v1/teams
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getTeams() {

        List<Team> teams = new ArrayList<>();

        try{
            teams = teamRepository.getList();
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return teams;
    }


    //Retrieve specific team - GET http://serveraddress/v1/teams/{teamId}
    @GET
    @Path("{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Team getTeam(@PathParam("teamId") int teamId) {

        Team result = new Team();

        try {
            result = teamRepository.get(teamId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return result;
    }

    //Update a specific team - PUT http://serveraddress/v1/teams/{teamId}
    @PUT
    @Path("{teamId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Team updateTeam(@PathParam("teamId") int teamId, Team update) {

        try {
            teamRepository.update(teamId, update);
        } catch (Throwable e) {
            System.out.println(e);
        }
        return update;
    }

    //Delete a specific team - DELETE http://serveraddress/v1/teams/{teamId}
    @DELETE
    @Path("{teamId}")
    public void deleteTeam(@PathParam("teamId") int teamId) {

        try {
            teamRepository.delete(teamId);
        } catch (Throwable e) {
            System.out.println(e);
        }
    }
}
