package com.orendasoftware.crs.domain.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.api_model.QuarantineResponse;
import com.orendasoftware.crs.domain.data.model.QuarantineRecord;
import com.orendasoftware.crs.domain.data.networking.CovidReportingAPI;
import com.orendasoftware.crs.domain.deps.module.NetworkModule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class QuarantineRepository {
    private List<QuarantineRecord> quarantineRecords;
    private CovidReportingAPI api;
    private MutableLiveData<List<QuarantineRecord>> qurantineLiveData = new MutableLiveData<>();

    public QuarantineRepository() {
        quarantineRecords = new ArrayList<>();
        Retrofit retrofit = NetworkModule.getClient();
        api = retrofit.create(CovidReportingAPI.class);
    }

    public MutableLiveData<List<QuarantineRecord>> getQuarantineList() {
        Call<List<QuarantineResponse>> quarantineCall = api.getQuarantineList("amit@gmail.com");

        quarantineCall.enqueue(new Callback<List<QuarantineResponse>>() {
            @Override
            public void onResponse(Call<List<QuarantineResponse>> call, Response<List<QuarantineResponse>> response) {
                List<QuarantineResponse> quarantineResponseList = response.body();
                String name, contactNo = "", type = "", status = "", startDate = "", endDate = "";
                Integer id;

                for(int i = 0 ; i < quarantineResponseList.size() ; i++) {

                    id = quarantineResponseList.get(i).getId();

                    if(quarantineResponseList.get(i).getQuaMName() != null)
                        name = quarantineResponseList.get(i).getQuaFName() + " " + quarantineResponseList.get(i).getQuaMName() + " " + quarantineResponseList.get(i).getQuaLName();
                    else
                        name = quarantineResponseList.get(i).getQuaFName() + " " + quarantineResponseList.get(i).getQuaLName();

                    if(quarantineResponseList.get(i).getQuaContactNumber() != null)
                        contactNo = String.valueOf(quarantineResponseList.get(i).getQuaContactNumber());

                    if(quarantineResponseList.get(i).getQuarantineType() != null)
                        type = quarantineResponseList.get(i).getQuarantineType();

                    if(quarantineResponseList.get(i).getQuaStatus() != null)
                        status = quarantineResponseList.get(i).getQuaStatus();

                    if(quarantineResponseList.get(i).getQuaStartDate() != null) {
                        DateFormat dateFormat = new SimpleDateFormat("dd MMMM");
                        startDate = dateFormat.format(quarantineResponseList.get(i).getQuaStartDate());
                    }

                    if(quarantineResponseList.get(i).getQuaEndDate() != null) {
                        DateFormat dateFormat = new SimpleDateFormat("dd MMMM");
                        endDate = dateFormat.format(quarantineResponseList.get(i).getQuaEndDate());
                    }

                    quarantineRecords.add(new QuarantineRecord(id, name, contactNo, type, status,  startDate, endDate));
                    qurantineLiveData.setValue(quarantineRecords);

                }

            }

            @Override
            public void onFailure(Call<List<QuarantineResponse>> call, Throwable t) {
                System.out.print("ERROR");
            }
        });
        return qurantineLiveData;
    }

    public void getEditQuarantineData(Integer id, MutableLiveData<Quarantine> editQuarantineData) {


        Call<Quarantine> editQuarantineCall = api.editQuarantineDetails(id);

        editQuarantineCall.enqueue(new Callback<Quarantine>() {
            @Override
            public void onResponse(Call<Quarantine> call, Response<Quarantine> response) {
                Quarantine quarantine = response.body();
                quarantine.id = id;
                editQuarantineData.setValue(quarantine);
            }

            @Override
            public void onFailure(Call<Quarantine> call, Throwable t) {
                System.out.print("ERROR");
            }
        });
    }
}
