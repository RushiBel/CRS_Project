package com.orendasoftware.crs.presentation.view_models.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Survey;

public class PersonalInfoViewModel extends ViewModel {

    private MutableLiveData<String> title = new MutableLiveData<>();
    private MutableLiveData<String> firstName = new MutableLiveData<>();
    private MutableLiveData<String> middleName = new MutableLiveData<>();
    private MutableLiveData<String> lastName = new MutableLiveData<>();
    private MutableLiveData<String> age = new MutableLiveData<>();
    private MutableLiveData<String> primaryContactNo = new MutableLiveData<>();
    private MutableLiveData<String> alternateContactNo = new MutableLiveData<>();
    private MutableLiveData<String> aadharNo = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();

    private MutableLiveData<Integer> gender = new MutableLiveData<>(0);

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(MutableLiveData<String> title) {
        this.title = title;
    }

    public MutableLiveData<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(MutableLiveData<String> firstName) {
        this.firstName = firstName;
    }


    public MutableLiveData<String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(MutableLiveData<String> middleName) {
        this.middleName = middleName;
    }

    public MutableLiveData<String> getLastName() {
        return lastName;
    }

    public void setLastName(MutableLiveData<String> lastName) {
        this.lastName = lastName;
    }

    public MutableLiveData<Integer> getGender() {
        return gender;
    }

    public void setGender(MutableLiveData<Integer> gender) {
        this.gender = gender;
    }

    public MutableLiveData<String> getAge() {
        return age;
    }

    public void setAge(MutableLiveData<String> age) {
        this.age = age;
    }

    public MutableLiveData<String> getPrimaryContactNo() {
        return primaryContactNo;
    }

    public void setPrimaryContactNo(MutableLiveData<String> primaryContactNo) {
        this.primaryContactNo = primaryContactNo;
    }

    public MutableLiveData<String> getAlternateContactNo() {
        return alternateContactNo;
    }

    public void setAlternateContactNo(MutableLiveData<String> alternateContactNo) {
        this.alternateContactNo = alternateContactNo;
    }

    public MutableLiveData<String> getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(MutableLiveData<String> aadharNo) {
        this.aadharNo = aadharNo;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(MutableLiveData<String> email) {
        this.email = email;
    }

    public Survey getData(Survey survey) {

        if(survey == null)
            survey = new Survey();

        if(gender.getValue() != null) {
            if (gender.getValue() == R.id.rb_Female_survey_form_one)
                survey.surUserGender = "Female";
            else if (gender.getValue() == R.id.rb_male_survey_form_one)
                survey.surUserGender = "Male";
            else if (gender.getValue() == R.id.rb_other_survey_form_one)
                survey.surUserGender = "Other";
        }

        if(age.getValue() != null)
            survey.surUserAge = Integer.parseInt(age.getValue());

        survey.surUserFName = firstName.getValue();

        if(middleName.getValue() != null)
            survey.surUserMName = middleName.getValue();

        survey.surUserLName = lastName.getValue();

        if(primaryContactNo.getValue() != null)
            survey.primaryContactNo = Long.parseLong(primaryContactNo.getValue());

        if(alternateContactNo.getValue() != null)
            survey.alternateContactNo = Long.parseLong(alternateContactNo.getValue());

        if(aadharNo.getValue() != null)
            survey.aadharNumber = Long.parseLong(aadharNo.getValue());

        if(email.getValue() != null)
            survey.surUserEmail = email.getValue();

        return survey;

    }

    public Quarantine getQuarantineData(Quarantine quarantine) {

        if(quarantine == null)
            quarantine = new Quarantine();

        if(gender.getValue() != null) {
            if (gender.getValue() == R.id.rb_Female_survey_form_one)
                quarantine.quaUserGender = "Female";
            else if (gender.getValue() == R.id.rb_male_survey_form_one)
                quarantine.quaUserGender = "Male";
            else if (gender.getValue() == R.id.rb_other_survey_form_one)
                quarantine.quaUserGender = "Other";
        }

        if(age.getValue() != null)
            quarantine.quaUserAge = Integer.parseInt(age.getValue());

        quarantine.quaUserFName = firstName.getValue();

        if(middleName.getValue() != null)
            quarantine.quaUserMName = middleName.getValue();

        quarantine.quaUserLName = lastName.getValue();

        if(primaryContactNo.getValue() != null)
            quarantine.quaPrimaryContactNo = Long.parseLong(primaryContactNo.getValue());

        if(alternateContactNo.getValue() != null)
            quarantine.quaAlternateContactNo = Long.parseLong(alternateContactNo.getValue());

        if(aadharNo.getValue() != null)
            quarantine.aadharNumber = Long.parseLong(aadharNo.getValue());

        if(email.getValue() != null)
            quarantine.quaUserEmail = email.getValue();

        return quarantine;

    }

}
