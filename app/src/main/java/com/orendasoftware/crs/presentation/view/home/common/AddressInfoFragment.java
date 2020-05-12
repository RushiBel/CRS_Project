package com.orendasoftware.crs.presentation.view.home.common;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orendasoftware.crs.R;

public class AddressInfoFragment extends Fragment {

    private AddressInfoViewModel mViewModel;

    public static AddressInfoFragment newInstance() {
        return new AddressInfoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.address_info_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddressInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}
