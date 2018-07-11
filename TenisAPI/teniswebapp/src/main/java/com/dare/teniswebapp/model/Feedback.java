package com.dare.teniswebapp.model;

public class Feedback {
    private int id;
    private String dateTime;
    private int studentID;
    private short rating;
    private String description;

    public int getId() {
        return id;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public short getRating() {
        return rating;
    }
    public void setRating(short rating) {
        this.rating = rating;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
