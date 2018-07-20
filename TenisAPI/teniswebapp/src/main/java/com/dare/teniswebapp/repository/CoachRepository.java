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

    private void parseResults(List<Coach> students, ResultSet results) throws SQLException {
        while(results.next()) {
            Coach tmp = new Coach();
            tmp.setId(results.getInt("CoachID"));
            tmp.setFirstName(results.getString("CoachFirstName"));
            tmp.setLastName(results.getString("CoachLastName"));
            students.add(tmp);
        }
    }

    public void create(Coach coach) throws Throwable {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBConn.start();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `tenisdb`.`Coach` (`CoachFirstName`, `CoachLastName`, `CoachPhoneNumber`, `CoachStartDate`) " +
                    "VALUES ('"+coach.getFirstName()+"', '"+coach.getLastName()+"', '"+coach.getPhoneNumber()+"', '"+coach.getStartDate()+"');");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            connection.close();

        }
    }

    public List<Coach> getCoaches() throws Throwable {

        List<Coach> coaches = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            connection = DBConn.start();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT CoachID, CoachFirstName, CoachLastName FROM Coach;");

            parseResults(coaches, results);

        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            results.close();
            statement.close();
            connection.close();

        }

        return coaches;
    }
}
