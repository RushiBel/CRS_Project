package com.orendasoftware.crs.domain.data.networking;

import com.orendasoftware.crs.domain.NetworkConfig;
import com.orendasoftware.crs.domain.data.api_model.SignInRequest;
import com.orendasoftware.crs.domain.data.api_model.SignInResponse;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EnrollmentAPI {

    @POST("login")
    @Headers(NetworkConfig.HEADER_CONTENT_TYPE)
    SignInResponse getSignInData(@Body SignInRequest req);
}
