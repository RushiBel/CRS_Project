package com.orendasoftware.crs.domain.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.orendasoftware.crs.domain.data.api_model.DistrictCollection;
import com.orendasoftware.crs.domain.data.api_model.StateCollection;
import com.orendasoftware.crs.domain.data.api_model.TahasilCollection;
import com.orendasoftware.crs.domain.data.api_model.VillageCollection;
import com.orendasoftware.crs.domain.data.networking.CovidReportingAPI;
import com.orendasoftware.crs.domain.deps.module.NetworkModule;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddressRepository {

    private CovidReportingAPI api;

    public AddressRepository() {
        Retrofit retrofit = NetworkModule.getClient();
        api = retrofit.create(CovidReportingAPI.class);
    }

    public void getStateList(MutableLiveData<StateCollection> stateLiveData) {


        Call<StateCollection> stateCollectionCall = api.getState();

        stateCollectionCall.enqueue(new Callback<StateCollection>() {
            @Override
            public void onResponse(Call<StateCollection> call, Response<StateCollection> response) {
                stateLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<StateCollection> call, Throwable t) {
                System.out.print("ERROR");
            }
        });

    }

    public void getDistrictList(MutableLiveData<DistrictCollection> districtLiveData, int stateId) {

        Call<DistrictCollection> districtCollectionCall = api.getDistricts(stateId);

        districtCollectionCall.enqueue(new Callback<DistrictCollection>() {
            @Override
            public void onResponse(Call<DistrictCollection> call, Response<DistrictCollection> response) {
                districtLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DistrictCollection> call, Throwable t) {
                System.out.print("ERROR");
            }
        });

    }

    public void getTahasilList(MutableLiveData<TahasilCollection> tahasilLiveData, int districtId) {

        Call<TahasilCollection> tahasilCollectionCall = api.getTahasil(districtId);

        tahasilCollectionCall.enqueue(new Callback<TahasilCollection>() {
            @Override
            public void onResponse(Call<TahasilCollection> call, Response<TahasilCollection> response) {
                tahasilLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TahasilCollection> call, Throwable t) {
                System.out.print("ERROR");

            }
        });

    }

    public void getVillageList(MutableLiveData<VillageCollection> villageLiveData, int tahasilId) {

        Call<VillageCollection> villageCollectionCall = api.getVillages(tahasilId);

        villageCollectionCall.enqueue(new Callback<VillageCollection>() {
            @Override
            public void onResponse(Call<VillageCollection> call, Response<VillageCollection> response) {
                villageLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<VillageCollection> call, Throwable t) {
                System.out.print("ERROR");
            }
        });

    }

}
