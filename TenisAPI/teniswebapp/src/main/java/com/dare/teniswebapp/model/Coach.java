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
        "firstName",
        "lastName",
        "phoneNumber",
        "startDate",
        "feedbackRating"
})
@JsonbPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "phoneNumber",
        "startDate",
        "feedbackRating"
})
public class Coach {

    //TODO does coach type need additional info?

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String startDate;
    private float feedbackRating;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public float getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(float feedbackRating) {
        this.feedbackRating = feedbackRating;
    }
}
