package com.orendasoftware.crs.domain.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.SurveyUpdate;
import com.orendasoftware.crs.domain.data.networking.CovidReportingAPI;
import com.orendasoftware.crs.domain.deps.module.NetworkModule;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommonRepository {
    private CovidReportingAPI api;

    public CommonRepository() {
        Retrofit retrofit = NetworkModule.getClient();
        api = retrofit.create(CovidReportingAPI.class);
    }

    public void saveSurveyData(Survey survey, MutableLiveData<String> result) {
        Retrofit retrofit = NetworkModule.getClient();
        CovidReportingAPI api = retrofit.create(CovidReportingAPI.class);
        Call<String> surveyCall = api.saveSurveyData(survey);

        surveyCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                result.setValue(call.toString());
            }
        });
    }

    public void updateSurveyData(SurveyUpdate survey, MutableLiveData<String> result) {
        Retrofit retrofit = NetworkModule.getClient();
        CovidReportingAPI api = retrofit.create(CovidReportingAPI.class);
        Call<String> surveyCall = api.updateSurveyData(survey);

        surveyCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                result.setValue(call.toString());
            }
        });
    }

    public void saveQuarantineData(Quarantine quarantine, MutableLiveData<String> result) {
        Retrofit retrofit = NetworkModule.getClient();
        CovidReportingAPI api = retrofit.create(CovidReportingAPI.class);
        quarantine.quaCreatedBy = "amit@gmail.com";
        quarantine.quaStatus = "NEW";
        Call<String> quarantineCall = api.saveQuarantineData(quarantine);

        quarantineCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                result.setValue(call.toString());
            }
        });
    }
}

