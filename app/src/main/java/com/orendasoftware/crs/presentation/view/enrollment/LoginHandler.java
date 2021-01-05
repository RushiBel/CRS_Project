package com.orendasoftware.crs.presentation.view.enrollment;

import android.text.Editable;
import android.text.TextUtils;

import androidx.databinding.BindingAdapter;

import com.orendasoftware.crs.databinding.LoginFragmentBinding;

public class LoginHandler {
    LoginFragmentBinding binding;

    public void setBinding(LoginFragmentBinding binding) {
        this.binding = binding;
    }

    public void passwordValidator(Editable editable) {
        if (binding.etPassword == null) return;
        int minimumLength = 5;
        if (!TextUtils.isEmpty(editable.toString()) && editable.length() < minimumLength) {
            binding.etPassword.setError("Password must be minimum " + minimumLength + " length");
        } else {
            binding.etPassword.setError(null);
        }
    }
}
