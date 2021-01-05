package com.orendasoftware.crs.domain.data.api_model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Severity implements Serializable {

    @SerializedName("symptomsSeverity")
    @Expose
    public String symptomsSeverity;

}