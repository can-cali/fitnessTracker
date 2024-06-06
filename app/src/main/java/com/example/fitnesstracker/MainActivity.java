package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fitnesstracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void exerciseSession(View view) {
        Intent intent = new Intent(MainActivity.this, ExerciseSessionHistoryActivity.class);
        startActivity(intent);
    }

    public void exerciseSave(View view) {
        Intent intent = new Intent(MainActivity.this, ExerciseSaveActivity.class);
        startActivity(intent);
    }

}
