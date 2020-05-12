package com.orendasoftware.crs.presentation.view.enrollment;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.presentation.view.home.LocaleHelper;

public class LanguageOptionDialog extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;

    public LanguageOptionDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.language_option_dialog);
        yes = (Button) findViewById(R.id.btn_marathi);
        no = (Button) findViewById(R.id.btn_english);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor editor = preferences.edit();


        switch (v.getId()) {
            case R.id.btn_marathi:
                LocaleHelper.setLocale(c, "mr");
                editor.putString("app_lang", "mr");
                editor.apply();
                c.recreate();
                dismiss();
                break;
            case R.id.btn_english:
                LocaleHelper.setLocale(c, "en");
                editor.putString("app_lang", "en");
                editor.apply();
                c.recreate();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
