package com.example.t00551333.memory;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;


public class HighScoresActivity extends MainActivity {

    float timeLeft = 0;
    int size = 0;
    String PLAYERNAME, PLACEHOLDER1, PLACEHOLDER2, PLACEHOLDER3, PLACEHOLDER4, PLACEHOLDER5, PLACEHOLDER6;
    TextView scoreBoard, scoreBoard2, scoreBoard3, scoreBoard4, scoreBoard5, scoreBoard6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
//Retrieves board size, player names, times and saved textView texts
        SharedPreferences prefsName = this.getSharedPreferences("NAMES", MODE_PRIVATE);
        SharedPreferences prefsState = this.getSharedPreferences("STATE", MODE_PRIVATE);
        SharedPreferences prefsTime5x6 = this.getSharedPreferences("TIME5x6", MODE_PRIVATE);
        SharedPreferences prefsTime4x5 = this.getSharedPreferences("TIME4x5", MODE_PRIVATE);
        SharedPreferences prefsText = this.getSharedPreferences("TEXTS", MODE_PRIVATE);

        size = prefsState.getInt("SIZE", size);
        PLAYERNAME = prefsName.getString("MostRecent", PLAYERNAME);
        if (size == 0) {
            timeLeft = prefsTime4x5.getFloat(PLAYERNAME, timeLeft);
        } else {
            timeLeft = prefsTime5x6.getFloat(PLAYERNAME, timeLeft);
        }
        scoreBoard = (TextView) findViewById(R.id.textView6);
        scoreBoard2 = (TextView) findViewById(R.id.textView5);
        scoreBoard3 = (TextView) findViewById(R.id.textView7);
        scoreBoard4 = (TextView) findViewById(R.id.textView9);
        scoreBoard5 = (TextView) findViewById(R.id.textView10);
        scoreBoard6 = (TextView) findViewById(R.id.textView11);
//Make sure an actual time for a finished game is present
        if (timeLeft != 0) {
//If the board size is set to 4x5, perform the following actions
            if (size == 0) {
//Only shows up if this activity is started without having ever entered a name or started a game
                if (PLAYERNAME == null || PLAYERNAME == "") {
                    scoreBoard.setText("No times to show yet!");
                    scoreBoard4.setText("No times to show yet!");
                } else {
//Gets the saved values of the textViews
                    PLACEHOLDER1 = prefsText.getString("scoreBoard", PLACEHOLDER1);
                    PLACEHOLDER2 = prefsText.getString("scoreBoard2", PLACEHOLDER2);
                    PLACEHOLDER3 = prefsText.getString("scoreBoard3", PLACEHOLDER3);
                    PLACEHOLDER4 = prefsText.getString("scoreBoard4", PLACEHOLDER4);
                    PLACEHOLDER5 = prefsText.getString("scoreBoard5", PLACEHOLDER5);
                    PLACEHOLDER6 = prefsText.getString("scoreBoard6", PLACEHOLDER6);
//Sets the saved values to the textViews
                    scoreBoard.setText(PLACEHOLDER1);
                    scoreBoard2.setText(PLACEHOLDER2);
                    scoreBoard3.setText(PLACEHOLDER3);
                    scoreBoard4.setText(PLACEHOLDER4);
                    scoreBoard5.setText(PLACEHOLDER5);
                    scoreBoard6.setText(PLACEHOLDER6);
                    Log.d("Scoreboard", scoreBoard.getText().toString());
//If statements ensure that the same name isn't added to the scoreboard more than once
                    if (scoreBoard.getText().toString().contains(PLAYERNAME) || scoreBoard.getText().toString().equals("") || scoreBoard.getText().toString().equals("No times to show yet!"))
                        scoreBoard.setText(PLAYERNAME + ": " + String.format("%.2f", timeLeft) + " seconds");
                    else if (scoreBoard2.getText().toString().contains(PLAYERNAME) || scoreBoard2.getText().toString().equals(""))
                        scoreBoard2.setText(PLAYERNAME + ": " + String.format("%.2f", timeLeft) + " seconds");
                    else if (scoreBoard3.getText().toString().contains(PLAYERNAME) || scoreBoard3.getText().toString().equals(""))
                        scoreBoard3.setText(PLAYERNAME + ": " + String.format("%.2f", timeLeft) + " seconds");
                }
//If the board size is set to 5x6, perform the following actions
            } else if (size == 1) {
                //Only shows up if this activity is started without having ever entered a name or started a game
                if (PLAYERNAME == null || PLAYERNAME == "") {
                    scoreBoard.setText("No times to show yet!");
                    scoreBoard4.setText("No times to show yet!");
                } else {
//Gets the saved values of the textViews
                    PLACEHOLDER1 = prefsText.getString("scoreBoard", PLACEHOLDER1);
                    PLACEHOLDER2 = prefsText.getString("scoreBoard2", PLACEHOLDER2);
                    PLACEHOLDER3 = prefsText.getString("scoreBoard3", PLACEHOLDER3);
                    PLACEHOLDER4 = prefsText.getString("scoreBoard4", PLACEHOLDER4);
                    PLACEHOLDER5 = prefsText.getString("scoreBoard5", PLACEHOLDER5);
                    PLACEHOLDER6 = prefsText.getString("scoreBoard6", PLACEHOLDER6);
//Sets the saved values to the textViews
                    scoreBoard.setText(PLACEHOLDER1);
                    scoreBoard2.setText(PLACEHOLDER2);
                    scoreBoard3.setText(PLACEHOLDER3);
                    scoreBoard4.setText(PLACEHOLDER4);
                    scoreBoard5.setText(PLACEHOLDER5);
                    scoreBoard6.setText(PLACEHOLDER6);
                    Log.d("Scoreboard4", scoreBoard4.getText().toString());
//If statements ensure that the same name isn't added to the scoreboard more than once
                    if (scoreBoard4.getText().toString().contains(PLAYERNAME) || scoreBoard4.getText().toString().equals("") || scoreBoard4.getText().toString().equals("No times to show yet!"))
                        scoreBoard4.setText(PLAYERNAME + ": " + String.format("%.2f", timeLeft) + " seconds");
                    else if (scoreBoard5.getText().toString().contains(PLAYERNAME) || scoreBoard5.getText().toString().equals(""))
                        scoreBoard5.setText(PLAYERNAME + ": " + String.format("%.2f", timeLeft) + " seconds");
                    else if (scoreBoard6.getText().toString().contains(PLAYERNAME) || scoreBoard6.getText().toString().equals(""))
                        scoreBoard6.setText(PLAYERNAME + ": " + String.format("%.2f", timeLeft) + " seconds");
                }
            }
        } else {
//Only shows up if this activity is started without having ever entered a name or started a game
                scoreBoard.setText("No times to show yet!");
                scoreBoard4.setText("No times to show yet!");
        }
    }

    //Saving the scoreboard texts onPause
    public void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences("TEXTS", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("scoreBoard", scoreBoard.getText().toString());
        editor.putString("scoreBoard2", scoreBoard2.getText().toString());
        editor.putString("scoreBoard3", scoreBoard3.getText().toString());
        editor.putString("scoreBoard4", scoreBoard4.getText().toString());
        editor.putString("scoreBoard5", scoreBoard5.getText().toString());
        editor.putString("scoreBoard6", scoreBoard6.getText().toString());

        editor.commit();
        Log.d("Scoreboard", scoreBoard.getText().toString());
    }

    //Saving the scoreboard texts onStop
    public void onStop() {
        super.onStop();

        SharedPreferences prefsText = getSharedPreferences("TEXTS", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsText.edit();

        PLACEHOLDER1 = scoreBoard.getText().toString();
        PLACEHOLDER2 = scoreBoard2.getText().toString();
        PLACEHOLDER3 = scoreBoard3.getText().toString();
        PLACEHOLDER4 = scoreBoard4.getText().toString();
        PLACEHOLDER5 = scoreBoard5.getText().toString();
        PLACEHOLDER6 = scoreBoard6.getText().toString();

        editor.putString("scoreBoard", PLACEHOLDER1);
        editor.putString("scoreBoard2", PLACEHOLDER2);
        editor.putString("scoreBoard3", PLACEHOLDER3);
        editor.putString("scoreBoard4", PLACEHOLDER4);
        editor.putString("scoreBoard5", PLACEHOLDER5);
        editor.putString("scoreBoard6", PLACEHOLDER6);
        editor.commit();
        Log.d("Scoreboard", scoreBoard.getText().toString());
    }
}
