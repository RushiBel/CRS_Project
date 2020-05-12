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
import com.orendasoftware.crs.domain.data.model.Survey;
import com.orendasoftware.crs.presentation.view_models.home.SurveyItemViewModel;

import java.util.List;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>{

    private List<Survey> surveyData;

    public SurveyAdapter(List<Survey> surveys) {
        this.surveyData = surveys;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SurveyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.survey_list_item,
                new FrameLayout(parent.getContext()), false);
        return new SurveyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SurveyViewHolder holder, int position) {
        Survey survey = surveyData.get(position);
        holder.setViewModel(new SurveyItemViewModel(survey));
    }

    @Override
    public int getItemCount() {
        return this.surveyData.size();
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

    static class SurveyViewHolder extends RecyclerView.ViewHolder {

        SurveyListItemBinding binding;

        public SurveyViewHolder(@NonNull View itemView) {
            super(itemView);
            bind();
        }

        void bind() {
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
                binding.setSurveyViewModel(surveyItemViewModel);
            }
        }
    }
}
