package com.dare.teniswebapp.model;

import javax.json.*;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({
        "id",
        "dateTime",
        "students",
        "coachId"
})
public class Team {

    //TODO Define timeframes in SQL for students/teams

    private int id;
    private JsonObject dateTime;
    private JsonArray students;
    private int coachId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonObject getDateTime() {
        return dateTime;
    }

    public void setDateTime(JsonObject dateTime) {
        this.dateTime = dateTime;
    }

    public JsonArray getStudents() {
        return students;
    }

    public void setStudents(JsonArray students) {
        this.students = students;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }
}
