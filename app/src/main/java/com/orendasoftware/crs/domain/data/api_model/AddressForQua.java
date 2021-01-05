package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AddressForQua implements Serializable {
    @SerializedName("endusrHouseAddress")
    @Expose
    public String endusrHouseAddress;
    @SerializedName("endusrLandMark")
    @Expose
    public String endusrLandMark;
    @SerializedName("endusrVillage")
    @Expose
    public String endusrVillage;
    @SerializedName("tehsil")
    @Expose
    public String tehsil;
    @SerializedName("endusrDistrict")
    @Expose
    public String endusrDistrict;
    @SerializedName("endusrState")
    @Expose
    public String endusrState;
    @SerializedName("endusrpostalCode")
    @Expose
    public Long endusrpostalCode;
    @SerializedName("endusrAddCreatedDate")
    @Expose
    public String endusrAddCreatedDate;
    @SerializedName("endusrAddModifiedDate")
    @Expose
    public String endusrAddModifiedDate;
    @SerializedName("quaUserStatus")
    @Expose
    public String quaUserStatus;
}
