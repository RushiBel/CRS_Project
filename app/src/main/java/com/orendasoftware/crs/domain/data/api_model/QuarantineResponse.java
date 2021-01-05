package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class QuarantineResponse implements Serializable {

    @SerializedName("srNo")
    @Expose
    private Integer srNo;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("quaFName")
    @Expose
    private String quaFName;
    @SerializedName("quaMName")
    @Expose
    private String quaMName;
    @SerializedName("quaLName")
    @Expose
    private String quaLName;
    @SerializedName("quaContactNumber")
    @Expose
    private Long quaContactNumber;
    @SerializedName("quarantineType")
    @Expose
    private String quarantineType;
    @SerializedName("isTraveledHistory")
    @Expose
    private Boolean isTraveledHistory;
    @SerializedName("isSymptoms")
    @Expose
    private Boolean isSymptoms;
    @SerializedName("quaStartDate")
    @Expose
    private Date quaStartDate;
    @SerializedName("quaEndDate")
    @Expose
    private Date quaEndDate;
    @SerializedName("quaUserStatus")
    @Expose
    private String quaStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getQuaFName() {
        return quaFName;
    }

    public void setQuaFName(String quaFName) {
        this.quaFName = quaFName;
    }

    public String getQuaMName() {
        return quaMName;
    }

    public void setQuaMName(String quaMName) {
        this.quaMName = quaMName;
    }

    public String getQuaLName() {
        return quaLName;
    }

    public void setQuaLName(String quaLName) {
        this.quaLName = quaLName;
    }

    public Long getQuaContactNumber() {
        return quaContactNumber;
    }

    public void setQuaContactNumber(Long quaContactNumber) {
        this.quaContactNumber = quaContactNumber;
    }

    public String getQuarantineType() {
        return quarantineType;
    }

    public void setQuarantineType(String quarantineType) {
        this.quarantineType = quarantineType;
    }

    public Boolean getIsTraveledHistory() {
        return isTraveledHistory;
    }

    public void setIsTraveledHistory(Boolean isTraveledHistory) {
        this.isTraveledHistory = isTraveledHistory;
    }

    public Boolean getIsSymptoms() {
        return isSymptoms;
    }

    public void setIsSymptoms(Boolean isSymptoms) {
        this.isSymptoms = isSymptoms;
    }

    public Date getQuaStartDate() {
        return quaStartDate;
    }

    public void setQuaStartDate(Date quaStartDate) {
        this.quaStartDate = quaStartDate;
    }

    public Date getQuaEndDate() {
        return quaEndDate;
    }

    public void setQuaEndDate(Date quaEndDate) {
        this.quaEndDate = quaEndDate;
    }

    public String getQuaStatus() {
        return quaStatus;
    }

    public void setQuaStatus(String quaStatus) {
        this.quaStatus = quaStatus;
    }

}
