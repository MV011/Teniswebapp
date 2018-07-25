package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Student;
import com.dare.teniswebapp.model.Team;

import javax.json.Json;
import javax.json.JsonArray;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {

    //Retrieve all teams summary
    public List<Team> getList() throws Throwable {

        List<Team> result = new ArrayList<>();

        return result;
    }

    //Create a new team
    public void create(Team team) throws Throwable {
        Statement statement = null;
        JsonArray students = team.getStudents();
        StudentRepository s = new StudentRepository();

        try (Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Team (TeamDateTime, TeamStudents) VALUES ("+
                    " '"+ team.getDateTime() + "', '" + students.toString() + "');");

            statement.close();
            Statement statement2 = connection.createStatement();
            ResultSet result = statement2.executeQuery("SELECT MAX(TeamID) AS TeamID FROM Team");
            result.first();

            for(int i=0; i<students.size(); i++) {
                Student temp = new Student();
                System.out.println(students.getJsonObject(i).getInt("id"));
                temp.setTeamId(result.getInt("TeamID"));
                s.update(students.getJsonObject(i).getInt("id"), temp);
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //Update selected team
    public void update(int teamId, Team update) throws Throwable {
    }


    //Get specific team
    public Team get(int teamId) throws Throwable {

        return null;
    }

    //Delete specific team
    public void delete(int teamId) throws Throwable {

        //must also set team id to 0 for students
    }
}
