package com.orendasoftware.crs.presentation.view.base;

import android.app.Application;
import android.content.Context;

import com.orendasoftware.crs.presentation.view.home.LocaleHelper;

public class CovidReportingSystemApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
