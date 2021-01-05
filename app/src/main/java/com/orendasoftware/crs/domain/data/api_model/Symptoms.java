package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Symptoms implements Serializable {

    @SerializedName("cold")
    @Expose
    public Boolean cold;
    @SerializedName("cough")
    @Expose
    public Boolean cough;
    @SerializedName("fever")
    @Expose
    public Boolean fever;
    @SerializedName("breathingDifficulty")
    @Expose
    public Boolean breathingDifficulty;
    @SerializedName("otherSymptoms")
    @Expose
    public String otherSymptoms;

}
