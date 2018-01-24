package com.example.t00551333.memory;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GameSettingsActivity extends MainActivity {

    RadioGroup sizeGroup, timeGroup;
    RadioButton half, one, two, fourxfive, fivexsix;
    int size = 0;
    int time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        timeGroup = (RadioGroup) findViewById(R.id.radioGroup);
        sizeGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        half = (RadioButton) findViewById(R.id.radioButton);
        one = (RadioButton) findViewById(R.id.radioButton2);
        two = (RadioButton) findViewById(R.id.radioButton3);
        fourxfive = (RadioButton) findViewById(R.id.radioButton4);
        fivexsix = (RadioButton) findViewById(R.id.radioButton5);
//Retrieving checked settings from earlier changes made, if any
        SharedPreferences prefsState = getSharedPreferences("STATE", MODE_PRIVATE);
        size = prefsState.getInt("SIZE", size);
        time = prefsState.getInt("TIME", time);
//Setting the checked radiobuttons depending on what is retrieved from SharedPreferences
        if(time == 0) {
            half.setChecked(true);
        }else if(time == 1) {
            one.setChecked(true);
        }else if(time == 2) {
            two.setChecked(true);
        }
        if(size == 0) {
            fourxfive.setChecked(true);
            fivexsix.setChecked(false);
        }else if(size == 1) {
            fivexsix.setChecked(true);
            fourxfive.setChecked(false);
        }

    }
//Saving the checked radiobuttons in SharedPreferences
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefsState = getSharedPreferences("STATE", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsState.edit();
        if(fourxfive.isChecked()) {
            editor.putInt("SIZE", 0);
        }else if(fivexsix.isChecked()) {
            editor.putInt("SIZE", 1);
        }
        if(half.isChecked()) {
            editor.putInt("TIME", 0);
        }else if(one.isChecked()) {
            editor.putInt("TIME", 1);
        }else if(two.isChecked()) {
            editor.putInt("TIME", 2);
        }
        editor.commit();
    }
}
