package com.orendasoftware.crs.presentation.view_models.home;

import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.model.Survey;

public class SurveyItemViewModel extends ViewModel {

    private Survey survey;

    public SurveyItemViewModel(Survey survey) {
        this.survey = survey;
    }

    public String getName() {
        return survey.getName();
    }

    public String getMobileNo() {
        return survey.getMobileNo();
    }

    public String getTravelHistory() {
        return survey.getTravelHistory();
    }

    public String getAge() {
        return survey.getAge();
    }

    public String getSymptoms() {
        return survey.getSymptoms();
    }

    public String getDate() {
        return survey.getDate();
    }
}
