package com.orendasoftware.crs.domain.data.api_model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class SignInRequest {

    @NonNull
    @SerializedName("userEmail")
    private String userId;

    @NonNull
    @SerializedName("passsword")
    private String password;

    private SignInRequest(@NonNull String userId, @NonNull String password) {
        this.userId = userId;
        this.password = password;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
