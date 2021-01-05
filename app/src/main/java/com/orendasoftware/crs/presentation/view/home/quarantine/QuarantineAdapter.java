package com.orendasoftware.crs.presentation.view.home.quarantine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.QuarantineListItemBinding;
import com.orendasoftware.crs.domain.data.model.QuarantineRecord;
import com.orendasoftware.crs.presentation.view_models.home.quarantine.QuarantineListItemViewModel;

import java.util.List;

public class QuarantineAdapter extends RecyclerView.Adapter<QuarantineAdapter.QuarantineViewHolder> {

    private List<QuarantineRecord> quarantineRecordList;
    GetQuarantineDataForEdit mQuarantineDataEdit;


    public QuarantineAdapter(GetQuarantineDataForEdit quarantineDataForEdit, List<QuarantineRecord> quarantineRecords) {
        this.mQuarantineDataEdit = quarantineDataForEdit;
        this.quarantineRecordList = quarantineRecords;
        this.notifyDataSetChanged();
    }

    public interface GetQuarantineDataForEdit {
        void getEditQuarantineData(Integer id);
    }

    @NonNull
    @Override
    public QuarantineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quarantine_list_item,
                new FrameLayout(parent.getContext()),false);
        return new QuarantineViewHolder(itemView, mQuarantineDataEdit);
    }

    @Override
    public void onBindViewHolder(@NonNull QuarantineViewHolder holder, int position) {
        QuarantineRecord quarantineRecord = quarantineRecordList.get(position);
        holder.setViewModel(new QuarantineListItemViewModel(quarantineRecord));
    }

    @Override
    public int getItemCount() {
        return this.quarantineRecordList.size();
    }

    @Override
    public void onViewAttachedToWindow(QuarantineViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(QuarantineViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unBind();
    }

    static class QuarantineViewHolder extends RecyclerView.ViewHolder implements QuarantineListItemClickListener{
        QuarantineListItemBinding binding;
        GetQuarantineDataForEdit mQuarantineDataForEdit;

        public QuarantineViewHolder(View itemView, GetQuarantineDataForEdit quarantineDataForEdit) {
            super(itemView);
            mQuarantineDataForEdit = quarantineDataForEdit;
            bind();
        }

        public void bind() {
            if(binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }

        }

        public void unBind() {
            if(binding != null) {
                binding.unbind();
            }
        }

        void setViewModel(QuarantineListItemViewModel quarantineViewModel) {
            if(binding != null) {
                binding.setListener(this);
                binding.setQuarantineViewModel(quarantineViewModel);
            }
        }

        @Override
        public void onItemClick(Integer id) {
            mQuarantineDataForEdit.getEditQuarantineData(id);
        }

    }
}
