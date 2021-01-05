package com.orendasoftware.crs.domain.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.orendasoftware.crs.domain.data.api_model.HomeResponse;
import com.orendasoftware.crs.domain.data.networking.CovidReportingAPI;
import com.orendasoftware.crs.domain.deps.module.NetworkModule;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeRepository {
    private CovidReportingAPI api;
    private MutableLiveData<HomeResponse> homeResponseMutableLiveData = new MutableLiveData<>();

    public HomeRepository() {
        Retrofit retrofit = NetworkModule.getClient();
        api = retrofit.create(CovidReportingAPI.class);
    }

    public MutableLiveData<HomeResponse> getHomeData() {

        Call<HomeResponse> homeResponseCall = api.getHomeData("amit@gmail.com");

        homeResponseCall.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                homeResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                System.out.print("ERROR");
            }
        });

        return homeResponseMutableLiveData;
    }
}
