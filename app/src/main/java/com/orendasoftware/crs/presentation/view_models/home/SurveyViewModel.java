package com.orendasoftware.crs.presentation.view_models.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.model.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyViewModel extends ViewModel {

    private MutableLiveData<List<Survey>> surveyData;

    public LiveData<List<Survey>> getSurveyData() {
        if(surveyData == null) {
            surveyData = new MutableLiveData<>();
            loadSurveyData();
        }
        return surveyData;
    }

    private void loadSurveyData() {
        List<Survey> surveys = new ArrayList<>();
        surveys.add(new Survey("Ankit Singh", "9333463326", "Yes", "33", "No", "23 May"));
        surveys.add(new Survey("Manish Tiwari", "9945433232", "No", "47", "Yes", "3 Sep"));
        surveys.add(new Survey("Gurpreet Singh", "9578654578", "No", "51", "No", "14 Dec"));
        surveys.add(new Survey("Ajit Patil", "8605546323", "No", "29", "No", "8 Jun"));
        surveys.add(new Survey("Vilas Shinde", "8832746311", "No", "38", "Yes", "12 Mar"));
        surveys.add(new Survey("Ajinkya Thakur", "9333463326", "Yes", "49", "No", "23 May"));
        surveys.add(new Survey("Vishwesh Shah", "9333463326", "No", "47", "Yes", "23 May"));
        surveys.add(new Survey("Arjan Sheikh", "9333463326", "No", "75", "No", "23 May"));
        surveys.add(new Survey("Gaurav Arya", "9333463326", "Yes", "59", "Yes", "23 May"));

        surveyData.setValue(surveys);

    }

}
