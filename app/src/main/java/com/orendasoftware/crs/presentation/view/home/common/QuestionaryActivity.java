package com.orendasoftware.crs.presentation.view.home.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.ActivityQuestionaryBinding;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.SurveyUpdate;
import com.orendasoftware.crs.presentation.view_models.home.QuastionaryViewModel;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuestionaryActivity extends AppCompatActivity implements SelectionListener {
    
    ActivityQuestionaryBinding questionaryBinding;
    private QuastionaryViewModel mViewModel;
    private Survey mSurvey;
    private Quarantine mQuarantine;
    DatePickerDialog dialog;
    boolean update;
    private SurveyUpdate mSurveyUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionaryBinding = DataBindingUtil.setContentView(this, R.layout.activity_questionary);
        mViewModel = ViewModelProviders.of(this).get(QuastionaryViewModel.class);

        if(Constants.FRAGMENT != null) {
            if (!Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                questionaryBinding.spinnerQuarantineType.setVisibility(View.VISIBLE);
                List<String> quarantineType = new ArrayList<>();
                quarantineType.add("Select Quarantine Type");
                quarantineType.add("Home Quarantine");
                quarantineType.add("Village Quarantine");
                quarantineType.add("Tahasil Quarantine");
                quarantineType.add("District Quarantine");
                questionaryBinding.spinnerQuarantineType.setItems(quarantineType);
            }
        }

        if(mViewModel.getQuarantineType().getValue() == null)
            mViewModel.setQuarantineType(new MutableLiveData<>("Select Quarantine Type"));

        questionaryBinding.spinnerQuarantineType.setOnItemSelectedListener(((view, position, id, item) -> {
            mViewModel.setQuarantineType(new MutableLiveData<>(item.toString()));
        }));


        if(getIntent() != null && Constants.FRAGMENT != null) {
            if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                mSurvey = (Survey) getIntent().getSerializableExtra("model");
                update = getIntent().getBooleanExtra("update", false);

                if (mSurvey != null) {
                    if (mSurvey.isSurUserTravelHstry != null) {
                        if (mSurvey.isSurUserTravelHstry) {
                            mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_yes_travel_history_survey_form_three));
                            questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.VISIBLE);
                            if (mSurvey.surUserTrvlFrom != null)
                                mViewModel.setCountryCityState(new MutableLiveData<>(mSurvey.surUserTrvlFrom));

                            if (mSurvey.surUserTravelDate != null) {
                                DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                                String strDate = dateFormat.format(mSurvey.surUserTravelDate);
                                mViewModel.setTravelDate(new MutableLiveData<>(strDate));
                            }

                            if (mSurvey.transportType != null)
                                mViewModel.setTransportType(new MutableLiveData<>(mSurvey.transportType));
                        } else {
                            mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_no_travel_history_survey_form_three));
                            questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.GONE);
                        }
                    }

                    if (mSurvey.isSurUserSymptoms != null) {

                        if (mSurvey.isSurUserSymptoms) {
                            mViewModel.setSymptoms(new MutableLiveData<>(R.id.rb_yes_symptoms_survey_form_three));
                            questionaryBinding.layoutSymptomDetails.setVisibility(View.VISIBLE);
                            mViewModel.setCold(new MutableLiveData<>(mSurvey.symptoms.cold));
                            mViewModel.setCough(new MutableLiveData<>(mSurvey.symptoms.cough));
                            mViewModel.setFever(new MutableLiveData<>(mSurvey.symptoms.fever));
                            mViewModel.setBreathing(new MutableLiveData<>(mSurvey.symptoms.breathingDifficulty));

                            if (mSurvey.symptoms.otherSymptoms != null)
                                mViewModel.setOtherSymptoms(new MutableLiveData<>(mSurvey.symptoms.otherSymptoms));

                            if (mSurvey.severity.symptomsSeverity != null) {
                                if (mSurvey.severity.symptomsSeverity.equalsIgnoreCase("Mild"))
                                    mViewModel.setSeverity(new MutableLiveData<>(R.id.rb_mild_severity_survey_form_three));
                                else if (mSurvey.severity.symptomsSeverity.equalsIgnoreCase("Moderate"))
                                    mViewModel.setSeverity(new MutableLiveData<>(R.id.rb_moderate_severity_survey_form_three));
                                else if (mSurvey.severity.symptomsSeverity.equalsIgnoreCase("Severe"))
                                    mViewModel.setSeverity(new MutableLiveData<>(R.id.rb_severe_severity_survey_form_three));
                            }
                        } else {
                            mViewModel.setSymptoms(new MutableLiveData<>(R.id.rb_no_symptoms_survey_form_three));
                            questionaryBinding.layoutSymptomDetails.setVisibility(View.GONE);
                        }
                    }
                }
            } else if(Constants.FRAGMENT.equalsIgnoreCase("QUARANTINE")) {
                mQuarantine = (Quarantine) getIntent().getSerializableExtra("model");
                update = getIntent().getBooleanExtra("update", false);

                if(update) {
                    questionaryBinding.checkboxMoveToHospitalFormThree.setVisibility(View.VISIBLE);
                    questionaryBinding.textInputLayoutEtHospitalNameQuarantineFormThree.setVisibility(View.VISIBLE);
                }

                if (mQuarantine != null) {
                    if (mQuarantine.isQuaUserTravelHstry != null) {
                        if (mQuarantine.isQuaUserTravelHstry) {
                            mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_yes_travel_history_survey_form_three));
                            questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.VISIBLE);
                            if (mQuarantine.quaUserTrvlFrom != null)
                                mViewModel.setCountryCityState(new MutableLiveData<>(mQuarantine.quaUserTrvlFrom));

                            if (mQuarantine.quaUserTravelDate != null) {
                                DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                                String strDate = dateFormat.format(mQuarantine.quaUserTravelDate);
                                mViewModel.setTravelDate(new MutableLiveData<>(strDate));
                            }

                            if (mQuarantine.quaTransportType != null)
                                mViewModel.setTransportType(new MutableLiveData<>(mQuarantine.quaTransportType));
                        } else {
                            mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_no_travel_history_survey_form_three));
                            questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.GONE);
                        }
                    }

                    if (mQuarantine.isQuaUserSymptoms != null) {

                        if (mQuarantine.isQuaUserSymptoms) {
                            mViewModel.setSymptoms(new MutableLiveData<>(R.id.rb_yes_symptoms_survey_form_three));
                            questionaryBinding.layoutSymptomDetails.setVisibility(View.VISIBLE);
                            mViewModel.setCold(new MutableLiveData<>(mQuarantine.symptomsForQua.cold));
                            mViewModel.setCough(new MutableLiveData<>(mQuarantine.symptomsForQua.cough));
                            mViewModel.setFever(new MutableLiveData<>(mQuarantine.symptomsForQua.fever));
                            mViewModel.setBreathing(new MutableLiveData<>(mQuarantine.symptomsForQua.breathingDifficulty));

                            if (mQuarantine.symptomsForQua.otherSymptoms != null)
                                mViewModel.setOtherSymptoms(new MutableLiveData<>(mQuarantine.symptomsForQua.otherSymptoms));

                            if (mQuarantine.severityForQua.symptomsSeverity != null) {
                                if (mQuarantine.severityForQua.symptomsSeverity.equalsIgnoreCase("Mild"))
                                    mViewModel.setSeverity(new MutableLiveData<>(R.id.rb_mild_severity_survey_form_three));
                                else if (mQuarantine.severityForQua.symptomsSeverity.equalsIgnoreCase("Moderate"))
                                    mViewModel.setSeverity(new MutableLiveData<>(R.id.rb_moderate_severity_survey_form_three));
                                else if (mQuarantine.severityForQua.symptomsSeverity.equalsIgnoreCase("Severe"))
                                    mViewModel.setSeverity(new MutableLiveData<>(R.id.rb_severe_severity_survey_form_three));
                            }
                        } else {
                            mViewModel.setSymptoms(new MutableLiveData<>(R.id.rb_no_symptoms_survey_form_three));
                            questionaryBinding.layoutSymptomDetails.setVisibility(View.GONE);
                        }
                    }
                }
            }

        }

        questionaryBinding.setSelectionListener(this);
        questionaryBinding.setViewModel(mViewModel);

        mViewModel.getCough().observe(this, aBoolean-> {
            if(aBoolean)
                questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setError(null);
        });

        mViewModel.getFever().observe(this, aBoolean -> {
            if(aBoolean)
                questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setError(null);
        });

        mViewModel.getCold().observe(this, aBoolean -> {
            if(aBoolean)
                questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setError(null);
        });

        mViewModel.getBreathing().observe(this, aBoolean -> {
            if(aBoolean)
                questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setError(null);
        });

        mViewModel.getOtherSymptoms().observe(this, s->{
            if(!TextUtils.isEmpty(s))
                questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setError(null);
        });

        mViewModel.getSeverity().observe(this, integer -> {
            questionaryBinding.rbSevereSeveritySurveyFormThree.setError(null);
        });

        questionaryBinding.setNextClickListener(v->{

            Survey survey = null;
            Quarantine quarantine = null;

            if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY"))
                survey = mViewModel.getData(mSurvey);
            else
                quarantine = mViewModel.getQuarantineData(mQuarantine);

            if(mViewModel.getTravelHistory().getValue() == 0) {

                questionaryBinding.rbNoTravelHistorySurveyFormThree.setError("Please answer this question");

            } else if(mViewModel.getTravelHistory().getValue() == R.id.rb_yes_travel_history_survey_form_three) {

                Editable strCountryState = questionaryBinding.etCountryOrStateSurveyFormThree.getText();
                Editable strTravelDate = questionaryBinding.etDateSurveyFormThree.getText();
                Editable strTransportType = questionaryBinding.etTransportSurveyFormThree.getText();

                if(TextUtils.isEmpty(strCountryState))
                    questionaryBinding.etCountryOrStateSurveyFormThree.setError("Plese enter detailed address");

                else if(TextUtils.isEmpty(strTravelDate))
                    questionaryBinding.etDateSurveyFormThree.setError("Please select travel date");

                else if(TextUtils.isEmpty(strTransportType))
                    questionaryBinding.etTransportSurveyFormThree.setError("Please select transport type");

                else {
                    mSurvey.surUserTrvlFrom = strCountryState.toString();
                    mSurvey.transportType = strTransportType.toString();
                    checkForSymptom(survey, quarantine);

                }
            } else {
                checkForSymptom(survey,quarantine);
            }
        });

        questionaryBinding.etDateSurveyFormThree.setOnClickListener(click-> {
            dialog.show();
        });

        questionaryBinding.btnBackSurveyFormThree.setOnClickListener(click->{
            showAddressActivity();
        });

        final Calendar newCalendar = Calendar.getInstance();

        dialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM, yyyy");
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, month, dayOfMonth);
            if (Constants.FRAGMENT.equalsIgnoreCase("SURVEY"))
                mSurvey.surUserTravelDate = newDate.getTime();
            else
                mQuarantine.quaUserTravelDate = newDate.getTime();
            questionaryBinding.etDateSurveyFormThree.setError(null);
            questionaryBinding.etDateSurveyFormThree.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onTravelHistorySelected(String selectionType) {
        if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
            if (selectionType.equals(SelectionTypes.NO_HISTORY)) {
                questionaryBinding.rbNoTravelHistorySurveyFormThree.setError(null);
                questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.GONE);
                mSurvey.surUserTrvlFrom = null;
                mSurvey.surUserTravelDate = null;
                mSurvey.transportType = null;
                mSurvey.isSurUserTravelHstry = false;
                mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_no_travel_history_survey_form_three));
                mViewModel.setCountryCityState(null);
                questionaryBinding.etCountryOrStateSurveyFormThree.setText("");
                questionaryBinding.etDateSurveyFormThree.setText("");
                questionaryBinding.etTransportSurveyFormThree.setText("");
                mViewModel.setTravelDate(null);
                mViewModel.setTransportType(null);
            } else {
                questionaryBinding.rbNoTravelHistorySurveyFormThree.setError(null);
                questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.VISIBLE);
                mSurvey.isSurUserTravelHstry = true;
                mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_yes_travel_history_survey_form_three));
            }
        } else {
            if (selectionType.equals(SelectionTypes.NO_HISTORY)) {
                questionaryBinding.rbNoTravelHistorySurveyFormThree.setError(null);
                questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.GONE);
                mQuarantine.quaUserTrvlFrom = null;
                mQuarantine.quaUserTravelDate = null;
                mQuarantine.quaTransportType = null;
                mQuarantine.isQuaUserTravelHstry = false;
                mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_no_travel_history_survey_form_three));
                mViewModel.setCountryCityState(null);
                mViewModel.setTravelDate(null);
                mViewModel.setTransportType(null);
                questionaryBinding.etCountryOrStateSurveyFormThree.setText("");
                questionaryBinding.etDateSurveyFormThree.setText("");
                questionaryBinding.etTransportSurveyFormThree.setText("");
            } else {
                questionaryBinding.rbNoTravelHistorySurveyFormThree.setError(null);
                questionaryBinding.layoutTravelHistoryDetails.setVisibility(View.VISIBLE);
                mQuarantine.isQuaUserTravelHstry = true;
                mViewModel.setTravelHistory(new MutableLiveData<>(R.id.rb_yes_travel_history_survey_form_three));
            }
        }
    }

    @Override
    public void onSymtomOptionSelected(String selectionType) {
        if(selectionType.equals(SelectionTypes.HAVE_SYMPTOMS)) {
            questionaryBinding.rbNoSymptomsSurveyFormThree.setError(null);
            mViewModel.setSymptoms(new MutableLiveData<>(R.id.rb_yes_symptoms_survey_form_three));
            questionaryBinding.layoutSymptomDetails.setVisibility(View.VISIBLE);
        } else {
            questionaryBinding.rbNoSymptomsSurveyFormThree.setError(null);
            mViewModel.setSymptoms(new MutableLiveData<>(R.id.rb_no_travel_history_survey_form_three));
            questionaryBinding.checkboxColdSymptomsAnsSurveyFormThree.setChecked(false);
            questionaryBinding.checkboxCoughSymptomsAnsSurveyFormThree.setChecked(false);
            questionaryBinding.checkboxFeverSymptomsAnsSurveyFormThree.setChecked(false);
            questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setChecked(false);
            questionaryBinding.etOtherSymptomsAnsSurveyFormThree.setText("");
            questionaryBinding.rbMildSeveritySurveyFormThree.setChecked(false);
            questionaryBinding.rbModerateSeveritySurveyFormThree.setChecked(false);
            questionaryBinding.rbSevereSeveritySurveyFormThree.setChecked(false);
            mViewModel.setSeverity(new MutableLiveData<>(0));
            questionaryBinding.layoutSymptomDetails.setVisibility(View.GONE);
        }

    }

    @Override
    public void onSeveretySelected() {
        questionaryBinding.rbSevereSeveritySurveyFormThree.setError(null);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showAddressActivity();
    }

    private void showReviewActivity(Survey survey, Quarantine quarantine) {
        if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("update", update);
            if(update) {
                mSurveyUpdate = new SurveyUpdate();
                mSurveyUpdate.id = mSurvey.id;
                mSurveyUpdate.surUserTravelDate = mSurvey.surUserTravelDate;
                mSurveyUpdate.surUserTravelHstry = mSurvey.isSurUserTravelHstry;
                mSurveyUpdate.transportType = mSurvey.transportType;
                mSurveyUpdate.surUserTrvlFrom = mSurvey.surUserTrvlFrom;
                mSurveyUpdate.symptoms = mSurvey.symptoms;
                mSurveyUpdate.severity = mSurvey.severity;
                mSurveyUpdate.surUserSymptoms = mSurvey.isSurUserSymptoms;
                mSurveyUpdate.surCreatedBy = mSurvey.surCreatedBy;
                mSurveyUpdate.surCreatedDate = mSurvey.surCreatedDate;
                mSurveyUpdate.surUpdatedBy = mSurvey.surUpdatedBy;
                mSurveyUpdate.surUpdatedDate = mSurvey.surUpdatedDate;


                bundle.putSerializable("updateModel", mSurveyUpdate);
            }

            bundle.putSerializable("model", survey);
            Intent intent = new Intent(this, ReviewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", quarantine);

            Intent intent = new Intent(this, ReviewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private void showAddressActivity() {
        if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
            Survey survey = mViewModel.getData(mSurvey);
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", survey);
            bundle.putBoolean("update", update);
            Intent intent = new Intent(this, AddressInfoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Quarantine quarantine = mViewModel.getQuarantineData(mQuarantine);
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", quarantine);

            Intent intent = new Intent(this, AddressInfoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private void checkForSymptom (Survey survey, Quarantine quarantine) {
        if(mViewModel.getSymptoms().getValue()== 0) {

            questionaryBinding.rbNoSymptomsSurveyFormThree.setError("Please answer this question");

        } else if(mViewModel.getSymptoms().getValue() == R.id.rb_yes_symptoms_survey_form_three) {

            if(!mViewModel.getCold().getValue() && !mViewModel.getCough().getValue() && !mViewModel.getFever().getValue() &&
                    !mViewModel.getBreathing().getValue() && TextUtils.isEmpty(mViewModel.getOtherSymptoms().getValue())) {
                questionaryBinding.checkboxBreathingDiffSymptomsAnsSurveyFormThree.setError("Please choose symptom");

            } else {
                checkForSeverity(survey, quarantine);
            }
        } else {
            checkForSeverity(survey, quarantine);
        }
    }

    private void checkForSeverity(Survey survey, Quarantine quarantine) {

        if(mViewModel.getSeverity().getValue() == 0) {
            questionaryBinding.rbSevereSeveritySurveyFormThree.setError("Please select severity");
        } else {
            showReviewActivity(survey, quarantine);
        }
    }
}
