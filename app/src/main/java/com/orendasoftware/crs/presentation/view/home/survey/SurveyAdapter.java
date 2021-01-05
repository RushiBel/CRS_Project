package com.orendasoftware.crs.presentation.view.home.survey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.SurveyListItemBinding;
import com.orendasoftware.crs.domain.data.model.SurveyRecord;
import com.orendasoftware.crs.presentation.view_models.home.survey.SurveyItemViewModel;

import java.util.List;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder> {

    private List<SurveyRecord> surveyRecordData;
    public GetSurveyDataForEdit mGetSurveyDataEdit;

    public SurveyAdapter(GetSurveyDataForEdit getSurveyDataForEdit, List<SurveyRecord> surveyRecords) {
        mGetSurveyDataEdit = getSurveyDataForEdit;
        this.surveyRecordData = surveyRecords;
        this.notifyDataSetChanged();
    }

    public interface GetSurveyDataForEdit {
        void getEditSurveyData(Integer id);
    }

    @NonNull
    @Override
    public SurveyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.survey_list_item,
                new FrameLayout(parent.getContext()), false);
        return new SurveyViewHolder(itemView, mGetSurveyDataEdit);
    }

    @Override
    public void onBindViewHolder(@NonNull SurveyViewHolder holder, int position) {
        SurveyRecord surveyRecord = surveyRecordData.get(position);
        holder.setViewModel(new SurveyItemViewModel(surveyRecord));
    }

    @Override
    public int getItemCount() {
        return this.surveyRecordData.size();
    }

    @Override
    public void onViewAttachedToWindow(SurveyViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(SurveyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }


    static class SurveyViewHolder extends RecyclerView.ViewHolder implements SurveyListItemClickListener{

        SurveyListItemBinding binding;
        GetSurveyDataForEdit mSurveyDataEdit;

        public SurveyViewHolder(@NonNull View itemView, GetSurveyDataForEdit getSurveyDataForEdit) {
            super(itemView);
            mSurveyDataEdit = getSurveyDataForEdit;
            bind();
        }

        public void bind() {
            if(binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if(binding != null) {
                binding.unbind();
            }
        }

        void setViewModel(SurveyItemViewModel surveyItemViewModel) {
            if(binding != null) {
                binding.setListener(this);
                binding.setSurveyViewModel(surveyItemViewModel);
            }
        }

        @Override
        public void onItemClick(Integer id) {
            mSurveyDataEdit.getEditSurveyData(id);
        }
    }
}
