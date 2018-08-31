package com.dare.teniswebapp.model;

import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "birthDate",
        "joinDate",
        "email",
        "phoneNumber",
        "skill",
        "teamId"
})
public class Student {

    //TODO anything missing? needs review
    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String joinDate;
    private String email;
    private String phoneNumber;
    private short skill;
    private int teamId;
    private JsonObject availability;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public short getSkill() {
        return skill;
    }
    public void setSkill(short skill) {
        this.skill = skill;
    }
    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public JsonObject getAvailability() {
        return availability;
    }
    public void setAvailability(JsonObject availability) {
        this.availability = availability;
    }
}
