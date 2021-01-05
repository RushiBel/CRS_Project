package com.orendasoftware.crs.presentation.view.home.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.ActivityReviewBinding;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.SurveyUpdate;
import com.orendasoftware.crs.presentation.view.home.BaseActivity;
import com.orendasoftware.crs.presentation.view.home.ReviewViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReviewActivity extends AppCompatActivity {

    private ReviewViewModel mViewModel;
    private ActivityReviewBinding mBinding;
    private Survey mSurvey;
    private SurveyUpdate mSurveyUpdate;
    private Quarantine mQuarantine;
    String userName;
    boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_review);
        mViewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);
        mBinding.setViewModel(mViewModel);

        if (getIntent() != null) {
            String enableEdit = getIntent().getStringExtra("edit");
            update = getIntent().getBooleanExtra("update", false);
            if(enableEdit != null)
                if(enableEdit.equalsIgnoreCase("enable_edit")) {
                    mBinding.layoutEdit.setVisibility(View.VISIBLE);
                    mBinding.btnConfirm.setVisibility(View.GONE);
                }


            if (Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                mSurvey = (Survey) getIntent().getSerializableExtra("model");

                if(update)
                    mSurveyUpdate = (SurveyUpdate)getIntent().getSerializableExtra("updateModel");

                if (mSurvey.surUserMName != null)
                    userName = mSurvey.surUserFName + " " + mSurvey.surUserMName + " " + mSurvey.surUserLName;
                else
                    userName = mSurvey.surUserFName + " " + mSurvey.surUserLName;

                mViewModel.setFullName(new MutableLiveData<>(userName));

                mViewModel.setGender(new MutableLiveData<>(mSurvey.surUserGender));
                mViewModel.setAge(new MutableLiveData<>(String.valueOf(mSurvey.surUserAge)));

                mViewModel.setHouseNo(new MutableLiveData<>(mSurvey.address.endusrHouseAddress));

                if (mSurvey.address.endusrLandMark != null)
                    mViewModel.setLandmark(new MutableLiveData<>(mSurvey.address.endusrLandMark));

                mViewModel.setVillage(new MutableLiveData<>(mSurvey.address.endusrVillage));
                mViewModel.setTahasil(new MutableLiveData<>(mSurvey.address.tehsil));
                mViewModel.setDistrict(new MutableLiveData<>(mSurvey.address.endusrDistrict));
                mViewModel.setState(new MutableLiveData<>(mSurvey.address.endusrState));

                mViewModel.setPrimaryMobile(new MutableLiveData<>(String.valueOf(mSurvey.primaryContactNo)));

                if (mSurvey.alternateContactNo != null)
                    mViewModel.setAlternateMobile(new MutableLiveData<>(String.valueOf(mSurvey.alternateContactNo)));

                if (mSurvey.surUserEmail != null)
                    mViewModel.setEmail(new MutableLiveData<>(mSurvey.surUserEmail));

                if (mSurvey.isSurUserTravelHstry) {
                    DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                    String strDate = dateFormat.format(mSurvey.surUserTravelDate);
                    String travelDetails = mSurvey.surUserTrvlFrom + " " + strDate + " " + mSurvey.transportType;
                    mViewModel.setTravelHistory(new MutableLiveData<>(travelDetails));
                } else {
                    mViewModel.setTravelHistory(new MutableLiveData<>("No travel history"));
                }

                if (mSurvey.isSurUserSymptoms) {
                    String symptoms = "";
                    String cold = "";
                    String cough = "";
                    String fever = "";
                    String breathing = "";
                    String other = "";
                    String severity = "";

                    if (mSurvey.symptoms.cold)
                        cold = "Cold ";

                    if (mSurvey.symptoms.cough)
                        cough = "Cough ";

                    if (mSurvey.symptoms.fever)
                        fever = "Fever ";

                    if (mSurvey.symptoms.breathingDifficulty)
                        breathing = "Breathing Difficulty ";

                    if (mSurvey.symptoms.otherSymptoms != null)
                        other = mSurvey.symptoms.otherSymptoms;

                    severity = ", " + mSurvey.severity.symptomsSeverity;

                    symptoms = cold + cough + fever + breathing + other + severity;

                    mViewModel.setSymptoms(new MutableLiveData<>(symptoms));
                }
            } else {
                mQuarantine = (Quarantine) getIntent().getSerializableExtra("model");


                if (mQuarantine.quaUserMName != null)
                    userName = mQuarantine.quaUserFName + " " + mQuarantine.quaUserMName + " " + mQuarantine.quaUserLName;
                else
                    userName = mQuarantine.quaUserFName + " " + mQuarantine.quaUserLName;

                mViewModel.setFullName(new MutableLiveData<>(userName));

                mViewModel.setGender(new MutableLiveData<>(mQuarantine.quaUserGender));
                mViewModel.setAge(new MutableLiveData<>(String.valueOf(mQuarantine.quaUserAge)));

                mViewModel.setHouseNo(new MutableLiveData<>(mQuarantine.addressForQua.endusrHouseAddress));

                if (mQuarantine.addressForQua.endusrLandMark != null)
                    mViewModel.setLandmark(new MutableLiveData<>(mQuarantine.addressForQua.endusrLandMark));

                mViewModel.setVillage(new MutableLiveData<>(mQuarantine.addressForQua.endusrVillage));
                mViewModel.setTahasil(new MutableLiveData<>(mQuarantine.addressForQua.tehsil));
                mViewModel.setDistrict(new MutableLiveData<>(mQuarantine.addressForQua.endusrDistrict));
                mViewModel.setState(new MutableLiveData<>(mQuarantine.addressForQua.endusrState));

                mViewModel.setPrimaryMobile(new MutableLiveData<>(String.valueOf(mQuarantine.quaPrimaryContactNo)));

                if (mQuarantine.quaAlternateContactNo != null)
                    mViewModel.setAlternateMobile(new MutableLiveData<>(String.valueOf(mQuarantine.quaAlternateContactNo)));

                if (mQuarantine.quaUserEmail != null)
                    mViewModel.setEmail(new MutableLiveData<>(mQuarantine.quaUserEmail));

                if (mQuarantine.isQuaUserTravelHstry) {
                    DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                    String strDate = dateFormat.format(mQuarantine.quaUserTravelDate);
                    String travelDetails = mQuarantine.quaUserTrvlFrom + " " + strDate + " " + mQuarantine.quaTransportType;
                    mViewModel.setTravelHistory(new MutableLiveData<>(travelDetails));
                } else {
                    mViewModel.setTravelHistory(new MutableLiveData<>("No travel history"));
                }

                if (mQuarantine.isQuaUserSymptoms) {
                    String symptoms = "";
                    String cold = "";
                    String cough = "";
                    String fever = "";
                    String breathing = "";
                    String other = "";
                    String severity = "";

                    if (mQuarantine.symptomsForQua.cold)
                        cold = "Cold ";

                    if (mQuarantine.symptomsForQua.cough)
                        cough = "Cough ";

                    if (mQuarantine.symptomsForQua.fever)
                        fever = "Fever ";

                    if (mQuarantine.symptomsForQua.breathingDifficulty)
                        breathing = "Breathing Difficulty ";

                    if (mQuarantine.symptomsForQua.otherSymptoms != null)
                        other = mQuarantine.symptomsForQua.otherSymptoms;

                    severity = ", " + mQuarantine.severityForQua.symptomsSeverity;

                    symptoms = cold + cough + fever + breathing + other + severity;

                    mViewModel.setSymptoms(new MutableLiveData<>(symptoms));
                }

            }

            mBinding.btnConfirm.setOnClickListener(v -> {
                if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                    mSurvey.surCreatedBy = "amit@gmail.com";
                    if(!update) {
                        mViewModel.saveSurveyData(mSurvey).observe(this, s -> {
                            Bundle bundle = new Bundle();
                            bundle.putString("fragment", "survey");
                            Intent intent = new Intent(this, BaseActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        });
                    } else {
                        mViewModel.updateSurveyData(mSurveyUpdate).observe(this, s -> {
                            Bundle bundle = new Bundle();
                            bundle.putString("fragment", "survey");
                            Intent intent = new Intent(this, BaseActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        });
                    }
                } else {
                    mViewModel.saveQuarantineData(mQuarantine).observe(this, s -> {
                        System.out.print(s);
                    });
                }
            });

            mBinding.btnEdit.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                    bundle.putSerializable("model", mSurvey);
                } else
                    bundle.putSerializable("model", mQuarantine);

                bundle.putBoolean("update", true);
                Intent intent = new Intent(this, PersonInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            });

            mBinding.btnBack.setOnClickListener(v-> {
                if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {

                } else {

                }
            });

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", mSurvey);

        /*Intent intent = new Intent(this, QuestionaryActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);*/
    }
}

