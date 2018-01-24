package com.example.t00551333.memory;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.datatype.Duration;

import static android.graphics.Color.argb;

public class MemoryActivity extends MainActivity implements View.OnClickListener{

    Button newGameButton;
    ProgressBar Bar;
    Drawable d;
    TextView timeText;
    Button[] Buttons = new Button[30];
    boolean click1 = false;
    boolean flag = true;
    int index1, index2, match = 0, matchCounter = 0, time;
    Integer[] flipped = new Integer[30];
    int[] Colors = new int[15];
    int[] buttonColor = new int[30];
    String PLAYERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        timeText = (TextView) findViewById(R.id.textView2);
        Buttons[0] = (Button) findViewById(R.id.button1);
        Buttons[0].setOnClickListener(this);
        Buttons[1] = (Button) findViewById(R.id.button2);
        Buttons[1].setOnClickListener(this);
        Buttons[2] = (Button) findViewById(R.id.button3);
        Buttons[2].setOnClickListener(this);
        Buttons[3] = (Button) findViewById(R.id.button4);
        Buttons[3].setOnClickListener(this);
        Buttons[4] = (Button) findViewById(R.id.button5);
        Buttons[4].setOnClickListener(this);
        Buttons[5] = (Button) findViewById(R.id.button6);
        Buttons[5].setOnClickListener(this);
        Buttons[6] = (Button) findViewById(R.id.button7);
        Buttons[6].setOnClickListener(this);
        Buttons[7] = (Button) findViewById(R.id.button8);
        Buttons[7].setOnClickListener(this);
        Buttons[8] = (Button) findViewById(R.id.button9);
        Buttons[8].setOnClickListener(this);
        Buttons[9] = (Button) findViewById(R.id.button10);
        Buttons[9].setOnClickListener(this);
        Buttons[10] = (Button) findViewById(R.id.button11);
        Buttons[10].setOnClickListener(this);
        Buttons[11] = (Button) findViewById(R.id.button12);
        Buttons[11].setOnClickListener(this);
        Buttons[12] = (Button) findViewById(R.id.button13);
        Buttons[12].setOnClickListener(this);
        Buttons[13] = (Button) findViewById(R.id.button14);
        Buttons[13].setOnClickListener(this);
        Buttons[14] = (Button) findViewById(R.id.button15);
        Buttons[14].setOnClickListener(this);
        Buttons[15] = (Button) findViewById(R.id.button16);
        Buttons[15].setOnClickListener(this);
        Buttons[16] = (Button) findViewById(R.id.button17);
        Buttons[16].setOnClickListener(this);
        Buttons[17] = (Button) findViewById(R.id.button18);
        Buttons[17].setOnClickListener(this);
        Buttons[18] = (Button) findViewById(R.id.button19);
        Buttons[18].setOnClickListener(this);
        Buttons[19] = (Button) findViewById(R.id.button20);
        Buttons[19].setOnClickListener(this);
        Buttons[20] = (Button) findViewById(R.id.button21);
        Buttons[20].setOnClickListener(this);
        Buttons[21] = (Button) findViewById(R.id.button22);
        Buttons[21].setOnClickListener(this);
        Buttons[22] = (Button) findViewById(R.id.button23);
        Buttons[22].setOnClickListener(this);
        Buttons[23] = (Button) findViewById(R.id.button24);
        Buttons[23].setOnClickListener(this);
        Buttons[24] = (Button) findViewById(R.id.button25);
        Buttons[24].setOnClickListener(this);
        Buttons[25] = (Button) findViewById(R.id.button26);
        Buttons[25].setOnClickListener(this);
        Buttons[26] = (Button) findViewById(R.id.button27);
        Buttons[26].setOnClickListener(this);
        Buttons[27] = (Button) findViewById(R.id.button28);
        Buttons[27].setOnClickListener(this);
        Buttons[28] = (Button) findViewById(R.id.button29);
        Buttons[28].setOnClickListener(this);
        Buttons[29] = (Button) findViewById(R.id.button30);
        Buttons[29].setOnClickListener(this);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(this);
        Bar=(ProgressBar)findViewById(R.id.progressBar);
        Arrays.fill(flipped, 0);
        d = Buttons[0].getBackground();
//Getting playername and time limit from SharedPreferences
        SharedPreferences prefsName = this.getSharedPreferences("NAMES", MODE_PRIVATE);
        PLAYERNAME = prefsName.getString("MostRecent", PLAYERNAME);

        SharedPreferences prefsState = this.getSharedPreferences("STATE", MODE_PRIVATE);
        if(prefsState.getInt("TIME", time) == 0) {
            time = 30;
        }else if(prefsState.getInt("TIME", time) == 1) {
            time = 60;
        }else if(prefsState.getInt("TIME", time) == 2) {
            time = 120;
        }else {
            time = 120;
        }
//Starting the countdown timer and the board randomizer
        timerBG timer = new timerBG();
        randomizeBG random = new randomizeBG();
        random.execute();
        timer.execute();
    }
