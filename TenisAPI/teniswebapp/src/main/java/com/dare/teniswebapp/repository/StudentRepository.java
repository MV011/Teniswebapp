package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository {

    //TODO add methods

    public void create(Student student) throws Throwable {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBConn.start();

            statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `Student` (`StudentFirstName`, `StudentLastName`, `StudentBirthDate`, `StudentEmail`, `StudentPhoneNumber`, `StudentSkill`) " +
                    " VALUES ('" + student.getFirstName() + "', '" + student.getLastName() + "', '" + student.getBirthDate() + "', '" + student.getEmail() + "', '" + student.getPhoneNumber() + "', '" + student.getSkill() + "');");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            connection.close();

        }


    }
}
