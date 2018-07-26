package com.dare.teniswebapp;

import com.dare.teniswebapp.model.Student;
import com.dare.teniswebapp.repository.StudentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("students")
public class StudentResource {

    //TODO update responses

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

    @PUT
    @Path("{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
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

    @DELETE
    @Path("{studentId}")
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("studentId") int studentId) {

        try {
            studentRepository.delete(studentId);
        }
        catch(Throwable e) {
            System.out.println(e);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
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

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
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

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
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

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
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
