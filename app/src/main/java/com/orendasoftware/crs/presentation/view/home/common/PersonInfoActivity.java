package com.orendasoftware.crs.presentation.view.home.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.ActivityPersonInfoBinding;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.presentation.view.home.BaseActivity;
import com.orendasoftware.crs.presentation.view_models.home.PersonalInfoViewModel;

public class PersonInfoActivity extends AppCompatActivity {

    ActivityPersonInfoBinding activityPersonInfoBinding;
    private PersonalInfoViewModel mViewModel;
    private Survey mSurvey;
    private Quarantine mQuarantine;
    boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPersonInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_person_info);

        mViewModel = ViewModelProviders.of(this).get(PersonalInfoViewModel.class);

        // TODO: Use the ViewModel
        activityPersonInfoBinding.setViewModel(mViewModel);

        if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY"))
            mViewModel.setTitle(new MutableLiveData<>("Survey"));
        else
            mViewModel.setTitle(new MutableLiveData<>("Quarantine"));

        if(getIntent() != null) {
            if(Constants.FRAGMENT.equalsIgnoreCase( "SURVEY")) {
                 mSurvey = (Survey)getIntent().getSerializableExtra("model");
                 update = getIntent().getBooleanExtra("update", false);

                 if(update) {
                     disableUI();
                 }

                 if(mSurvey != null) {
                    mViewModel.setFirstName(new MutableLiveData<>(mSurvey.surUserFName));

                    if(mSurvey.surUserMName != null)
                        mViewModel.setMiddleName(new MutableLiveData<>(mSurvey.surUserMName));

                    mViewModel.setLastName(new MutableLiveData<>(mSurvey.surUserLName));
                    if (mSurvey.surUserGender.equalsIgnoreCase("Female"))
                        mViewModel.setGender(new MutableLiveData<>(R.id.rb_Female_survey_form_one));
                    else if (mSurvey.surUserGender.equalsIgnoreCase("Male"))
                        mViewModel.setGender(new MutableLiveData<>(R.id.rb_male_survey_form_one));
                    else if (mSurvey.surUserGender.equalsIgnoreCase("Other"))
                        mViewModel.setGender(new MutableLiveData<>(R.id.rb_other_survey_form_one));
                    mViewModel.setAge(new MutableLiveData<>(String.valueOf(mSurvey.surUserAge)));

                    if (mSurvey.aadharNumber != null)
                        mViewModel.setAadharNo(new MutableLiveData<>(String.valueOf(mSurvey.aadharNumber)));

                    mViewModel.setPrimaryContactNo(new MutableLiveData<>(String.valueOf(mSurvey.primaryContactNo)));

                    if (mSurvey.alternateContactNo != null)
                        mViewModel.setAlternateContactNo(new MutableLiveData<>(String.valueOf(mSurvey.alternateContactNo)));

                    if (mSurvey.surUserEmail != null)
                        mViewModel.setEmail(new MutableLiveData<>(mSurvey.surUserEmail));
                 }

            } else if(Constants.FRAGMENT.equalsIgnoreCase("QUARANTINE")) {
                mQuarantine = (Quarantine) getIntent().getSerializableExtra("model");
                update = getIntent().getBooleanExtra("update", false);

                if(update) {
                    disableUI();
                }

                if(mQuarantine != null) {
                    mViewModel.setFirstName(new MutableLiveData<>(mQuarantine.quaUserFName));

                    if(mQuarantine.quaUserMName != null)
                        mViewModel.setMiddleName(new MutableLiveData<>(mQuarantine.quaUserMName));

                    mViewModel.setLastName(new MutableLiveData<>(mQuarantine.quaUserLName));
                    if (mQuarantine.quaUserGender.equalsIgnoreCase("Female"))
                        mViewModel.setGender(new MutableLiveData<>(R.id.rb_Female_survey_form_one));
                    else if (mQuarantine.quaUserGender.equalsIgnoreCase("Male"))
                        mViewModel.setGender(new MutableLiveData<>(R.id.rb_male_survey_form_one));
                    else if (mQuarantine.quaUserGender.equalsIgnoreCase("Other"))
                        mViewModel.setGender(new MutableLiveData<>(R.id.rb_other_survey_form_one));
                    mViewModel.setAge(new MutableLiveData<>(String.valueOf(mQuarantine.quaUserAge)));

                    if (mQuarantine.aadharNumber != null)
                        mViewModel.setAadharNo(new MutableLiveData<>(String.valueOf(mQuarantine.aadharNumber)));

                    mViewModel.setPrimaryContactNo(new MutableLiveData<>(String.valueOf(mQuarantine.quaPrimaryContactNo)));


                    if (mQuarantine.quaAlternateContactNo != null)
                        mViewModel.setAlternateContactNo(new MutableLiveData<>(String.valueOf(mQuarantine.quaAlternateContactNo)));

                    if (mQuarantine.quaUserEmail != null)
                        mViewModel.setEmail(new MutableLiveData<>(mQuarantine.quaUserEmail));
                }
            }

        }

        activityPersonInfoBinding.btnNextSurveyFormOne.setOnClickListener(v -> {
            if(TextUtils.isEmpty(mViewModel.getFirstName().getValue()))
                activityPersonInfoBinding.etFirstNameSurveyFormOne.setError("Please Enter First Name");
            else if(TextUtils.isEmpty(mViewModel.getLastName().getValue()))
                activityPersonInfoBinding.etLastNameSurveyFormOne.setError("Please Enter Last Name");
            else if(mViewModel.getGender().getValue() == 0)
                activityPersonInfoBinding.rbOtherSurveyFormOne.setError("Please Select Gender");
            else if(TextUtils.isEmpty(mViewModel.getAge().getValue()))
                activityPersonInfoBinding.etAgeSurveyFormOne.setError("Please Enter Age");
            else if(TextUtils.isEmpty(mViewModel.getPrimaryContactNo().getValue()))
                activityPersonInfoBinding.etPrimaryMobileSurveyFormOne.setError("Please Enter Mobile Number");
            else {
                if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                    Survey survey = mViewModel.getData(mSurvey);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("model", survey);
                    bundle.putBoolean("update", update);
                    Intent intent = new Intent(this, AddressInfoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(Constants.FRAGMENT.equalsIgnoreCase("QUARANTINE")) {
                    Quarantine quarantine = mViewModel.getQuarantineData(mQuarantine);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("model", quarantine);
                    bundle.putBoolean("update", update);
                    Intent intent = new Intent(this, AddressInfoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        mViewModel.getGender().observe(this, gender ->{
            if(gender != 0)
                activityPersonInfoBinding.rbOtherSurveyFormOne.setError(null);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, BaseActivity.class);
        intent.putExtra("fragment", "mSurvey");
        startActivity(intent);
        finish();
    }

    private void disableUI() {
        activityPersonInfoBinding.etFirstNameSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.etMiddleNameSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.etLastNameSurveyFormOne.setEnabled(false);

        activityPersonInfoBinding.rbMaleSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.rbFemaleSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.rbOtherSurveyFormOne.setEnabled(false);

        activityPersonInfoBinding.etAgeSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.etPrimaryMobileSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.etSecondaryMobileSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.etAadharSurveyFormOne.setEnabled(false);
        activityPersonInfoBinding.etEmailSurveyFormOne.setEnabled(false);
    }
}
