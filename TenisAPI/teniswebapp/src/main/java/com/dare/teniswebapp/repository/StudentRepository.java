package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Student> getStudents() throws Throwable {

        List<Student> students = new ArrayList<Student>();
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            connection = DBConn.start();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT StudentID, StudentFirstName, StudentLastName FROM Student;");

            parseResults(students, results);

        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            results.close();
            statement.close();
            connection.close();

        }

        return students;

    }

    public Student getStudent(int id) throws Throwable {

        Student student = new Student();
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            connection = DBConn.start();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT * FROM Student WHERE StudentID="+id+";");

            results.first();
            student.setId(results.getInt("StudentID"));
            student.setFirstName(results.getString("StudentFirstName"));
            student.setLastName(results.getString("StudentLastName"));
            student.setBirthDate(String.valueOf(results.getDate("StudentBirthDate")));
            student.setEmail(results.getString("StudentEmail"));
            student.setPhoneNumber(results.getString("StudentPhoneNumber"));
            student.setSkill((short) results.getInt("StudentSkill"));

        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            results.close();
            statement.close();
            connection.close();

        }

        return student;
    }

    public List<Student> getStudents(String studentName) throws Throwable {

        List<Student> students = new ArrayList<Student>();
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            connection = DBConn.start();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT StudentID, StudentFirstName, StudentLastName FROM Student WHERE StudentFirstName LIKE \"%Test%\" OR StudentLastName LIKE \"%Test%\";");

            parseResults(students, results);

        }
        catch(SQLException e) {
            System.out.println(e);
        }
        finally {
            results.close();
            statement.close();
            connection.close();

        }

        return students;
    }

    private void parseResults(List<Student> students, ResultSet results) throws SQLException {
        while(results.next()) {
            Student tmp = new Student();
            tmp.setId(results.getInt("StudentID"));
            tmp.setFirstName(results.getString("StudentFirstName"));
            tmp.setLastName(results.getString("StudentLastName"));
            students.add(tmp);
        }
    }
}
