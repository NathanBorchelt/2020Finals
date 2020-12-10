package com.example.gdritzys.ui.sandwiches;

import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;

import GDRMenuItems.Sandwich;

import static com.example.gdritzys.MainActivity.allItems;

public class SandwichFragment extends Fragment {

    private SandwichViewModel SandwichViewModel;
    private NumberPicker picker1;
    private NumberPicker picker2;
    private Button button0;
    private Button topping;
    private ArrayList<String> choosenToppings;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SandwichViewModel =
                new ViewModelProvider(this).get(SandwichViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sandwich, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        picker1 = (NumberPicker) root.findViewById(R.id.NumberPickerInput);
        picker2 = (NumberPicker) root.findViewById(R.id.NumberPickerInput0);
        button0 = (Button) root.findViewById(R.id.button0);
        topping = (Button) root.findViewById(R.id.button2);

        SandwichViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final double[] cost = {1.99,2.49,3.99,3.99,2.49,5.99};
        final String[] options = {"Hamburger","Cheeseburger", "Double Ritz", "Fish Sandwich", "Chicken Grill", "World's Best PB&J" };
        picker1.setMinValue(0);
        picker1.setMaxValue(options.length-1);
        picker1.setDisplayedValues(options);

        final String[] options0 = {"Ketchup","Mustard", "Pickles", "Mayonaisse", "Onions", "Lettuce", "Cheese", "Tomatoes", "Bacon" };
        picker2.setMinValue(0);
        picker2.setMaxValue(options0.length-1);
        picker2.setDisplayedValues(options0);
        /*
        numberInputText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try {
                    inputNumber = Double.valueOf(numberInputText.getText().toString());
                } catch (NullPointerException | NumberFormatException e) {
                    Log.d("frequency", "Something went wrong" + e);

                }

            }
        });
*/
        topping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosenToppings.add(options0[picker2.getValue()]);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sandwich newSandwich = new Sandwich(options[picker1.getValue()],cost[picker1.getValue()],choosenToppings);
                allItems.add(newSandwich);
            }
        });
        return root;
    }
}