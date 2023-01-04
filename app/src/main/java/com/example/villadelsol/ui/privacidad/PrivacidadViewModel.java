package com.example.villadelsol.ui.privacidad;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrivacidadViewModel extends ViewModel {

        private final MutableLiveData<String> mText;

    public PrivacidadViewModel() {
            mText = new MutableLiveData<>();
            //mText.setValue("SERVICIOS");
        }

        public LiveData<String> getText() {
            return mText;
        }
}
