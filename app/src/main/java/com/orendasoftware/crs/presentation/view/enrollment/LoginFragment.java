package com.orendasoftware.crs.presentation.view.enrollment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.orendasoftware.crs.databinding.LoginFragmentBinding;
import com.orendasoftware.crs.presentation.view_models.enrollment.LoginViewModel;

public class LoginFragment extends Fragment implements SignInClickListener{
    private LoginViewModel mViewModel;
    private LoginFragmentBinding mLoginBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mLoginBinding = LoginFragmentBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

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

        mViewModel.onSignIn(getView());
    }
}
