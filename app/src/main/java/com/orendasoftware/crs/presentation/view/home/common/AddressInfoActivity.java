package com.orendasoftware.crs.presentation.view.home.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.ActivityAddressInfoBinding;
import com.orendasoftware.crs.domain.data.api_model.DistrictCollection;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.StateCollection;
import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.domain.data.api_model.TahasilCollection;
import com.orendasoftware.crs.domain.data.api_model.VillageCollection;
import com.orendasoftware.crs.presentation.view_models.home.AddressInfoViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddressInfoActivity extends AppCompatActivity {

    private AddressInfoViewModel mViewModel;
    private ActivityAddressInfoBinding addressBinding;
    private Survey mSurvey;
    private Quarantine mQuarantine;
    private List<StateCollection.State> stateList;
    private List<DistrictCollection.District> districtList;
    private List<TahasilCollection.Tehsil> tahasilList;
    private List<VillageCollection.Village> villageList;

    List<String> arrayDistrict = new ArrayList<>();
    List<String> arrayState = new ArrayList<>();
    List<String> arrayTahasil = new ArrayList<>();
    List<String> arrayVillages = new ArrayList<>();

    public static String state, district, tahasil, village;
    public static Integer sId, dId, tId;
    boolean update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addressBinding = DataBindingUtil.setContentView(this, R.layout.activity_address_info);
        addressBinding.setLifecycleOwner(this);
    
        mViewModel = ViewModelProviders.of(this).get(AddressInfoViewModel.class);
        addressBinding.setViewModel(mViewModel);

        if(getIntent() != null) {
            if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                mSurvey = (Survey) getIntent().getSerializableExtra("model");
                update = getIntent().getBooleanExtra("update", false);

                if(update)
                    disableUI();


                if (mSurvey != null) {
                    if (mSurvey.address != null) {

                        mViewModel.setHouseNo(new MutableLiveData<>(mSurvey.address.endusrHouseAddress));

                        if (mSurvey.address.endusrLandMark != null)
                            mViewModel.setLandmark(new MutableLiveData<>(mSurvey.address.endusrLandMark));

                        state = mSurvey.address.endusrState;
                        mViewModel.setState(new MutableLiveData<>(mSurvey.address.endusrState));
                        mViewModel.setDistrict(new MutableLiveData<>(mSurvey.address.endusrDistrict));
                        mViewModel.setTahasil(new MutableLiveData<>(mSurvey.address.tehsil));
                        mViewModel.setVillage(new MutableLiveData<>(mSurvey.address.endusrVillage));

                        if (mSurvey.address.endusrpostalCode != null)
                            mViewModel.setPostalCode(new MutableLiveData<>(String.valueOf(mSurvey.address.endusrpostalCode)));

                    }
                }
            } else if(Constants.FRAGMENT.equalsIgnoreCase("QUARANTINE")) {
                mQuarantine = (Quarantine) getIntent().getSerializableExtra("model");
                update = getIntent().getBooleanExtra("update", false);

                if(update)
                    disableUI();

                if (mQuarantine != null) {
                    if (mQuarantine.addressForQua != null) {

                        mViewModel.setHouseNo(new MutableLiveData<>(mQuarantine.addressForQua.endusrHouseAddress));

                        if (mQuarantine.addressForQua.endusrLandMark != null)
                            mViewModel.setLandmark(new MutableLiveData<>(mQuarantine.addressForQua.endusrLandMark));

                        state = mQuarantine.addressForQua.endusrState;
                        mViewModel.setState(new MutableLiveData<>(mQuarantine.addressForQua.endusrState));
                        mViewModel.setDistrict(new MutableLiveData<>(mQuarantine.addressForQua.endusrDistrict));
                        mViewModel.setTahasil(new MutableLiveData<>(mQuarantine.addressForQua.tehsil));
                        mViewModel.setVillage(new MutableLiveData<>(mQuarantine.addressForQua.endusrVillage));

                        if (mQuarantine.addressForQua.endusrpostalCode != null)
                            mViewModel.setPostalCode(new MutableLiveData<>(String.valueOf(mQuarantine.addressForQua.endusrpostalCode)));
                    }
                }
            }

            executeSpinnerActions();
        }



        addressBinding.btnNextSurveyFormTwo.setOnClickListener(view -> {

            if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                if (mSurvey != null)
                    mSurvey.address = mViewModel.getAddress();
            } else {
                if (mQuarantine != null)
                    mQuarantine.addressForQua = mViewModel.getQuarantineAddress();
            }

            if(TextUtils.isEmpty(mViewModel.getHouseNo().getValue()))
                addressBinding.etAddressLineSurveyFormTwo.setError("Please Enter House No.");

            else if (mViewModel.getState().getValue().equalsIgnoreCase("Select State")) {
                Toast.makeText(this, "Please Select State", Toast.LENGTH_SHORT).show();
                addressBinding.spinnerStateSurveyFormTwo.setError("Select State");
            } else if(mViewModel.getDistrict().getValue().equalsIgnoreCase("Select District")) {
                Toast.makeText(this, "Please Select District", Toast.LENGTH_SHORT).show();
                addressBinding.spinnerDistrictSurveyFormTwo.setError("Select District");
            } else if(mViewModel.getTahasil().getValue().equalsIgnoreCase("Select Tahasil")) {
                Toast.makeText(this, "Please Select Tahasil", Toast.LENGTH_SHORT).show();
                addressBinding.spinnerTehsilSurveyFormTwo.setError("");
            } else if(mViewModel.getVillage().getValue().equalsIgnoreCase("Select Village")) {
                Toast.makeText(this, "Please Select Village", Toast.LENGTH_SHORT).show();
                addressBinding.spinnerVillageSurveyFormTwo.setError("");
            } else {
                if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("model", mSurvey);
                    if(update)
                        bundle.putBoolean("update",update);
                    Intent intent = new Intent(this, QuestionaryActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if(Constants.FRAGMENT.equalsIgnoreCase("QUARANTINE")) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("model", mQuarantine);
                    if(update)
                        bundle.putBoolean("update",update);
                    Intent intent = new Intent(this, QuestionaryActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });


        addressBinding.btnBackSurveyFormTwo.setOnClickListener(view->{
            if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
                mSurvey.address = mViewModel.getAddress();
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", mSurvey);
                if(update)
                    bundle.putBoolean("update", update);
                Intent intent = new Intent(this, PersonInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                mQuarantine.addressForQua = mViewModel.getQuarantineAddress();
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", mQuarantine);
                if(update)
                    bundle.putBoolean("update", update);
                Intent intent = new Intent(this, PersonInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(Constants.FRAGMENT.equalsIgnoreCase("SURVEY")) {
            mSurvey.address = mViewModel.getAddress();
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", mSurvey);
            bundle.putBoolean("update", update);
            Intent intent = new Intent(this, PersonInfoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            mQuarantine.addressForQua = mViewModel.getQuarantineAddress();
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", mQuarantine);

            Intent intent = new Intent(this, PersonInfoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private void disableUI() {
        addressBinding.etAddressLineSurveyFormTwo.setEnabled(false);
        addressBinding.etLandmarkSurveyFormTwo.setEnabled(false);
        addressBinding.spinnerStateSurveyFormTwo.setEnabled(false);
        addressBinding.spinnerDistrictSurveyFormTwo.setEnabled(false);
        addressBinding.spinnerTehsilSurveyFormTwo.setEnabled(false);
        addressBinding.spinnerVillageSurveyFormTwo.setEnabled(false);
        addressBinding.etPostalCodeSurveyFormTwo.setEnabled(false);
    }

    private void executeSpinnerActions() {

        mViewModel.getStateList().observe(this, data -> {
            stateList = data.getState();

            arrayState.add(0, "Select State");

            for (int i = 0; i < stateList.size(); i++)
                arrayState.add(stateList.get(i).getStateName());

            if(state != null) {
                arrayState.remove(state);
                arrayState.add(0, state);
            }

            addressBinding.spinnerStateSurveyFormTwo.setItems(arrayState);

        });

        if (mViewModel.getState().getValue() == null)
            mViewModel.setState(new MutableLiveData<>("Select State"));

        addressBinding.spinnerStateSurveyFormTwo.setOnItemSelectedListener((view, position, id, item) -> {

            state = item.toString();
            mViewModel.setState(new MutableLiveData<>(item.toString()));
            arrayDistrict.clear();
            mViewModel.setDistrict(new MutableLiveData<>("Select District"));
            arrayTahasil.clear();
            mViewModel.setTahasil(new MutableLiveData<>("Select Tahasil"));
            arrayVillages.clear();
            mViewModel.setVillage(new MutableLiveData<>("Select Village"));


            int stateId = 0;
            for (int i = 0; i < stateList.size(); i++) {
                if (stateList.get(i).getStateName().equalsIgnoreCase(item.toString())) {
                    stateId = stateList.get(i).getStateId();
                    sId = stateId;
                    break;
                }
            }
            mViewModel.getDistrictList(stateId).observe(this, data -> {
                districtList = data.getDistrict();
                arrayDistrict.add(0, "Select District");

                for (int i = 0; i < districtList.size(); i++)
                    arrayDistrict.add(districtList.get(i).getDistrictName());

                addressBinding.spinnerDistrictSurveyFormTwo.setItems(arrayDistrict);
            });
            addressBinding.spinnerStateSurveyFormTwo.setError(null);

        });

        if(sId != null) {
            mViewModel.getDistrictList(sId).observe(this, data -> {
                districtList = data.getDistrict();
                arrayDistrict.add(0, "Select District");

                for (int i = 0; i < districtList.size(); i++)
                    arrayDistrict.add(districtList.get(i).getDistrictName());

                if(district != null) {
                    arrayDistrict.remove(district);
                    arrayDistrict.add(0, district);
                }
                addressBinding.spinnerDistrictSurveyFormTwo.setItems(arrayDistrict);
            });
        }

        if (mViewModel.getDistrict().getValue() == null)
            mViewModel.setDistrict(new MutableLiveData<>("Select District"));


        addressBinding.spinnerDistrictSurveyFormTwo.setOnItemSelectedListener(((view, position, id, item) -> {

            district = item.toString();
            mViewModel.setDistrict(new MutableLiveData<>(item.toString()));
            arrayTahasil.clear();
            mViewModel.setTahasil(new MutableLiveData<>("Select Tahasil"));
            arrayVillages.clear();
            mViewModel.setVillage(new MutableLiveData<>("Select Village"));

            int districtId = 0;
            for (int i = 0; i < districtList.size(); i++) {
                if (districtList.get(i).getDistrictName().equalsIgnoreCase(item.toString())) {
                    districtId = districtList.get(i).getDistrictId();
                    dId = districtId;
                    break;
                }
            }
            mViewModel.getTahasilList(districtId).observe(this, data -> {
                tahasilList = data.getTehsil();
                arrayTahasil.add(0, "Select Tahasil");

                for (int i = 0; i < tahasilList.size(); i++)
                    arrayTahasil.add(tahasilList.get(i).getTahsilName());

                addressBinding.spinnerTehsilSurveyFormTwo.setItems(arrayTahasil);
            });

            addressBinding.spinnerDistrictSurveyFormTwo.setError(null);
        }));

        if(dId != null) {
            mViewModel.getTahasilList(dId).observe(this, data -> {
                tahasilList = data.getTehsil();
                arrayTahasil.add(0, "Select Tahasil");

                for (int i = 0; i < tahasilList.size(); i++)
                    arrayTahasil.add(tahasilList.get(i).getTahsilName());

                if(tahasil != null) {
                    arrayTahasil.remove(tahasil);
                    arrayTahasil.add(0, tahasil);
                }

                addressBinding.spinnerTehsilSurveyFormTwo.setItems(arrayTahasil);
            });
        }

        if (mViewModel.getTahasil().getValue() == null)
            mViewModel.setTahasil(new MutableLiveData<>("Select Tahasil"));

        addressBinding.spinnerTehsilSurveyFormTwo.setOnItemSelectedListener(((view, position, id, item) -> {

            tahasil = item.toString();
            mViewModel.setTahasil(new MutableLiveData<>(item.toString()));
            arrayVillages.clear();
            mViewModel.setVillage(new MutableLiveData<>("Select Village"));

            int tahasilId = 0;

            for (int i = 0; i < tahasilList.size(); i++) {
                if (tahasilList.get(i).getTahsilName().equalsIgnoreCase(item.toString())) {
                    tahasilId = tahasilList.get(i).getTahsilId();
                    tId = tahasilId;
                    break;
                }
            }
            mViewModel.getVillageList(tahasilId).observe(this, data -> {
                villageList = data.getVillage();
                arrayVillages.add(0, "Select Village");

                for (int i = 0; i < villageList.size(); i++)
                    arrayVillages.add(villageList.get(i).getVillageName());

                addressBinding.spinnerVillageSurveyFormTwo.setItems(arrayVillages);
            });

            addressBinding.spinnerTehsilSurveyFormTwo.setError(null);

        }));

        if(tId != null) {
            mViewModel.getVillageList(tId).observe(this, data -> {
                villageList = data.getVillage();
                arrayVillages.add(0, "Select Village");

                for (int i = 0; i < villageList.size(); i++)
                    arrayVillages.add(villageList.get(i).getVillageName());

                if(village != null) {
                    arrayVillages.remove(village);
                    arrayVillages.add(0, village);
                }

                addressBinding.spinnerVillageSurveyFormTwo.setItems(arrayVillages);
            });
        }


        if (mViewModel.getVillage().getValue() == null)
            mViewModel.setVillage(new MutableLiveData<>("Select Village"));

        addressBinding.spinnerVillageSurveyFormTwo.setOnItemSelectedListener(((view, position, id, item) -> {
            village = item.toString();
            mViewModel.setVillage(new MutableLiveData<>(item.toString()));
            addressBinding.spinnerVillageSurveyFormTwo.setError(null);
        }));
    }
}
