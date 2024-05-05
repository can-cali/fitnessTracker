package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
            int bodyPartIndex = cursor.getColumnIndex("bodyPart");
            int workoutIndex = cursor.getColumnIndex("workout");
            int setsIndex = cursor.getColumnIndex("sets");
            int repsIndex = cursor.getColumnIndex("reps");
            int weightIndex = cursor.getColumnIndex("weight");
            int dateIndex = cursor.getColumnIndex("date");
            Log.d("MyApp", "id: " + idIndex + " bodyPart: " + bodyPartIndex + " workout: " + workoutIndex + " sets: " + setsIndex + " reps: " + repsIndex + " weight: " + weightIndex + " date: " + dateIndex);

            while(cursor.moveToNext()){
                int id = cursor.getInt(idIndex);
                String bodyPart = cursor.getString(bodyPartIndex);
                String workoutName = cursor.getString(workoutIndex);
                int sets = cursor.getInt(setsIndex);
                int reps = cursor.getInt(repsIndex);
                double weight = cursor.getDouble(weightIndex);
                String date = cursor.getString(dateIndex);
                Workout savedWorkout = new Workout(id, bodyPart, workoutName, sets, reps, weight, date);
                Log.d("MyApp", "My workout is: " + savedWorkout); // to check if the data is being fetched correctly

                workoutArrayList.add(savedWorkout);
            }
            workoutAdapter.notifyDataSetChanged();
            cursor.close();


        } catch(Exception e){
            e.printStackTrace();
        }

        }
    }
