package com.orendasoftware.crs.presentation.view_models.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.orendasoftware.crs.domain.data.api_model.HomeResponse;
import com.orendasoftware.crs.domain.data.repository.HomeRepository;

public class HomeViewModel extends AndroidViewModel {

    private String todaysSurveyCount;
    private String todaysRelocationCount;
    private String todaysQuarantinedCount;
    private String totalSurveyCount;
    private String totalRelocationCount;
    private String totalQuarantinedCount;

    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homeRepository=new HomeRepository();
    }

    public String getTodaysSurveyCount() {
        return todaysSurveyCount;
    }

    public void setTodaysSurveyCount(String todaysSurveyCount) {
        this.todaysSurveyCount = todaysSurveyCount;
    }

    public String getTodaysRelocationCount() {
        return todaysRelocationCount;
    }

    public void setTodaysRelocationCount(String todaysRelocationCount) {
        this.todaysRelocationCount = todaysRelocationCount;
    }

    public String getTodaysQuarantinedCount() {
        return todaysQuarantinedCount;
    }

    public void setTodaysQuarantinedCount(String todaysQuarantinedCount) {
        this.todaysQuarantinedCount = todaysQuarantinedCount;
    }

    public String getTotalSurveyCount() {
        return totalSurveyCount;
    }

    public void setTotalSurveyCount(String totalSurveyCount) {
        this.totalSurveyCount = totalSurveyCount;
    }

    public String getTotalRelocationCount() {
        return totalRelocationCount;
    }

    public void setTotalRelocationCount(String totalRelocationCount) {
        this.totalRelocationCount = totalRelocationCount;
    }

    public String getTotalQuarantinedCount() {
        return totalQuarantinedCount;
    }

    public void setTotalQuarantinedCount(String totalQuarantinedCount) {
        this.totalQuarantinedCount = totalQuarantinedCount;
    }

    public LiveData<HomeResponse> getHomeScreenData() {
        return homeRepository.getHomeData();
    }
}
