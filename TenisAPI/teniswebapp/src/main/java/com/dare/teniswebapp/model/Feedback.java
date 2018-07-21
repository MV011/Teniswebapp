package com.dare.teniswebapp.model;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "id",
        "studentID",
        "coachID",
        "dateTime",
        "rating",
        "description"
})
@JsonbPropertyOrder({
        "id",
        "studentID",
        "coachID",
        "dateTime",
        "rating",
        "description"
})
public class Feedback {
    private int id;
    private String dateTime;
    private int studentID;
    private int coachID;
    private short rating;
    private String description;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
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
    public int getCoachID() { return coachID; }
    public void setCoachID(int coachID) { this.coachID = coachID; }
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
