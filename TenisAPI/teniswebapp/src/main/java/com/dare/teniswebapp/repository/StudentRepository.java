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

    //TODO redo responses

    //Parse results
    private void parseResults(List<Student> students, ResultSet results) throws SQLException {
        while(results.next()) {
            Student tmp = new Student();
            tmp.setId(results.getInt("StudentID"));
            tmp.setFirstName(results.getString("StudentFirstName"));
            tmp.setLastName(results.getString("StudentLastName"));
            students.add(tmp);
        }
    }

    //Create a student
    public void create(Student student) throws Throwable {

        Statement statement = null;

        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `Student` (`StudentFirstName`, `StudentLastName`, `StudentBirthDate`, `StudentEmail`, `StudentPhoneNumber`, `StudentSkill`) " +
                    " VALUES ('" + student.getFirstName() + "', '" + student.getLastName() + "', '" + student.getBirthDate() + "', '" + student.getEmail() + "', '" + student.getPhoneNumber() + "', '" + student.getSkill() + "');");
        }
    }

    //Get all students
    public List<Student> getStudents() throws Throwable {

        List<Student> students = new ArrayList<Student>();
        Statement statement = null;
        ResultSet results = null;

        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT StudentID, StudentFirstName, StudentLastName FROM Student;");

            parseResults(students, results);

        }

        return students;

    }

    //Get student by id
    public Student getStudent(int id) throws Throwable {

        Student student = new Student();
        Statement statement = null;
        ResultSet results = null;

        try(Connection connection = DBConn.start()) {
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
            student.setTeamId(results.getInt("TeamID"));

        }

        return student;
    }

    //Update student by id
    public Student update(int studentId, Student revision) throws Throwable {

        Statement statement = null;

        try(Connection connection = DBConn.start()) {

            if(revision.getFirstName() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET StudentFirstName = '"+revision.getFirstName()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
            if(revision.getLastName() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET StudentLastName = '"+revision.getLastName()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
            if(revision.getBirthDate() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET StudentBirthDate = '"+revision.getBirthDate()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
            if(revision.getEmail() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET StudentEmail = '"+revision.getEmail()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
            if(revision.getPhoneNumber() != null) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET StudentPhoneNumber = '"+revision.getPhoneNumber()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
            if(revision.getSkill() != 0) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET StudentSkill = '"+revision.getSkill()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
            if(revision.getTeamId() != 0) {
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE Student SET TeamID = '"+revision.getTeamId()+"' WHERE StudentID = "+studentId+";");
                statement.close();
            }
        }

        return revision;

    }

    //Delete student by id
    public void delete(int studentId) throws Throwable {

        Statement statement = null;

        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Student WHERE StudentID = "+studentId+";");
        }
    }

    //Get unassigned students
    public List<Student> getUnassigned() throws Throwable {

        List<Student> students = new ArrayList<Student>();
        Statement statement = null;
        ResultSet results = null;

        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT StudentID, StudentFirstName, StudentLastName FROM Student WHERE TeamID = 0");

            parseResults(students, results);

        }

        return students;
    }

    //Search for students with approximate first/last names
    public List<Student> getStudents(String studentName) throws Throwable {

        List<Student> students = new ArrayList<Student>();
        Statement statement = null;
        ResultSet results = null;

        try(Connection connection = DBConn.start()) {
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT StudentID, StudentFirstName, StudentLastName FROM Student WHERE StudentFirstName LIKE \"%Test%\" OR StudentLastName LIKE \"%Test%\";");

            parseResults(students, results);

        }

        return students;
    }

}
