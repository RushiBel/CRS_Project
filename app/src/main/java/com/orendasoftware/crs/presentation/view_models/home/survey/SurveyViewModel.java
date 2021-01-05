package com.orendasoftware.crs.presentation.view_models.home.survey;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.model.SurveyRecord;
import com.orendasoftware.crs.domain.data.repository.SurveyRepository;

import java.util.List;

public class SurveyViewModel extends ViewModel {

    private MutableLiveData<List<SurveyRecord>> surveyData;
    private SurveyRepository surveyListRepository;

    private MutableLiveData<Survey> editSurveyData;

    public LiveData<Survey> getEditSurveyData(Integer id) {
        editSurveyData = new MutableLiveData<>();
        surveyListRepository = new SurveyRepository();
        surveyListRepository.getEditSurveyData(id, editSurveyData);
        return editSurveyData;
    }

    public LiveData<List<SurveyRecord>> getSurveyData() {
        surveyData = new MutableLiveData<>();
        surveyListRepository = new SurveyRepository();
        surveyListRepository.getSurveyList(surveyData);
        return surveyData;
    }

}
