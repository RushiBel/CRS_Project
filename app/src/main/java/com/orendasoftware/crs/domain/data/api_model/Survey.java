package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Survey implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("surUserFName")
    @Expose
    public String surUserFName;
    @SerializedName("surUserMName")
    @Expose
    public String surUserMName;
    @SerializedName("surUserLName")
    @Expose
    public String surUserLName;
    @SerializedName("surUserResidentType")
    @Expose
    public String surUserResidentType;
    @SerializedName("surUserAge")
    @Expose
    public Integer surUserAge;
    @SerializedName("surUserEmailId")
    @Expose
    public String surUserEmail;
    @SerializedName("aadharNumber")
    @Expose
    public Long aadharNumber;
    @SerializedName("surUserGender")
    @Expose
    public String surUserGender;
    @SerializedName("primaryContactNo")
    @Expose
    public Long primaryContactNo;
    @SerializedName("alternateContactNo")
    @Expose
    public Long alternateContactNo;
    @SerializedName("surUserTravelHstry")
    @Expose
    public Boolean isSurUserTravelHstry;
    @SerializedName("surUserTrvlFrom")
    @Expose
    public String surUserTrvlFrom;
    @SerializedName("transportType")
    @Expose
    public String transportType;
    @SerializedName("surUserTravelDate")
    @Expose
    public Date surUserTravelDate;
    @SerializedName("surUserSymptoms")
    @Expose
    public Boolean isSurUserSymptoms;
    @SerializedName("symptoms")
    @Expose
    public Symptoms symptoms;
    @SerializedName("severity")
    @Expose
    public Severity severity;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("surCreatedDate")
    @Expose
    public String surCreatedDate;
    @SerializedName("surCreatedBy")
    @Expose
    public String surCreatedBy;
    @SerializedName("surUpdatedDate")
    @Expose
    public String surUpdatedDate;
    @SerializedName("surUpdatedBy")
    @Expose
    public String surUpdatedBy;

}

