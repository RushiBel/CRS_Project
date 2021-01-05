package com.orendasoftware.crs.presentation.view_models.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.api_model.Address;
import com.orendasoftware.crs.domain.data.api_model.AddressForQua;
import com.orendasoftware.crs.domain.data.api_model.DistrictCollection;
import com.orendasoftware.crs.domain.data.api_model.StateCollection;
import com.orendasoftware.crs.domain.data.api_model.TahasilCollection;
import com.orendasoftware.crs.domain.data.api_model.VillageCollection;
import com.orendasoftware.crs.domain.data.repository.AddressRepository;

public class AddressInfoViewModel extends ViewModel {
    private AddressRepository addressRepository;
    private MutableLiveData<String> houseNo = new MutableLiveData<>();
    private MutableLiveData<String> landmark = new MutableLiveData<>();
    private MutableLiveData<String> state = new MutableLiveData<>();
    private MutableLiveData<String> district = new MutableLiveData<>();
    private MutableLiveData<String> tahasil = new MutableLiveData<>();
    private MutableLiveData<String> village = new MutableLiveData<>();
    private MutableLiveData<String> postalCode = new MutableLiveData<>();

    private MutableLiveData<StateCollection> stateLiveData;
    private MutableLiveData<DistrictCollection> districtLiveData;
    private MutableLiveData<TahasilCollection> tahsilLiveData;
    private MutableLiveData<VillageCollection> villageLiveData;

    public AddressInfoViewModel() {
        addressRepository = new AddressRepository();
    }


    public LiveData<StateCollection> getStateList() {
        stateLiveData = new MutableLiveData<>();
        loadStates(stateLiveData);
        return stateLiveData;
    }

    public LiveData<DistrictCollection> getDistrictList(int stateId) {

        districtLiveData = new MutableLiveData<>();
        loadDistricts(districtLiveData, stateId);
        return districtLiveData;
    }

    public LiveData<TahasilCollection> getTahasilList(int districtId) {
        tahsilLiveData = new MutableLiveData<>();
        loadTahasil(tahsilLiveData, districtId);
        return tahsilLiveData;
    }

    public LiveData<VillageCollection> getVillageList(int tahasilId) {
        villageLiveData = new MutableLiveData<>();
        loadVillages(villageLiveData, tahasilId);
        return villageLiveData;
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

    public MutableLiveData<String> getState() {
        return state;
    }

    public void setState(MutableLiveData<String> state) {
        this.state = state;
    }

    public MutableLiveData<String> getDistrict() {
        return district;
    }

    public void setDistrict(MutableLiveData<String> district) {
        this.district = district;
    }

    public MutableLiveData<String> getTahasil() {
        return tahasil;
    }

    public void setTahasil(MutableLiveData<String> tahasil) {
        this.tahasil = tahasil;
    }

    public MutableLiveData<String> getVillage() {
        return village;
    }

    public void setVillage(MutableLiveData<String> village) {
        this.village = village;
    }

    public MutableLiveData<String> getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(MutableLiveData<String> postalCode) {
        this.postalCode = postalCode;
    }

    public Address getAddress() {

        Address address = new Address();
        if (houseNo.getValue() != null)
            address.endusrHouseAddress = houseNo.getValue();
        if(landmark.getValue() != null)
            address.endusrLandMark = landmark.getValue();
        if(state.getValue() != null)
            address.endusrState = state.getValue();
        if(district.getValue() != null)
            address.endusrDistrict = district.getValue();
        if(tahasil.getValue() != null)
            address.tehsil = tahasil.getValue();
        if(village.getValue() != null)
            address.endusrVillage = village.getValue();
        if(postalCode.getValue() != null)
            address.endusrpostalCode = Long.parseLong(postalCode.getValue());
        return address;
    }

    public AddressForQua getQuarantineAddress() {

        AddressForQua address = new AddressForQua();
        if (houseNo.getValue() != null)
            address.endusrHouseAddress = houseNo.getValue();
        if(landmark.getValue() != null)
            address.endusrLandMark = landmark.getValue();
        if(state.getValue() != null)
            address.endusrState = state.getValue();
        if(district.getValue() != null)
            address.endusrDistrict = district.getValue();
        if(tahasil.getValue() != null)
            address.tehsil = tahasil.getValue();
        if(village.getValue() != null)
            address.endusrVillage = village.getValue();
        if(postalCode.getValue() != null)
            address.endusrpostalCode = Long.parseLong(postalCode.getValue());
        return address;
    }

    private void loadStates(MutableLiveData<StateCollection> stateLiveData) {
        addressRepository.getStateList(stateLiveData);
    }

    private void loadDistricts(MutableLiveData<DistrictCollection> districtLiveData, int stateId) {
        addressRepository.getDistrictList(districtLiveData, stateId);
    }

    private void loadTahasil(MutableLiveData<TahasilCollection> tahasilLiveData, int districtId) {
        addressRepository.getTahasilList(tahasilLiveData, districtId);
    }

    private void loadVillages(MutableLiveData<VillageCollection> villageLiveData, int tahasilId) {
        addressRepository.getVillageList(villageLiveData, tahasilId);
    }

}
