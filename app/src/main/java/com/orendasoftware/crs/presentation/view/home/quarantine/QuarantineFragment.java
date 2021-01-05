package com.orendasoftware.crs.presentation.view.home.quarantine;

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

import com.orendasoftware.crs.databinding.QuarantineFragmentBinding;
import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.presentation.view.home.common.Constants;
import com.orendasoftware.crs.presentation.view.home.common.PersonInfoActivity;
import com.orendasoftware.crs.presentation.view.home.common.ReviewActivity;
import com.orendasoftware.crs.presentation.view_models.home.quarantine.QuarantineViewModel;

public class QuarantineFragment extends Fragment implements QuarantineAdapter.GetQuarantineDataForEdit {

    private QuarantineViewModel mViewModel;
    private QuarantineFragmentBinding mQuarantineBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mQuarantineBinding = QuarantineFragmentBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProviders.of(this).get(QuarantineViewModel.class);
        mQuarantineBinding.setLifecycleOwner(this);
        mQuarantineBinding.setViewModel(mViewModel);
        Constants.FRAGMENT = "QUARANTINE";

        ProgressDialog progress = new ProgressDialog(getContext());
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
        progress.show();

        mViewModel.getQurantineData().observe(getViewLifecycleOwner(), data->{
            QuarantineAdapter quarantineAdapter = new QuarantineAdapter(this, data);
            mQuarantineBinding.quarantineRecyclerView.setLayoutManager(new LinearLayoutManager(mQuarantineBinding.quarantineRecyclerView.getContext()));
            mQuarantineBinding.quarantineRecyclerView.setAdapter(quarantineAdapter);
            progress.dismiss();
        });

        mQuarantineBinding.btnAddQuarantine.setOnClickListener(v -> {
            Intent intent =  new Intent(getActivity(), PersonInfoActivity.class);
            startActivity(intent);
        });

        return mQuarantineBinding.getRoot();
    }

    @Override
    public void getEditQuarantineData(Integer id) {
        mViewModel.getEditQuarantineData(id).observe(this, data-> {
            Quarantine quarantine = data;
            Bundle bundle = new Bundle();
            bundle.putString("edit", "enable_edit");
            bundle.putSerializable("model", quarantine);
            Intent intent = new Intent(getContext(), ReviewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });

    }
}
