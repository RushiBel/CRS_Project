package com.orendasoftware.crs.presentation.view_models.home.quarantine;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orendasoftware.crs.domain.data.api_model.Quarantine;
import com.orendasoftware.crs.domain.data.model.QuarantineRecord;
import com.orendasoftware.crs.domain.data.repository.QuarantineRepository;

import java.util.List;

public class QuarantineViewModel extends ViewModel {

    private MutableLiveData<List<QuarantineRecord>> quarantineData;
    private QuarantineRepository quarantineRepository;
    private MutableLiveData<Quarantine> editQuarantineData;

    public LiveData<List<QuarantineRecord>> getQurantineData() {
        quarantineRepository = new QuarantineRepository();
        quarantineData = quarantineRepository.getQuarantineList();
        return quarantineData;
    }

    public LiveData<Quarantine> getEditQuarantineData(Integer id) {
        editQuarantineData = new MutableLiveData<>();
        quarantineRepository = new QuarantineRepository();
        quarantineRepository.getEditQuarantineData(id, editQuarantineData);
        return editQuarantineData;
    }

}
