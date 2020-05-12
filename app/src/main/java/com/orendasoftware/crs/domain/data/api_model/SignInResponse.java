package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alicojocaru on 5/16/2017.
 */

public class SignInResponse {

    @SerializedName("userType")
    private String userType;


    public String getUserType() {
        return userType;
    }
}