/*Setting the clicked button to the randomly assigned color and if it is the
second click, checks if it matches the first click*/
    @Override
    public void onClick(View view) {
        matchBG match = new matchBG();
        switch (view.getId()) {
            case(R.id.button1): {
                if(flipped[0] == 0) {
                    if (!click1) {
                        Buttons[0].setBackgroundColor(buttonColor[0]);
                        flipped[0] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[0].setBackgroundColor(buttonColor[0]);
                        click1 = false;
                        flipped[0] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button2): {
                if(flipped[1] == 0) {
                    if (!click1) {
                        Buttons[1].setBackgroundColor(buttonColor[1]);
                        flipped[1] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[1].setBackgroundColor(buttonColor[1]);
                        click1 = false;
                        flipped[1] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button3): {
                if(flipped[2] == 0) {
                    if (!click1) {
                        Buttons[2].setBackgroundColor(buttonColor[2]);
                        flipped[2] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[2].setBackgroundColor(buttonColor[2]);
                        click1 = false;
                        flipped[2] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button4): {
                if(flipped[3] == 0) {
                    if (!click1) {
                        Buttons[3].setBackgroundColor(buttonColor[3]);
                        flipped[3] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[3].setBackgroundColor(buttonColor[3]);
                        click1 = false;
                        flipped[3] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button5): {
                if(flipped[4] == 0) {
                    if (!click1) {
                        Buttons[4].setBackgroundColor(buttonColor[4]);
                        flipped[4] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[4].setBackgroundColor(buttonColor[4]);
                        click1 = false;
                        flipped[4] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button6): {
                if(flipped[5] == 0) {
                    if (!click1) {
                        Buttons[5].setBackgroundColor(buttonColor[5]);
                        flipped[5] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[5].setBackgroundColor(buttonColor[5]);
                        click1 = false;
                        flipped[5] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button7): {
                if(flipped[6] == 0) {
                    if (!click1) {
                        Buttons[6].setBackgroundColor(buttonColor[6]);
                        flipped[6] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[6].setBackgroundColor(buttonColor[6]);
                        click1 = false;
                        flipped[6] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button8): {
                if(flipped[7] == 0) {
                    if (!click1) {
                        Buttons[7].setBackgroundColor(buttonColor[7]);
                        flipped[7] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[7].setBackgroundColor(buttonColor[7]);
                        click1 = false;
                        flipped[7] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button9): {
                if(flipped[8] == 0) {
                    if (!click1) {
                        Buttons[8].setBackgroundColor(buttonColor[8]);
                        flipped[8] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[8].setBackgroundColor(buttonColor[8]);
                        click1 = false;
                        flipped[8] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button10): {
                if(flipped[9] == 0) {
                    if (!click1) {
                        Buttons[9].setBackgroundColor(buttonColor[9]);
                        flipped[9] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[9].setBackgroundColor(buttonColor[9]);
                        click1 = false;
                        flipped[9] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button11): {
                if(flipped[10] == 0) {
                    if (!click1) {
                        Buttons[10].setBackgroundColor(buttonColor[10]);
                        flipped[10] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[10].setBackgroundColor(buttonColor[10]);
                        click1 = false;
                        flipped[10] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button12): {
                if(flipped[11] == 0) {
                    if (!click1) {
                        Buttons[11].setBackgroundColor(buttonColor[11]);
                        flipped[11] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[11].setBackgroundColor(buttonColor[11]);
                        click1 = false;
                        flipped[11] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button13): {
                if(flipped[12] == 0) {
                    if (!click1) {
                        Buttons[12].setBackgroundColor(buttonColor[12]);
                        flipped[12] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[12].setBackgroundColor(buttonColor[12]);
                        click1 = false;
                        flipped[12] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button14): {
                if(flipped[13] == 0) {
                    if (!click1) {
                        Buttons[13].setBackgroundColor(buttonColor[13]);
                        flipped[13] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[13].setBackgroundColor(buttonColor[13]);
                        click1 = false;
                        flipped[13] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button15): {
                if(flipped[14] == 0) {
                    if (!click1) {
                        Buttons[14].setBackgroundColor(buttonColor[14]);
                        flipped[14] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[14].setBackgroundColor(buttonColor[14]);
                        click1 = false;
                        flipped[14] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button16): {
                if(flipped[15] == 0) {
                    if (!click1) {
                        Buttons[15].setBackgroundColor(buttonColor[15]);
                        flipped[15] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[15].setBackgroundColor(buttonColor[15]);
                        click1 = false;
                        flipped[15] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button17): {
                if(flipped[16] == 0) {
                    if (!click1) {
                        Buttons[16].setBackgroundColor(buttonColor[16]);
                        flipped[16] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[16].setBackgroundColor(buttonColor[16]);
                        click1 = false;
                        flipped[16] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button18): {
                if(flipped[17] == 0) {
                    if (!click1) {
                        Buttons[17].setBackgroundColor(buttonColor[17]);
                        flipped[17] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[17].setBackgroundColor(buttonColor[17]);
                        click1 = false;
                        flipped[17] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button19): {
                if(flipped[18] == 0) {
                    if (!click1) {
                        Buttons[18].setBackgroundColor(buttonColor[18]);
                        flipped[18] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[18].setBackgroundColor(buttonColor[18]);
                        click1 = false;
                        flipped[18] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button20): {
                if(flipped[19] == 0) {
                    if (!click1) {
                        Buttons[19].setBackgroundColor(buttonColor[19]);
                        flipped[19] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[19].setBackgroundColor(buttonColor[19]);
                        click1 = false;
                        flipped[19] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button21): {
                if(flipped[20] == 0) {
                    if (!click1) {
                        Buttons[20].setBackgroundColor(buttonColor[20]);
                        flipped[20] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[20].setBackgroundColor(buttonColor[20]);
                        click1 = false;
                        flipped[20] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button22): {
                if(flipped[21] == 0) {
                    if (!click1) {
                        Buttons[21].setBackgroundColor(buttonColor[21]);
                        flipped[21] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[21].setBackgroundColor(buttonColor[21]);
                        click1 = false;
                        flipped[21] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button23): {
                if(flipped[22] == 0) {
                    if (!click1) {
                        Buttons[22].setBackgroundColor(buttonColor[22]);
                        flipped[22] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[22].setBackgroundColor(buttonColor[22]);
                        click1 = false;
                        flipped[22] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button24): {
                if(flipped[23] == 0) {
                    if (!click1) {
                        Buttons[23].setBackgroundColor(buttonColor[23]);
                        flipped[23] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[23].setBackgroundColor(buttonColor[23]);
                        click1 = false;
                        flipped[23] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button25): {
                if(flipped[24] == 0) {
                    if (!click1) {
                        Buttons[24].setBackgroundColor(buttonColor[24]);
                        flipped[24] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[24].setBackgroundColor(buttonColor[24]);
                        click1 = false;
                        flipped[24] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button26): {
                if(flipped[25] == 0) {
                    if (!click1) {
                        Buttons[25].setBackgroundColor(buttonColor[25]);
                        flipped[25] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[25].setBackgroundColor(buttonColor[25]);
                        click1 = false;
                        flipped[25] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button27): {
                if(flipped[26] == 0) {
                    if (!click1) {
                        Buttons[26].setBackgroundColor(buttonColor[26]);
                        flipped[26] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[26].setBackgroundColor(buttonColor[26]);
                        click1 = false;
                        flipped[26] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button28): {
                if(flipped[27] == 0) {
                    if (!click1) {
                        Buttons[27].setBackgroundColor(buttonColor[27]);
                        flipped[27] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[27].setBackgroundColor(buttonColor[27]);
                        click1 = false;
                        flipped[27] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button29): {
                if(flipped[28] == 0) {
                    if (!click1) {
                        Buttons[28].setBackgroundColor(buttonColor[28]);
                        flipped[28] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[28].setBackgroundColor(buttonColor[28]);
                        click1 = false;
                        flipped[28] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
            case(R.id.button30): {
                if(flipped[29] == 0) {
                    if (!click1) {
                        Buttons[29].setBackgroundColor(buttonColor[29]);
                        flipped[29] = 1;
                        click1 = true;
                        break;
                    } else {
                        Buttons[29].setBackgroundColor(buttonColor[29]);
                        click1 = false;
                        flipped[29] = 1;
                        match.execute();
                        break;
                    }
                }
                break;
            }
//Start a new game upon clicking this button after winning or losing a game
            case(R.id.newGameButton): {
                newGame();
                break;
            }
            default:
                break;
        }
    }
//Resetting the timer and re-randomizing playing field, starting a new game
    public void newGame() {
        for(int i = 0; i < Buttons.length; i++) {
            Buttons[i].setBackground(d);
            flipped[i] = 0;
            Buttons[i].setEnabled(true);
            Buttons[i].setVisibility(View.VISIBLE);

        }
        match = 0;
        click1 = false;
        matchCounter = 0;
        flag = true;
        Bar.setProgress(0);
        timerBG timer = new timerBG();
        randomizeBG random = new randomizeBG();
        random.execute();
        timer.execute();
    }
//Compares the two clicked buttons' colours
    public class matchBG extends AsyncTask<Integer, String, Integer> {

        Handler waitHandler = new Handler();
//Finds the clicked buttons from an array containing the state of each button
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            index1 = Arrays.asList(flipped).indexOf(1);
            index2 = Arrays.asList(flipped).lastIndexOf(1);
        }
//Comparing the colours assigned to the two clicked buttons
        @Override
        protected Integer doInBackground(Integer... integers) {

            if(buttonColor[index1] == buttonColor[index2]) {
                match = 1;
            }

            return match;
        }
//Resets of the two clicked buttons to their original background
        private Runnable delay = new Runnable(){

            @Override
            public void run() {
                Buttons[index1].setBackground(d);
                Buttons[index2].setBackground(d);
            }
        };

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
//If match, disables the clicked buttons and makes them invisible to show they are matched
            if(match == 1) {
                Buttons[index1].setEnabled(false);
                Buttons[index2].setEnabled(false);
                Buttons[index1].setVisibility(View.INVISIBLE);
                Buttons[index2].setVisibility(View.INVISIBLE);
                matchCounter++;
            }
//If no match, delays for a short time then runs the runnable to fip the buttons back
            else if(match == 0) {
                waitHandler.postDelayed(delay, 300);
            }
//Sets the whole array of button states to 0, signifying "not flipped"
            Arrays.fill(flipped, 0);
            match = 0;
/*If all 20 buttons have been matched, i.e. 10 matches have occurred, saves the time, enables player
to start new game, and shows a toast message*/
            if(matchCounter == 15) {
                SharedPreferences prefsTime = getSharedPreferences("TIME5x6", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefsTime.edit();
                Toast.makeText(getBaseContext(), "WELL DONE, YOU WIN!", Toast.LENGTH_LONG).show();
                flag = false;
                newGameButton.setEnabled(true);
                matchCounter = 0;
                float timeLeft = time - Float.parseFloat(String.valueOf(timeText.getText()));
                editor.putFloat(PLAYERNAME, timeLeft);
                editor.commit();
            }
        }
    }
//Randomizes the colors of the buttons' "backsides"
    public class randomizeBG extends AsyncTask<Integer, String, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Colors[0] = argb(255, 255, 1, 1);
            Colors[1] = argb(255, 1, 255, 1);
            Colors[2] = argb(255, 1, 1, 255);
            Colors[3] = argb(255, 255, 255, 1);
            Colors[4] = argb(255, 255, 1, 255);
            Colors[5] = argb(255, 1, 255, 255);
            Colors[6] = argb(255, 255, 255, 255);
            Colors[7] = argb(255, 1, 1, 1);
            Colors[8] = argb(255, 255, 140, 1);
            Colors[9] = argb(255, 255, 150, 185);
            Colors[10] = argb(255, 255, 180, 130);
            Colors[11] = argb(255, 10, 145, 1);
            Colors[12] = argb(255, 180, 130, 255);
            Colors[13] = argb(255, 150, 150, 150);
            Colors[14] = argb(255, 130, 190, 190);
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            return Colors.length;
        }

        @Override
        protected void onPostExecute(Integer answer) {
            super.onPostExecute(answer);
            List<Integer> color = new ArrayList<>();
//Uses an arraylist with the array of colours' values to shuffle them randomly
            for(int i = 0; i < Colors.length; i++) {
                color.add(Colors[i]);
                color.add(Colors[i]);
            }
            Collections.shuffle(color);
//Sets each now-randomized color to a button's "backside"
            for(int i = 0; i < buttonColor.length; i++) {
                buttonColor[i] = color.get(i);
            }
        }
    }
//Timer runs in background and increments the progress bar as well as displaying the time ticking down on screen
    public class timerBG extends AsyncTask<Integer, String, Integer> {
        Handler timingHandler = new Handler();
        double i = time * 1000;
        int count = 0;
        double timesec = 0;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            newGameButton.setEnabled(false);
            timingHandler.postDelayed(timeBar, 100);
            timeText.setTextSize(50);
            timeText.setText(String.valueOf(time + .0));
        }

        private Runnable timeBar = new Runnable(){

            @Override
            public void run() {
                if (i != 0 && flag) {
                    i -= 100;
                    timesec = i / 1000;
                    timeText.setText(String.valueOf(timesec));
                    count++;
                    if (count == (time / 10)) {
                        Bar.incrementProgressBy(1);
                        count = 0;
                    }
                    timingHandler.postDelayed(this, 100);
                }if(i == 0) {
                    for (int i = 0; i < Buttons.length; i++) {
                        Buttons[i].setEnabled(false);
                    }
//If the timer runs out, displays a toast message and enables the user to start a new game
                    newGameButton.setEnabled(true);
                    Toast.makeText(getBaseContext(), "SORRY, GAME OVER! TRY AGAIN!", Toast.LENGTH_LONG).show();
                    flag = false;
                }
            }
        };

        @Override
        protected Integer doInBackground(Integer... integers) {
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }

    protected void onDestroy() {
        super.onDestroy();

    }
}
