package com.orendasoftware.crs.presentation.view.home.survey;


import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.orendasoftware.crs.databinding.SurveyFragmentBinding;

import com.orendasoftware.crs.domain.data.api_model.Survey;
import com.orendasoftware.crs.presentation.view.home.common.Constants;
import com.orendasoftware.crs.presentation.view.home.common.PersonInfoActivity;
import com.orendasoftware.crs.presentation.view.home.common.ReviewActivity;
import com.orendasoftware.crs.presentation.view_models.home.survey.SurveyViewModel;

public class SurveyFragment extends Fragment implements SurveyAdapter.GetSurveyDataForEdit {

    private SurveyViewModel mViewModel;
    private SurveyFragmentBinding mSurveyBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSurveyBinding = SurveyFragmentBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProviders.of(this).get(SurveyViewModel.class);
        mSurveyBinding.setLifecycleOwner(this);
        Constants.FRAGMENT = "SURVEY";

        ProgressDialog progress = new ProgressDialog(getContext());
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
        progress.show();


        mSurveyBinding.btnAddSurvey.setOnClickListener(v -> {
            Intent intent =  new Intent(getActivity(), PersonInfoActivity.class);
            startActivity(intent);
        });

        mViewModel.getSurveyData().observe(getViewLifecycleOwner(), data -> {
            // update UI
            SurveyAdapter surveyAdapter = new SurveyAdapter(this, data);
            mSurveyBinding.surveyRecyclerView.setLayoutManager(new LinearLayoutManager(mSurveyBinding.surveyRecyclerView.getContext()));
            mSurveyBinding.surveyRecyclerView.setAdapter(surveyAdapter);
            // To dismiss the dialog
            progress.dismiss();

        });

        return mSurveyBinding.getRoot();
    }

    @Override
    public void getEditSurveyData(Integer id) {
        mViewModel.getEditSurveyData(id).observe(this, data-> {
            Survey survey = data;
            Bundle bundle = new Bundle();
            bundle.putString("edit", "enable_edit");
            bundle.putSerializable("model", survey);
            Intent intent = new Intent(getContext(), ReviewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

}
