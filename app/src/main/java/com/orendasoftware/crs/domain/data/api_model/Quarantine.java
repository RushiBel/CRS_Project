package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Quarantine implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("quaUserFName")
    @Expose
    public String quaUserFName;
    @SerializedName("quaUserMName")
    @Expose
    public String quaUserMName;
    @SerializedName("quaUserLName")
    @Expose
    public String quaUserLName;
    @SerializedName("quaUserAge")
    @Expose
    public Integer quaUserAge;
    @SerializedName("quaUserEmailId")
    @Expose
    public String quaUserEmail;
    @SerializedName("quaUserGender")
    @Expose
    public String quaUserGender;
    @SerializedName("quaPrimaryContactNo")
    @Expose
    public Long quaPrimaryContactNo;
    @SerializedName("quaAlternateContactNo")
    @Expose
    public Long quaAlternateContactNo;
    @SerializedName("aadharNumber")
    @Expose
    public Long aadharNumber;
    @SerializedName("quaUserTravelHstry")
    @Expose
    public Boolean isQuaUserTravelHstry;
    @SerializedName("quaUserTrvlFrom")
    @Expose
    public String quaUserTrvlFrom;
    @SerializedName("quaUserTravelDate")
    @Expose
    public Date quaUserTravelDate;
    @SerializedName("quaTransportType")
    @Expose
    public String quaTransportType;
    @SerializedName("quaUserSymptoms")
    @Expose
    public Boolean isQuaUserSymptoms;
    @SerializedName("quarantineType")
    @Expose
    public String quarantineType;
    @SerializedName("symptomsForQua")
    @Expose
    public SymptomsForQua symptomsForQua;
    @SerializedName("severityForQua")
    @Expose
    public SeverityForQua severityForQua;
    @SerializedName("addressForQua")
    @Expose
    public AddressForQua addressForQua;
    @SerializedName("quaUserEndDate")
    @Expose
    public String quaUserEndDate;
    @SerializedName("quaUserStartDate")
    @Expose
    public String quaUserStartDate;
    @SerializedName("quaCreatedDate")
    @Expose
    public String quaCreatedDate;
    @SerializedName("quaCreatedBy")
    @Expose
    public String quaCreatedBy;
    @SerializedName("quaUserStatus")
    @Expose
    public String quaStatus;
    @SerializedName("quaUpdatedDate")
    @Expose
    public String quaUpdatedDate;
    @SerializedName("quaUpdatedBy")
    @Expose
    public String quaUpdatedBy;
    
}
