package com.dare.teniswebapp.repository;

import com.dare.teniswebapp.dbdriver.DBConn;
import com.dare.teniswebapp.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository {

    //TODO add methods

    public void create(Student student) throws SQLException {

        Connection connection = null;
        Statement statement = null;

//        connection = DBConn.start();
//
//        statement = connection.createStatement();
//
//        System.out.println("INSERT INTO `tenisdb`.`Student` (`StudentFirstName`, `StudentLastName`, `StudentBirthDate`, `StudentEmail`, `StudentPhoneNumber`, `StudentSkill`) " +
//                " ('"+student.getFirstName()+"', '"+student.getLastName()+"', '"+student.getBirthDate()+"', '"+student.getEmail()+"', '"+student.getPhoneNumber()+"', '"+student.getSkill()+"');");
//
//        statement.executeQuery("INSERT INTO `Student` (`StudentFirstName`, `StudentLastName`, `StudentBirthDate`, `StudentEmail`, `StudentPhoneNumber`, `StudentSkill`) " +
//                    " ('"+student.getFirstName()+"', '"+student.getLastName()+"', '"+student.getBirthDate()+"', '"+student.getEmail()+"', '"+student.getPhoneNumber()+"', '"+student.getSkill()+"');");
//
//        statement.close();
//        connection.close();

        System.out.println("SHow me stuff");


    }
}
