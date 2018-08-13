package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Student;
import com.dare.teniswebapp.repository.StudentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("students")
public class StudentResource {

    //TODO update responses

    private StudentRepository studentRepository = new StudentRepository();

    @OPTIONS
    public Response optionsRoot(){
        Response r = Response.ok()
                .build();
        return r;
    }

    @OPTIONS
    @Path("{studentId}")
    public Response optionsId(){
        Response r = Response.ok()
                .build();
        return r;
    }

    //Create a new student - POST http://serveraddress/v1/student
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student createStudentParams(Student student) {

        try {
            studentRepository.create(student);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return student;
    }

    //Retrieve all students - GET http://serveraddress/v1/student
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {

        List<Student> students = null;

        try {
            students = studentRepository.getStudents();
        }
        catch(Throwable e) {
            System.out.println(e);
        }
        return students;
    }

    //Get student details - GET http://serveraddress/v1/students/{studentId}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{studentId}")
    public Student getStudent(@PathParam("studentId") int studentId) {

        Student student = null;

        try {
            student = studentRepository.getStudent(studentId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return student;
    }

    //Update student - PUT http://serveraddress/v1/students/{studentId}
    @PUT
    @Path("{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("studentId") int studentId, Student student) {

        Student updated = new Student();
        try {
            updated = studentRepository.update(studentId, student);
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return updated;
    }

    //Delete specific student - DELETE http://serveraddress/v1/students/{studentId}
    @DELETE
    @Path("{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(@PathParam("studentId") int studentId) {

        try {
            studentRepository.delete(studentId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }
    }

    //Get students not in teams - GET http://serveraddress/v1/students/unassigned
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("unassigned")
    public List<Student> getUnassignedStudents() {

        List<Student> students = null;

        try {
            students = studentRepository.getUnassigned();
        }
        catch(Throwable e) {
            System.out.println(e);
        }

        return students;
    }


    //Search for student names - GET http://serveraddress/v1/students/search/{studentName}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search/{studentName}")
    public List<Student> getStudents(@PathParam("studentName") String studentName) {

        List<Student> students = null;

        try {
            students = studentRepository.getStudents(studentName);
        }
        catch(Throwable e) {
            System.out.println(e);
        }
        return students;
    }

}
