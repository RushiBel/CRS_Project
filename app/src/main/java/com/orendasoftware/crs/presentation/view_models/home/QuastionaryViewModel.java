package com.orendasoftware.crs.presentation.view_models.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.Severity;
import com.orendasoftware.crs.domain.data.api_model.SeverityForQua;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.Symptoms;
import com.orendasoftware.crs.domain.data.api_model.SymptomsForQua;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuastionaryViewModel extends ViewModel {

    private MutableLiveData<Integer> travelHistory = new MutableLiveData<>(0);
    private MutableLiveData<Integer> symptoms = new MutableLiveData<>(0);

    private MutableLiveData<String> countryCityState = new MutableLiveData<>();
    private MutableLiveData<String> travelDate = new MutableLiveData<>();
    private MutableLiveData<String> transportType= new MutableLiveData<>();

    private MutableLiveData<Boolean> cold = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> cough = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> fever = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> breathing = new MutableLiveData<>(false);

    private MutableLiveData<String> otherSymptoms = new MutableLiveData<>();
    private MutableLiveData<Integer> severity = new MutableLiveData<>(0);

    private MutableLiveData<String> quarantineType = new MutableLiveData<>();


    public MutableLiveData<Integer> getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(MutableLiveData<Integer> travelHistory) {
        this.travelHistory = travelHistory;
    }

    public MutableLiveData<Integer> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(MutableLiveData<Integer> symptoms) {
        this.symptoms = symptoms;
    }

    public MutableLiveData<String> getCountryCityState() {
        return countryCityState;
    }

    public void setCountryCityState(MutableLiveData<String> countryCityState) {
        this.countryCityState = countryCityState;
    }

    public MutableLiveData<String> getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(MutableLiveData<String> travelDate) {
        this.travelDate = travelDate;
    }

    public MutableLiveData<String> getTransportType() {
        return transportType;
    }

    public void setTransportType(MutableLiveData<String> transportType) {
        this.transportType = transportType;
    }

    public MutableLiveData<Boolean> getCold() {
        return cold;
    }

    public void setCold(MutableLiveData<Boolean> cold) {
        this.cold = cold;
    }

    public MutableLiveData<Boolean> getCough() {
        return cough;
    }

    public void setCough(MutableLiveData<Boolean> cough) {
        this.cough = cough;
    }

    public MutableLiveData<Boolean> getFever() {
        return fever;
    }

    public void setFever(MutableLiveData<Boolean> fever) {
        this.fever = fever;
    }

    public MutableLiveData<Boolean> getBreathing() {
        return breathing;
    }

    public void setBreathing(MutableLiveData<Boolean> breathing) {
        this.breathing = breathing;
    }

    public MutableLiveData<String> getOtherSymptoms() {
        return otherSymptoms;
    }

    public void setOtherSymptoms(MutableLiveData<String> otherSymptoms) {
        this.otherSymptoms = otherSymptoms;
    }

    public MutableLiveData<Integer> getSeverity() {
        return severity;
    }

    public void setSeverity(MutableLiveData<Integer> severity) {
        this.severity = severity;
    }

    public MutableLiveData<String> getQuarantineType() {
        return quarantineType;
    }

    public void setQuarantineType(MutableLiveData<String> quarantineType) {
        this.quarantineType = quarantineType;
    }

    public Survey getData(Survey survey) {

        if(travelHistory.getValue() != null) {
            try {
                if(travelHistory.getValue() == R.id.rb_yes_travel_history_survey_form_three) {
                    survey.isSurUserTravelHstry = true;
                    survey.surUserTrvlFrom = countryCityState.getValue();
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy");
                    survey.surUserTravelDate = format.parse(travelDate.getValue());
                    survey.transportType = transportType.getValue();
                } else if(travelHistory.getValue() == R.id.rb_no_travel_history_survey_form_three) {
                    survey.isSurUserTravelHstry = false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if(symptoms.getValue() != null) {
            if(symptoms.getValue() == R.id.rb_yes_symptoms_survey_form_three) {
                survey.isSurUserSymptoms = true;
                Symptoms symptoms = new Symptoms();
                symptoms.cold = cold.getValue();
                symptoms.cough = cough.getValue();
                symptoms.fever = fever.getValue();
                symptoms.breathingDifficulty = breathing.getValue();
                if (otherSymptoms.getValue() != null)
                    symptoms.otherSymptoms = otherSymptoms.getValue();

                survey.symptoms = symptoms;

                if (severity.getValue() != null) {
                    Severity mSeverity = new Severity();
                    if (severity.getValue() == R.id.rb_mild_severity_survey_form_three)
                        mSeverity.symptomsSeverity = "Mild";
                    else if (severity.getValue() == R.id.rb_moderate_severity_survey_form_three)
                        mSeverity.symptomsSeverity = "Moderate";
                    else if (severity.getValue() == R.id.rb_severe_severity_survey_form_three)
                        mSeverity.symptomsSeverity = "Severe";
                    survey.severity = mSeverity;
                }
            } else {
                survey.isSurUserSymptoms = false;
            }
        }
        return survey;
    }

    public Quarantine getQuarantineData(Quarantine quarantine) {

        if(travelHistory.getValue() != null) {
            try {
                if(travelHistory.getValue() == R.id.rb_yes_travel_history_survey_form_three) {
                    quarantine.isQuaUserTravelHstry = true;
                    quarantine.quaUserTrvlFrom = countryCityState.getValue();
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy");
                    quarantine.quaUserTravelDate = format.parse(travelDate.getValue());
                    quarantine.quaTransportType = transportType.getValue();
                } else if(travelHistory.getValue() == R.id.rb_no_travel_history_survey_form_three) {
                    quarantine.isQuaUserTravelHstry = false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        quarantine.quarantineType = quarantineType.getValue();


        if(symptoms.getValue() != null) {
            if(symptoms.getValue() == R.id.rb_yes_symptoms_survey_form_three) {
                quarantine.isQuaUserSymptoms = true;
                SymptomsForQua symptoms = new SymptomsForQua();
                symptoms.cold = cold.getValue();
                symptoms.cough = cough.getValue();
                symptoms.fever = fever.getValue();
                symptoms.breathingDifficulty = breathing.getValue();
                if (otherSymptoms.getValue() != null)
                    symptoms.otherSymptoms = otherSymptoms.getValue();

                quarantine.symptomsForQua = symptoms;

                if (severity.getValue() != null) {
                    SeverityForQua mSeverity = new SeverityForQua();
                    if (severity.getValue() == R.id.rb_mild_severity_survey_form_three)
                        mSeverity.symptomsSeverity = "Mild";
                    else if (severity.getValue() == R.id.rb_moderate_severity_survey_form_three)
                        mSeverity.symptomsSeverity = "Moderate";
                    else if (severity.getValue() == R.id.rb_severe_severity_survey_form_three)
                        mSeverity.symptomsSeverity = "Severe";
                    quarantine.severityForQua = mSeverity;
                }
            } else {
                quarantine.isQuaUserSymptoms = false;
            }
        }
        return quarantine;
    }
}
