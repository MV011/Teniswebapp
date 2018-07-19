package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Feedback;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackRepository {

    public void create(int coachId, int studentId, Feedback feedback) throws Throwable {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBConn.start();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Feedback (FeedbackDate, StudentID, CoachID, FeedbackRating, FeedbackDescription) " +
                    "VALUES (CURRENT_DATE, '"+coachId+"', '"+studentId+"', '"+feedback.getRating()+"', \""+feedback.getDescription()+"\");");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            connection.close();

        }
    }
}
