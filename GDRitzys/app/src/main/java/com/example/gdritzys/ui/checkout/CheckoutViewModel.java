package com.example.gdritzys.ui.checkout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CheckoutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CheckoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Ice Cream fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
