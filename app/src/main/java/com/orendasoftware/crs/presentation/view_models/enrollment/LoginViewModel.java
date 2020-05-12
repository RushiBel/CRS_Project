package com.orendasoftware.crs.presentation.view_models.enrollment;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.orendasoftware.crs.R;

public class LoginViewModel extends ViewModel {

    public void onSignIn(View view) {


        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_patientRegistrationFragment);
    }

}
