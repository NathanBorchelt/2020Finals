package com.example.gdritzys.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to GD Ritzy's! You can use this app to make an order. You can order things like ice cream, burger, sides, chili menu, salad and others");
    }

    public LiveData<String> getText() {
        return mText;
    }
}