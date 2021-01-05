package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class SurveyUpdate implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("surUserResidentType")
    @Expose
    public String surUserResidentType;
    @SerializedName("surUserTrvlFrom")
    @Expose
    public String surUserTrvlFrom;
    @SerializedName("surUserTravelDate")
    @Expose
    public Date surUserTravelDate;
    @SerializedName("transportType")
    @Expose
    public String transportType;
    @SerializedName("symptoms")
    @Expose
    public Symptoms symptoms;
    @SerializedName("severity")
    @Expose
    public Severity severity;
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
    @SerializedName("surUserSymptoms")
    @Expose
    public Boolean surUserSymptoms;
    @SerializedName("surUserTravelHstry")
    @Expose
    public Boolean surUserTravelHstry;
}
