package com.example.borcheltmadfl.ui.scifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.borcheltmadfl.R;

import java.util.Random;

public class ScifiFragment extends Fragment {

    private ScifiViewModel scifiViewModel;

    private TextView mFirstName; //instatiating the object, it acts as a global
    private TextView mLastName;  //creating a field variable or a global variable
    private TextView mCity;
    private TextView mSchool;
    private TextView mBrother;
    private TextView mSister;
    private Button submitButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scifiViewModel =
                new ViewModelProvider(this).get(ScifiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scifi, container, false);

            mFirstName = (TextView) root.findViewById(R.id.txtFirstName);
            mLastName = (TextView) root.findViewById(R.id.txtLastName);
            mCity = (TextView) root.findViewById(R.id.txtCity);
            mSchool = (TextView) root.findViewById(R.id.txtSchool);
            mBrother = (TextView) root.findViewById(R.id.txtBrother);
            mSister = (TextView) root.findViewById(R.id.txtSister);
            submitButton = (Button) root.findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Random random = new Random();
            String fName = mFirstName.getText().toString();// getText() gets the info
            String lName = mLastName.getText().toString();
            String city = mCity.getText().toString();
            String school = mSchool.getText().toString();
            String brother = mBrother.getText().toString();
            String sister = mSister.getText().toString();

            String sciFName = fName.substring(0,(int) (random.nextDouble()*fName.length())) + lName.substring((int) (random.nextDouble()*lName.length()));
            String sciLName = city.substring(0, (int) (random.nextDouble()*city.length())) + school.substring((int) (random.nextDouble()*school.length()));
            String sciPName = brother.substring(0,(int) (random.nextDouble()*brother.length())) + sister.substring((int) (random.nextDouble()*random.nextInt(sister.length())));

            TextView output = (TextView) root.findViewById(R.id.txtOutput);
            output.setText("");
            output.append("I am " + sciFName + " " + sciLName + " of the planet " + sciPName);//append is the same as println
            output.append("Welcome to the Party!");
            }
        });
        return root;
    }
}