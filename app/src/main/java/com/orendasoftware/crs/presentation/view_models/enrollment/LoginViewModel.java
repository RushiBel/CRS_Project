package com.orendasoftware.crs.presentation.view_models.enrollment;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.domain.data.networking.CovidReportingAPI;
import com.orendasoftware.crs.domain.deps.module.NetworkModule;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginViewModel extends ViewModel {

    MutableLiveData<String> userId = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public void setPassword(MutableLiveData<String> password) {
        this.password = password;
    }

    public MutableLiveData<String> getUserId() {
        return userId;
    }

    public void setUserId(MutableLiveData<String> userId) {
        this.userId = userId;
    }

    public void onSignIn(View view) {
//        Retrofit retrofit = NetworkModule.getClient();
//        CovidReportingAPI api = retrofit.create(CovidReportingAPI.class);
//        Call<String> surveyCall = api.getState();
//
//        surveyCall.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                System.out.print("SUCCESS");
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                System.out.print("ERROR");
//            }
//        });
    }


    /**
     * This method will return the MacAddress of the DEVICE
     * @return
     */
    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    //res1.append(Integer.toHexString(b & 0xFF) + ":");
                    res1.append(String.format("%02X:",b));
                    System.out.println("This is the mac address" + res1.toString());
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return "";
    }


}
