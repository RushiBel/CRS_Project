package com.orendasoftware.crs.presentation.view_models.home.survey;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.model.SurveyRecord;
import com.orendasoftware.crs.domain.data.repository.SurveyRepository;

import java.util.List;

public class SurveyItemViewModel extends ViewModel {

    private SurveyRecord surveyRecord;

    public SurveyItemViewModel(SurveyRecord surveyRecord) {
        this.surveyRecord = surveyRecord;
    }

    public Integer getId() { return surveyRecord.getId(); }

    public String getName() {
        return surveyRecord.getName();
    }

    public String getMobileNo() {
        return surveyRecord.getMobileNo();
    }

    public String getTravelHistory() {
        return surveyRecord.getTravelHistory();
    }

    public String getAge() {
        return surveyRecord.getAge();
    }

    public String getSymptoms() {
        return surveyRecord.getSymptoms();
    }

    public String getDate() {
        return surveyRecord.getDate();
    }
}
