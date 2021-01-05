package com.orendasoftware.crs.presentation.view.enrollment;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.orendasoftware.crs.databinding.LoginFragmentBinding;
import com.orendasoftware.crs.presentation.view.home.BaseActivity;
import com.orendasoftware.crs.presentation.view_models.enrollment.LoginViewModel;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import static android.content.Context.TELEPHONY_SERVICE;

public class LoginFragment extends Fragment implements SignInClickListener{
    private LoginViewModel mViewModel;
    private LoginFragmentBinding mLoginBinding;
    private TelephonyManager mTelephonyManager;
    public int PERMISSIONS_REQUEST_READ_PHONE_STATE = 21;
    private String imeiNumber;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mLoginBinding = LoginFragmentBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        getDeviceIMEI();
        LoginHandler loginHandler = new LoginHandler();
        loginHandler.setBinding(mLoginBinding);
        mLoginBinding.setHandler(loginHandler);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String app_lang = preferences.getString("app_lang", "not_set");

        if(app_lang.equals("not_set")) {
            LanguageOptionDialog cdd = new LanguageOptionDialog(getActivity());
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
        }

        mLoginBinding.setLoginViewModel(mViewModel);
        mLoginBinding.setSignInClickListener(this::onSignInClick);

        return mLoginBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onSignInClick() {
        String mac = mViewModel.getMacAddr();
        System.out.print(mac);
        if(TextUtils.isEmpty(mViewModel.getUserId().getValue()))
            mLoginBinding.etUserId.setError("Please Enter User Id");
        else if(TextUtils.isEmpty(mViewModel.getPassword().getValue()))
            mLoginBinding.etPassword.setError("Please Enter password");
        else {
            mViewModel.onSignIn(getView());
            Intent intent = new Intent(getContext(), BaseActivity.class);
            startActivity(intent);
        }
    }

    /**
     * This metho get device IMEI number
     */
    public void getDeviceIMEI() {
        mTelephonyManager = (TelephonyManager) getContext().getSystemService(TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                //Asking for permission
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},
                        PERMISSIONS_REQUEST_READ_PHONE_STATE);
            } else {
                //accessing the IMEI number permission is granted
                //If the android OS version >=7 then get the IMEI number
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    imeiNumber = mTelephonyManager.getImei();
                } else {
                    imeiNumber = mTelephonyManager.getDeviceId();
                }
            }
        } else {
            imeiNumber = mTelephonyManager.getDeviceId();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_REQUEST_READ_PHONE_STATE
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getDeviceIMEI();
        } else {
            //Getting IMEI number
//            getIMEINumber();
        }
    }

}
