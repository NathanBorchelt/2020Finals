package com.example.gdritzys.ui.checkout;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gdritzys.R;

import GDRMenuItems.MenuItem;

import static com.example.gdritzys.MainActivity.allItems;

public class CheckoutFragment extends Fragment {

    private static NumberPicker allChoosenItems;
    private CheckoutViewModel galleryViewModel;
    private Button removeItem;
    private static TextView totalCostDisplay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(CheckoutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_checkout, container, false);
        allChoosenItems = (NumberPicker) root.findViewById(R.id.showOrder);
        removeItem = (Button) root.findViewById(R.id.button3);
        totalCostDisplay = (TextView) root.findViewById(R.id.totalCost);
        resetNumberPicker();


        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allItems.remove(allChoosenItems.getValue());
                resetNumberPicker();
            }
        });






        return root;
    }
    public static void resetNumberPicker(){
        String[] itemNames = new String[allItems.size()];
        for(byte index = 0; index<itemNames.length;index++){
            itemNames[index] = allItems.get(index).getItemName();
        }
        Activity root = new Activity();
        allChoosenItems.setDisplayedValues(itemNames);
        allChoosenItems.setMaxValue(itemNames.length-1);
        allChoosenItems.setMinValue(0);
        totalCostDisplay.setText("Total Cost" + String.valueOf(allItemCost()));

    }
    public static double allItemCost(){
        double totalCost = 0;
        for(MenuItem menuItem : allItems){
            totalCost += menuItem.getCost();
        }
        return totalCost;
    }
}