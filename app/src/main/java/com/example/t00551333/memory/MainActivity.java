package com.example.t00551333.memory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mainView;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefsState = this.getSharedPreferences("STATE", MODE_PRIVATE);
        size = prefsState.getInt("SIZE", size);
        Log.d("size", String.valueOf(size));
//Initializing and populating listView
        mainView = (ListView)findViewById(R.id.optionslist);
        List<String> optionsList = new ArrayList<>();
        optionsList.add("Start New Game");
        optionsList.add("Enter Player Name");
        optionsList.add("Show High Scores");
        optionsList.add("Settings");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, optionsList);
        mainView.setAdapter(adapter);
//Assigning onClickListener to the listView to start the desired activity
        mainView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences prefsState = getSharedPreferences("STATE", MODE_PRIVATE);
                size = prefsState.getInt("SIZE", size);
                if (i == 0) {
//Starting the activity with appropriate board size depending on size retrieved from SharedPreferences
                    if(size == 0) {
                        Intent intent = new Intent(MainActivity.this, MemoryActivity4x5.class);
                        startActivity(intent);
                    }else if(size == 1){
                        Intent intent = new Intent(MainActivity.this, MemoryActivity.class);
                        startActivity(intent);
                    }
                }
                else if (i == 1) {
                    Intent intent = new Intent(MainActivity.this, PlayerNameActivity.class);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(MainActivity.this, HighScoresActivity.class);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Intent intent = new Intent(MainActivity.this, GameSettingsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
