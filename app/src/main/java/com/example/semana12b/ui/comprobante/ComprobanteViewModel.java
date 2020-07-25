package com.example.semana12b.ui.comprobante;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComprobanteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ComprobanteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is comprobante fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}