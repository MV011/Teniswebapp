package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Student;
import com.dare.teniswebapp.repository.StudentRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("students")
public class StudentResource {

    //TODO add requests

    private StudentRepository studentRepository = new StudentRepository();

    @POST
    @Path("student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Student createStudentParams(Student student) {

        try {
            studentRepository.create(student);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return student;
    }
}
