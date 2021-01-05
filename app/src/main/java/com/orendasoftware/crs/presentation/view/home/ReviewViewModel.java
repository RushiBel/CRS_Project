package com.orendasoftware.crs.presentation.view.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.SurveyUpdate;
import com.orendasoftware.crs.domain.data.repository.CommonRepository;

public class ReviewViewModel extends ViewModel {
    Survey survey;
    private CommonRepository commonRepository;
    MutableLiveData<String> fullName = new MutableLiveData<>();
    MutableLiveData<String> gender = new MutableLiveData<>();
    MutableLiveData<String> age = new MutableLiveData<>();
    MutableLiveData<String> houseNo = new MutableLiveData<>();
    MutableLiveData<String> village = new MutableLiveData<>();
    MutableLiveData<String> landmark = new MutableLiveData<>();
    MutableLiveData<String> tahasil = new MutableLiveData<>();
    MutableLiveData<String> district = new MutableLiveData<>();
    MutableLiveData<String> state = new MutableLiveData<>();
    MutableLiveData<String> primaryMobile = new MutableLiveData<>();
    MutableLiveData<String> alternateMobile = new MutableLiveData<>();
    MutableLiveData<String> email = new MutableLiveData<>();
    MutableLiveData<String> travelHistory = new MutableLiveData<>();
    MutableLiveData<String> symptoms = new MutableLiveData<>();
    MutableLiveData<String> needToQuarantine = new MutableLiveData<>();

    MutableLiveData<String> result;

    public ReviewViewModel() {
         commonRepository = new CommonRepository();
    }

    public LiveData<String> saveSurveyData(Survey survey) {
        result = new MutableLiveData<>();
        saveSurvey(survey, result);
        return result;
    }

    public LiveData<String> updateSurveyData(SurveyUpdate survey) {
        result = new MutableLiveData<>();
        updateSurvey(survey, result);
        return result;
    }

    public LiveData<String> saveQuarantineData(Quarantine quarantine) {
        result = new MutableLiveData<>();
        saveQuarantine(quarantine, result);
        return result;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public MutableLiveData<String> getFullName() {
        return fullName;
    }

    public void setFullName(MutableLiveData<String> fullName) {
        this.fullName = fullName;
    }

    public MutableLiveData<String> getGender() {
        return gender;
    }

    public void setGender(MutableLiveData<String> gender) {
        this.gender = gender;
    }

    public MutableLiveData<String> getAge() {
        return age;
    }

    public void setAge(MutableLiveData<String> age) {
        this.age = age;
    }

    public MutableLiveData<String> getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(MutableLiveData<String> houseNo) {
        this.houseNo = houseNo;
    }

    public MutableLiveData<String> getLandmark() {
        return landmark;
    }

    public void setLandmark(MutableLiveData<String> landmark) {
        this.landmark = landmark;
    }

    public MutableLiveData<String> getVillage() {
        return village;
    }

    public void setVillage(MutableLiveData<String> village) {
        this.village = village;
    }

    public MutableLiveData<String> getTahasil() {
        return tahasil;
    }

    public void setTahasil(MutableLiveData<String> tahasil) {
        this.tahasil = tahasil;
    }

    public MutableLiveData<String> getDistrict() {
        return district;
    }

    public void setDistrict(MutableLiveData<String> district) {
        this.district = district;
    }

    public MutableLiveData<String> getState() {
        return state;
    }

    public void setState(MutableLiveData<String> state) {
        this.state = state;
    }

    public MutableLiveData<String> getPrimaryMobile() {
        return primaryMobile;
    }

    public void setPrimaryMobile(MutableLiveData<String> primaryMobile) {
        this.primaryMobile = primaryMobile;
    }

    public MutableLiveData<String> getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(MutableLiveData<String> alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(MutableLiveData<String> email) {
        this.email = email;
    }

    public MutableLiveData<String> getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(MutableLiveData<String> travelHistory) {
        this.travelHistory = travelHistory;
    }

    public MutableLiveData<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(MutableLiveData<String> symptoms) {
        this.symptoms = symptoms;
    }

    public MutableLiveData<String> getNeedToQuarantine() {
        return needToQuarantine;
    }

    public void setNeedToQuarantine(MutableLiveData<String> needToQuarantine) {
        this.needToQuarantine = needToQuarantine;
    }

    private void saveSurvey(Survey survey, MutableLiveData<String> result) {
        commonRepository.saveSurveyData(survey, result);
    }

    private void updateSurvey(SurveyUpdate survey, MutableLiveData<String> result) {
        commonRepository.updateSurveyData(survey, result);
    }

    private void saveQuarantine(Quarantine quarantine, MutableLiveData<String> result) {
        commonRepository.saveQuarantineData(quarantine, result);
    }
}
