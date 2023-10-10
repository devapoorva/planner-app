package com.example.plannerapp.dto;

public class ApplicationForm {
    private String name;
    private String mobileNumber;
    private String email;
    private String source;
    private String destination;
    private String numberOfPerson;
    private String startDate;
    private String endDate;

    public ApplicationForm(String name, String mobileNumber, String email, String source, String destination, String numberOfPerson, String startDate, String endDate) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.source = source;
        this.destination = destination;
        this.numberOfPerson = numberOfPerson;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(String numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
