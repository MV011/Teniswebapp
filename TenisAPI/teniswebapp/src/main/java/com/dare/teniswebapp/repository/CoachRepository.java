package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Coach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    //Iterates through a results set
    private void parseResults(List<Coach> students, ResultSet results) throws SQLException {
        while(results.next()) {
            Coach tmp = new Coach();
            tmp.setId(results.getInt("CoachID"));
            tmp.setFirstName(results.getString("CoachFirstName"));
            tmp.setLastName(results.getString("CoachLastName"));
            students.add(tmp);
        }
    }

    //Create coach
    public void create(Coach coach) throws Throwable {

        Statement statement = null;

        try (Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `tenisdb`.`Coach` (`CoachFirstName`, `CoachLastName`, `CoachPhoneNumber`, `CoachStartDate`) " +
                    "VALUES ('" + coach.getFirstName() + "', '" + coach.getLastName() + "', '" + coach.getPhoneNumber() + "', '" + coach.getStartDate() + "');");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Update a specific coach
    public void update(int coachId, Coach update) throws Throwable {

        Statement statement = null;

        try (Connection connection = DBConn.start()) {

            if (update.getPhoneNumber() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Coach SET CoachPhoneNumber = '" + update.getPhoneNumber() + "' WHERE CoachID = " + coachId + ";");
                statement.close();
            }
            if (update.getFirstName() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Coach SET CoachFirstName = '" + update.getFirstName() + "' WHERE CoachID = " + coachId + ";");
                statement.close();
            }
            if (update.getLastName() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Coach SET CoachLastName = '" + update.getLastName() + "' WHERE CoachID = " + coachId + ";");
                statement.close();
            }
            if (update.getStartDate() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Coach SET CoachStartDate = '" + update.getStartDate() + "' WHERE CoachID = " + coachId + ";");
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Delete the selected coach
    public void delete(int coachId) throws Throwable {

        try(Connection connection = DBConn.start()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Coach WHERE CoachID = "+coachId+";");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    //Retrieve all coaches (FirstName, LastName, ID)
    public List<Coach> getCoaches() throws Throwable {

        List<Coach> coaches = new ArrayList<>();

        try (Connection connection = DBConn.start()) {
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery("SELECT CoachID, CoachFirstName, CoachLastName FROM Coach;");
             parseResults(coaches, results);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return coaches;
    }

    //Retrieve a specific coach
    public Coach getCoach(int coachId) throws Throwable{

        Coach coach = new Coach();

        try (Connection connection = DBConn.start()) {

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT CoachID, CoachFirstName, CoachLastName, CoachStartDate, CoachPhoneNumber FROM Coach " +
                "WHERE CoachID = " + coachId + ";");

            results.first();
            coach.setId(results.getInt("CoachID"));
            coach.setFirstName(results.getString("CoachFirstName"));
            coach.setLastName(results.getString("CoachLastName"));
            coach.setPhoneNumber(results.getString("CoachPhoneNumber"));
            coach.setStartDate(results.getString("CoachStartDate"));
        } catch (SQLException e) {
            System.out.println(e);
        }

        return coach;
    }

}
