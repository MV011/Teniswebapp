package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {

    //Parse feedback results summary
    private void parseSummaryResults(List<Feedback> students, ResultSet results) throws SQLException {
        while(results.next()) {
            Feedback tmp = new Feedback();
            tmp.setId(results.getInt("FeedbackID"));
            tmp.setDateTime(results.getString("FeedbackDate"));
            tmp.setRating(results.getByte("FeedbackRating"));
            tmp.setDescription(results.getString("FeedbackDescription"));
            tmp.setStudentID(results.getInt("StudentId"));
            students.add(tmp);
        }
    }

    //Create feedback from selected student for specific coach
    public void create(int coachId, int studentId, Feedback feedback) throws Throwable {

        Statement statement = null;

        try (Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Feedback (FeedbackDate, StudentID, CoachID, FeedbackRating, FeedbackDescription) " +
                    "VALUES (CURRENT_DATE, '" + studentId + "', '" + coachId + "', '" + feedback.getRating() + "', \"" + feedback.getDescription() + "\");");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Retrieve feedback summary for specific coach
    public List<Feedback> getSummary(int coachId) throws Throwable {

        List<Feedback> results = new ArrayList<>();

        try(Connection connection = DBConn.start()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FeedbackID, FeedbackDate, FeedbackRating, FeedbackDescription, StudentID FROM Feedback WHERE CoachID = "+coachId+";");
            parseSummaryResults(results,resultSet);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return results;

    }

    //Retrieve details for specific feedback
    public Feedback getDetails(int feedbackId) throws Throwable {

        Feedback result = new Feedback();

        try(Connection connection = DBConn.start()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT FeedbackID, FeedbackDate, FeedbackRating, FeedbackDescription, StudentID, CoachID FROM Feedback WHERE FeedbackID = "+feedbackId);
            resultSet.first();

            result.setId(resultSet.getInt("FeedbackID"));
            result.setDateTime(resultSet.getString("FeedbackDate"));
            result.setRating(resultSet.getByte("FeedbackRating"));
            result.setDescription(resultSet.getString("FeedbackDescription"));
            result.setStudentID(resultSet.getInt("StudentID"));
            result.setCoachID(resultSet.getInt("CoachID"));

        }

        return result;
    }
}
