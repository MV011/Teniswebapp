package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Student;
import com.dare.teniswebapp.model.Team;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TeamRepository {

    //Update team field for specific students
    private void updateStudentTeams(JsonArray students, int id) throws Throwable {
        for(int i=0; i<students.size(); i++) {
            Student temp = new Student();
            temp.setTeamId(id);
            StudentRepository s = new StudentRepository();
            s.update(students.getJsonObject(i).getInt("id"), temp);
        }
    }

    //Retrieve all teams summary
    public List<Team> getList() throws Throwable {

        List<Team> result = new ArrayList<>();
        Statement statement = null;

        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT TeamID, TeamDateTime FROM Team");

            while(results.next()) {
                JsonReader reader = Json.createReader(new StringReader(results.getString("TeamDateTime")));
                Team tmp = new Team();
                tmp.setId(results.getInt("TeamID"));
                tmp.setDateTime(reader.readObject());

                result.add(tmp);
            }
        }

        return result;
    }

    //Create a new team
    public void create(Team team) throws Throwable {
        Statement statement = null;
        JsonArray students = team.getStudents();

        try (Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Team (TeamDateTime, TeamStudents) VALUES ("+
                    " '"+ team.getDateTime() + "', '" + students.toString() + "');");

            statement.close();
            Statement statement2 = connection.createStatement();
            ResultSet result = statement2.executeQuery("SELECT MAX(TeamID) AS TeamID FROM Team");
            result.first();

            updateStudentTeams(students, result.getInt("TeamID"));

        }
    }

    //Update selected team
    public void update(int teamId, Team update) throws Throwable {

        Statement statement = null;
        try (Connection connection = DBConn.start()) {
            if(update.getDateTime() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Team SET TeamDateTime = '"+update.getDateTime().toString()+"' WHERE TeamID = "+teamId+";");
                statement.close();
            }
            if(update.getStudents() != null) {
                com.google.gson.JsonArray existingStudents;
                JsonParser p = new JsonParser();
                statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT TeamStudents FROM Team WHERE TeamID = "+teamId+";");
                result.first();
                existingStudents = p.parse(result.getString("TeamStudents")).getAsJsonArray();

                //Check to see if any of the existing students have been removed and replaces the assigned team with "0"
                for(int i=0; i<existingStudents.size(); i++) {

                    JsonObject tmp = (JsonObject) existingStudents.get(i);

                    int j;

                    for(j=0; j<update.getStudents().size(); j++) {
                        int compare = update.getStudents().getJsonObject(j).getInt("id");
                        System.out.println("Existing: "+tmp.get("id").getAsInt()+" Check: "+compare);
                        if(tmp.get("id").getAsInt() == compare) {
                            break;
                        }
                    }

                    if(j==update.getStudents().size()) {
                        statement.executeUpdate("UPDATE Student SET TeamID = '0' WHERE StudentID = "+tmp.get("id").getAsInt()+";");
                    }
                }

                statement.executeUpdate("UPDATE Team SET TeamStudents = '"+update.getStudents().toString()+"' WHERE TeamID = "+teamId+";");
                statement.close();

                updateStudentTeams(update.getStudents(), teamId);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    //Get specific team
    public Team get(int teamId) throws Throwable {

        Team team = new Team();
        Statement statement;
        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Team WHERE TeamID = "+teamId+";");
            results.first();

            JsonReader reader = Json.createReader(new StringReader(results.getString("TeamDateTime")));
            team.setId(teamId);
            team.setDateTime(reader.readObject());
            reader.close();
            reader = Json.createReader(new StringReader(results.getString("TeamStudents")));
            team.setStudents(reader.readArray());
        }

        return team;
    }

    //Delete specific team
    public void delete(int teamId) throws Throwable {

        Statement statement = null;
        try (Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            com.google.gson.JsonArray existingStudents;
            JsonParser p = new JsonParser();
            ResultSet result = statement.executeQuery("SELECT TeamStudents FROM Team WHERE TeamID = "+teamId+";");
            result.first();
            existingStudents = p.parse(result.getString("TeamStudents")).getAsJsonArray();

            for(int i=0; i<existingStudents.size(); i++) {

                JsonObject tmp = (JsonObject) existingStudents.get(i);

                statement.executeUpdate("UPDATE Student SET TeamID = '0' WHERE StudentID = "+tmp.get("id").getAsInt()+";");
            }
            statement.executeUpdate("DELETE FROM Team WHERE TeamID = " + teamId + ";");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
