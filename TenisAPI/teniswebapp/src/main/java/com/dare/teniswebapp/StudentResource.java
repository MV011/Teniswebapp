package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Student;
import com.dare.teniswebapp.repository.StudentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

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

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public List<Student> retrieveStudents() {

        return studentRepository.getStudents();
    }



}
