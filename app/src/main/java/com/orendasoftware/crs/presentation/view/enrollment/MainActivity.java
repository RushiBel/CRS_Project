package com.orendasoftware.crs.presentation.view.enrollment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Context;
import android.os.Bundle;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.presentation.view.home.LocaleHelper;
import com.orendasoftware.crs.presentation.view.home.common.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
