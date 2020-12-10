package com.example.borcheltmadfl.ui.madlib;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.borcheltmadfl.R;

public class MadLibFragment extends Fragment {

    private MadLibViewModel madLibViewModel;
    private TextView mCompany;
    private TextView mPlrlNoun;
    private TextView mNumber;
    private TextView mVerbing;
    private TextView mNoun1;
    private TextView mMaleName;
    private TextView mColor;
    private TextView mNoun2;
    private TextView mPrefix;
    private TextView mPstVerb;
    private TextView mAdjective;
    private TextView mRoom;
    private TextView mOutput;
    private LinearLayout mVerticalLayout;
    private Button makeStory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        madLibViewModel =
                new ViewModelProvider(this).get(MadLibViewModel.class);

        Activity root = new Activity();
        mCompany = (TextView) root.findViewById(R.id.txtCompany);
        mPlrlNoun = (TextView) root.findViewById(R.id.txtPlrlNoun);
        mNumber = (TextView) root.findViewById(R.id.txtNumber);
        mVerbing = (TextView) root.findViewById(R.id.txtVerbing);
        mNoun1 = (TextView) root.findViewById(R.id.txtNoun1);
        mMaleName = (TextView) root.findViewById(R.id.txtMaleName);
        mColor = (TextView) root.findViewById(R.id.txtColor);
        mNoun2 = (TextView) root.findViewById(R.id.txtNoun2);
        mPrefix = (TextView) root.findViewById(R.id.txtPrefix);
        mPstVerb = (TextView) root.findViewById(R.id.txtPstVerb);
        mAdjective = (TextView) root.findViewById(R.id.txtAdjective);
        mRoom = (TextView) root.findViewById(R.id.txtBuilding);
        mVerticalLayout = (LinearLayout) root.findViewById(R.id.verticalLayout);
        mOutput = (TextView) root.findViewById(R.id.outputText);
        makeStory = (Button) root.findViewById(R.id.StoryGen);


        makeStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String company = mCompany.getText().toString();
                String pluralNoun = mPlrlNoun.getText().toString();
                String number = mNumber.getText().toString();
                String verbIng = mVerbing.getText().toString();
                String noun1 = mNoun1.getText().toString();
                String maleName = mMaleName.getText().toString();
                String color = mColor.getText().toString();
                String noun2 = mNoun2.getText().toString();
                String prefix = mPrefix.getText().toString();
                String pstVerb = mPstVerb.getText().toString();
                String adjective = mAdjective.getText().toString();
                String room = mRoom.getText().toString();

                mVerticalLayout.setVisibility(View.GONE);

                mOutput.setVisibility(View.VISIBLE);
                mOutput.setText("The Office at " + company + "\nAt " + company + ", everyone sits in " + pluralNoun + "that are spaced " + number + " feet away from each other. This makes " + verbIng + " on the " + noun1 + " a public ");
                mOutput.append("activity, because everyone around can hear what you are saying. It's a wonder that people get any work done with all the noise.\n\nThere is an emplyee at " + company + " named ");
                mOutput.append(maleName + ", he used to have a " + color + " " + noun2 + "on his desk, but someone " + prefix + pstVerb + " it. After the loss of his " + noun2 + ". " + maleName + " started muttering to himself ");
                mOutput.append("a lot. He looked really " + adjective + ". I guess he was annoying people, because the company moved his desk into the " + room);
            }
        });

    }
}}