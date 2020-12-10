package com.example.gdritzys.ui.sandwiches;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SandwichViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SandwichViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is sandwich fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}