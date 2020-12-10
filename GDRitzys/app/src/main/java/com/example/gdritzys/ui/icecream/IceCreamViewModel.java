package com.example.gdritzys.ui.icecream;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IceCreamViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IceCreamViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Ice Cream fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}