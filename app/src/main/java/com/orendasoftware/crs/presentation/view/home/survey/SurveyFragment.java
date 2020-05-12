package com.orendasoftware.crs.presentation.view.home.survey;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.SurveyFragmentBinding;
import com.orendasoftware.crs.presentation.view.home.ReviewFragment;
import com.orendasoftware.crs.presentation.view_models.home.SurveyViewModel;

public class SurveyFragment extends Fragment {

    private SurveyViewModel mViewModel;
    SurveyFragmentBinding mSurveyBinding;

    public static SurveyFragment newInstance() {
        return new SurveyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSurveyBinding = SurveyFragmentBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProviders.of(this).get(SurveyViewModel.class);
        mSurveyBinding.setLifecycleOwner(this);

        mSurveyBinding.btnAddSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ReviewFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        mViewModel.getSurveyData().observe(getViewLifecycleOwner(), data -> {
            // update UI

            SurveyAdapter surveyAdapter = new SurveyAdapter(data);
            mSurveyBinding.surveyRecyclerView.setLayoutManager(new LinearLayoutManager(mSurveyBinding.surveyRecyclerView.getContext()));
            mSurveyBinding.surveyRecyclerView.setAdapter(surveyAdapter);

        });

        return mSurveyBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

}
