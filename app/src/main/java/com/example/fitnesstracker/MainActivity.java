package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void workoutSession(View view) {
        Intent intent = new Intent(MainActivity.this, WorkoutSessionHistoryActivity.class);
        startActivity(intent);
    }

    public void workoutSave(View view) {
        Intent intent = new Intent(MainActivity.this, WorkoutSaveActivity.class);
        startActivity(intent);
    }

}
