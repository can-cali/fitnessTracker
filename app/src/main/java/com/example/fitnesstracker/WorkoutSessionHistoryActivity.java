package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.fitnesstracker.databinding.ActivityWorkoutSessionHistoryBinding;

import java.util.ArrayList;

public class WorkoutSessionHistoryActivity extends AppCompatActivity {
    private ActivityWorkoutSessionHistoryBinding binding;
    ArrayList<Workout> workoutArrayList;
    WorkoutAdapter workoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkoutSessionHistoryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        workoutArrayList = new ArrayList<>();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        workoutAdapter = new WorkoutAdapter(workoutArrayList);
        binding.recyclerView.setAdapter(workoutAdapter);

        getData();
    }

    private void getData(){
        try{
            SQLiteDatabase workout = this.openOrCreateDatabase("Workout", MODE_PRIVATE, null);
            Cursor cursor = workout.rawQuery("SELECT * FROM workout", null);
            int idIndex = cursor.getColumnIndex("id");

            while(cursor.moveToNext()){
                int id = cursor.getInt(idIndex);
                String bodyPart = cursor.getString(cursor.getColumnIndexOrThrow("bodyPart"));
                String workoutName = cursor.getString(cursor.getColumnIndexOrThrow("workout"));
                int sets = cursor.getInt(cursor.getColumnIndexOrThrow("sets"));
                int reps = cursor.getInt(cursor.getColumnIndexOrThrow("reps"));
                double weight = cursor.getDouble(cursor.getColumnIndexOrThrow("weight"));
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                Workout savedWorkout = new Workout(id, bodyPart, workoutName, sets, reps, weight, date);

                workoutArrayList.add(savedWorkout);
            }
            workoutAdapter.notifyDataSetChanged();
            cursor.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        }
    }
