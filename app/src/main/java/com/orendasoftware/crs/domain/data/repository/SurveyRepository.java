package com.orendasoftware.crs.domain.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.SurveyResponse;
import com.orendasoftware.crs.domain.data.model.SurveyRecord;
import com.orendasoftware.crs.domain.data.networking.CovidReportingAPI;
import com.orendasoftware.crs.domain.deps.module.NetworkModule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SurveyRepository {

    private List<SurveyRecord> surveyRecords;
    private CovidReportingAPI api;

    public SurveyRepository() {
        surveyRecords = new ArrayList<>();
        Retrofit retrofit = NetworkModule.getClient();
        api = retrofit.create(CovidReportingAPI.class);
    }

    public void getSurveyList(MutableLiveData<List<SurveyRecord>> liveData) {

        Call<List<SurveyResponse>> surveyCall = api.getSurveyList("amit@gmail.com");

        surveyCall.enqueue(new Callback<List<SurveyResponse>>() {
            @Override
            public void onResponse(Call<List<SurveyResponse>> call, Response<List<SurveyResponse>> response) {
                List<SurveyResponse> surveyResponseList = response.body();
                String name, contactNo = "", travelHistory, hasSymptoms, age = "", date = "";
                Integer id;

                for(int i = 0 ; i < surveyResponseList.size() ; i++) {

                    id = surveyResponseList.get(i).getId();

                    if(surveyResponseList.get(i).getSurUserMName() != null)
                        name = surveyResponseList.get(i).getSurUserFName() + " " + surveyResponseList.get(i).getSurUserMName() + " " + surveyResponseList.get(i).getSurUserLName();
                    else
                        name = surveyResponseList.get(i).getSurUserFName() + " " + surveyResponseList.get(i).getSurUserLName();

                    if(surveyResponseList.get(i).getEndUserContactNo() != null)
                        contactNo = String.valueOf(surveyResponseList.get(i).getEndUserContactNo());

                    if(surveyResponseList.get(i).getSurAge() != null)
                        age = String.valueOf(surveyResponseList.get(i).getSurAge());

                    if(surveyResponseList.get(i).getHaveTravelHistory())
                        travelHistory = "Yes";
                    else
                        travelHistory = "No";

                    if(surveyResponseList.get(i).getHaveSymptoms())
                        hasSymptoms = "Yes";
                    else
                        hasSymptoms = "No";

                    if(surveyResponseList.get(i).getSurDate() != null) {
                        DateFormat dateFormat = new SimpleDateFormat("dd MMMM");
                        date = dateFormat.format(surveyResponseList.get(i).getSurDate());
                    }

                    surveyRecords.add(new SurveyRecord(id, name, contactNo, travelHistory, age,  hasSymptoms, date));
                    liveData.setValue(surveyRecords);

                }

            }

            @Override
            public void onFailure(Call<List<SurveyResponse>> call, Throwable t) {
                System.out.print("ERROR");
            }
        });
    }

    public void getEditSurveyData(Integer id, MutableLiveData<Survey> editSurveyData) {

        Call<Survey> editSurveyCall = api.editSurveyDetails(id);

        editSurveyCall.enqueue(new Callback<Survey>() {
            @Override
            public void onResponse(Call<Survey> call, Response<Survey> response) {
                Survey survey = response.body();
                survey.id = id;
                editSurveyData.setValue(survey);
            }

            @Override
            public void onFailure(Call<Survey> call, Throwable t) {
                System.out.print("ERROR");
            }
        });

    }
}
