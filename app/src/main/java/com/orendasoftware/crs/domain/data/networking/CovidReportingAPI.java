package com.orendasoftware.crs.domain.data.networking;

import com.orendasoftware.crs.domain.data.api_model.DistrictCollection;
import com.orendasoftware.crs.domain.data.api_model.HomeResponse;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.QuarantineResponse;
import com.orendasoftware.crs.domain.data.api_model.StateCollection;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.SurveyResponse;
import com.orendasoftware.crs.domain.data.api_model.SurveyUpdate;
import com.orendasoftware.crs.domain.data.api_model.TahasilCollection;
import com.orendasoftware.crs.domain.data.api_model.VillageCollection;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CovidReportingAPI {

    @GET("login/homeScreen/{email}")
    Call<HomeResponse> getHomeData(@Path("email") String email);

    @POST("survey/save")
    Call<String> saveSurveyData(@Body Survey req);

    @POST("survey/update")
    Call<String> updateSurveyData(@Body SurveyUpdate req);

    @POST("quarantine/save")
    Call<String> saveQuarantineData(@Body Quarantine req);

    @GET("survey/surveyList/{email}")
    Call<List<SurveyResponse>> getSurveyList(@Path("email") String email);

    @GET("quarantine/quarantineList/{email}")
    Call<List<QuarantineResponse>> getQuarantineList(@Path("email") String email);

    @GET("login/stateList")
    Call<StateCollection> getState();

    @GET("login/districtList/{stateId}")
    Call<DistrictCollection> getDistricts(@Path("stateId") int stateId);

    @GET("login/tehsilList/{districtId}")
    Call<TahasilCollection> getTahasil(@Path("districtId") int districtId);

    @GET("login/villageList/{tahsilId}")
    Call<VillageCollection> getVillages(@Path("tahsilId") int tahsilId);

    @GET("survey/edit/{id}")
    Call<Survey> editSurveyDetails(@Path("id") Integer id);

    @GET("quarantine/edit/{id}")
    Call<Quarantine> editQuarantineDetails(@Path("id") Integer id);
}
