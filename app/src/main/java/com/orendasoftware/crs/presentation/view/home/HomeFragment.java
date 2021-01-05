package com.orendasoftware.crs.presentation.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.orendasoftware.crs.databinding.HomeFragmentBinding;
import com.orendasoftware.crs.domain.data.api_model.HomeResponse;
import com.orendasoftware.crs.presentation.view_models.home.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private HomeFragmentBinding homeFragmentBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false);
        homeFragmentBinding.setLifecycleOwner(this);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.getHomeScreenData().observe(getViewLifecycleOwner(), this::setViewModel);
        return homeFragmentBinding.getRoot();
    }

    public void setViewModel(HomeResponse homeResponse) {
        mViewModel.setTodaysQuarantinedCount(String.valueOf(homeResponse.getTodaysQuarantinedCount()));
        mViewModel.setTodaysSurveyCount(String.valueOf(homeResponse.getTodaysSurveyCount()));
        mViewModel.setTodaysRelocationCount(String.valueOf(homeResponse.getTodaysRelocationCount()));
        mViewModel.setTotalQuarantinedCount(String.valueOf(homeResponse.getTotalQuarantinedCount()));
        mViewModel.setTotalSurveyCount(String.valueOf(homeResponse.getTotalSurveyCount()));
        mViewModel.setTotalRelocationCount(String.valueOf(homeResponse.getTotalRelocationCount()));
        homeFragmentBinding.setViewModel(mViewModel);
    }

}
