package com.orendasoftware.crs.domain.data.model;

public class SurveyRecord {
    Integer id;
    String name;
    String mobileNo;
    String travelHistory;
    String age;
    String symptoms;
    String date;

    public SurveyRecord(Integer id, String name, String mobileNo, String travelHistory, String age, String symptoms, String date) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.travelHistory = travelHistory;
        this.age = age;
        this.symptoms= symptoms;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
