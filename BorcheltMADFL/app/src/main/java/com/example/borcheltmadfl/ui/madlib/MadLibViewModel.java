package com.example.borcheltmadfl.ui.madlib;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MadLibViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MadLibViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}