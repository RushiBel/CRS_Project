
package com.orendasoftware.crs.domain.data.api_model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SurveyResponse {

    @SerializedName("srNo")
    @Expose
    private int srNo;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("surUserFName")
    @Expose
    private String surUserFName;
    @SerializedName("surUserMName")
    @Expose
    private String surUserMName;
    @SerializedName("surUserLName")
    @Expose
    private String surUserLName;
    @SerializedName("endusrVillage")
    @Expose
    private String endusrVillage;
    @SerializedName("endUserContactNo")
    @Expose
    private Long endUserContactNo;
    @SerializedName("haveTravelHistory")
    @Expose
    private Boolean haveTravelHistory;
    @SerializedName("haveSymptoms")
    @Expose
    private Boolean haveSymptoms;
    @SerializedName("quarantineType")
    @Expose
    private String quarantineType;
    @SerializedName("surAge")
    @Expose
    private Integer surAge;
    @SerializedName("surDate")
    @Expose
    private Date surDate;

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurUserFName() {
        return surUserFName;
    }

    public void setSurUserFName(String surUserFName) {
        this.surUserFName = surUserFName;
    }

    public String getSurUserMName() {
        return surUserMName;
    }

    public void setSurUserMName(String surUserMName) {
        this.surUserMName = surUserMName;
    }

    public String getSurUserLName() {
        return surUserLName;
    }

    public void setSurUserLName(String surUserLName) {
        this.surUserLName = surUserLName;
    }

    public String getEndusrVillage() {
        return endusrVillage;
    }

    public void setEndusrVillage(String endusrVillage) {
        this.endusrVillage = endusrVillage;
    }

    public Long getEndUserContactNo() {
        return endUserContactNo;
    }

    public void setEndUserContactNo(Long endUserContactNo) {
        this.endUserContactNo = endUserContactNo;
    }

    public Boolean getHaveTravelHistory() {
        return haveTravelHistory;
    }

    public void setHaveTravelHistory(Boolean haveTravelHistory) {
        this.haveTravelHistory = haveTravelHistory;
    }

    public Boolean getHaveSymptoms() {
        return haveSymptoms;
    }

    public void setHaveSymptoms(Boolean haveSymptoms) {
        this.haveSymptoms = haveSymptoms;
    }

    public String getQuarantineType() {
        return quarantineType;
    }

    public void setQuarantineType(String quarantineType) {
        this.quarantineType = quarantineType;
    }

    public Integer getSurAge() {
        return surAge;
    }

    public void setSurAge(Integer surAge) {
        this.surAge = surAge;
    }

    public Date getSurDate() {
        return surDate;
    }

    public void setSurDate(Date surDate) {
        this.surDate = surDate;
    }
}
