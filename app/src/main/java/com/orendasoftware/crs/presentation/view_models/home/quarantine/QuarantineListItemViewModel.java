package com.orendasoftware.crs.presentation.view_models.home.quarantine;

import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.model.QuarantineRecord;

public class QuarantineListItemViewModel extends ViewModel {
    private QuarantineRecord quarantineRecord;

    public QuarantineListItemViewModel(QuarantineRecord quarantineRecord) {
        this.quarantineRecord = quarantineRecord;
    }

    public Integer getId() { return quarantineRecord.getId(); }

    public String getName() {
        return quarantineRecord.getName();
    }

    public String getMobileNo() {
        return quarantineRecord.getMobileNo();
    }

    public String getStatus() {
        return quarantineRecord.getStatus();
    }

    public String getType() {
        return quarantineRecord.getType();
    }

    public String getStartDate() {
        return quarantineRecord.getStartDate();
    }

    public String getEndDate() {
        return quarantineRecord.getEndDate();
    }
}
