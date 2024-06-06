package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fitnesstracker.databinding.ActivityExerciseSessionHistoryBinding;

import java.util.ArrayList;

public class ExerciseSessionHistoryActivity extends AppCompatActivity {
    private ActivityExerciseSessionHistoryBinding binding;
    ArrayList<Exercise> exerciseArrayList;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExerciseSessionHistoryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        exerciseArrayList = new ArrayList<>();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        exerciseAdapter = new ExerciseAdapter(exerciseArrayList);
        binding.recyclerView.setAdapter(exerciseAdapter);

        getData();
    }

    private void getData(){
        try{
            SQLiteDatabase exercise = this.openOrCreateDatabase("Exercise", MODE_PRIVATE, null);
            Cursor cursor = exercise.rawQuery("SELECT * FROM workout", null);
            int idIndex = cursor.getColumnIndex("id");
            int bodyPartIndex = cursor.getColumnIndex("bodyPart");
            int exerciseIndex = cursor.getColumnIndex("exercise");
            int setsIndex = cursor.getColumnIndex("sets");
            int repsIndex = cursor.getColumnIndex("reps");
            int weightIndex = cursor.getColumnIndex("weight");
            int dateIndex = cursor.getColumnIndex("date");
            Log.d("MyApp", "id: " + idIndex + " bodyPart: " + bodyPartIndex + " exercise: " + exerciseIndex + " sets: " + setsIndex + " reps: " + repsIndex + " weight: " + weightIndex + " date: " + dateIndex);

            while(cursor.moveToNext()){
                int id = cursor.getInt(idIndex);
                String bodyPart = cursor.getString(bodyPartIndex);
                String exerciseName = cursor.getString(exerciseIndex);
                int sets = cursor.getInt(setsIndex);
                int reps = cursor.getInt(repsIndex);
                double weight = cursor.getDouble(weightIndex);
                String date = cursor.getString(dateIndex);
                Exercise savedExercise = new Exercise(bodyPart, exerciseName, sets, reps, weight, date);
                Log.d("MyApp", "My workout is: " + savedExercise); // to check if the data is being fetched correctly

                exerciseArrayList.add(savedExercise);
            }
            exerciseAdapter.notifyDataSetChanged();
            cursor.close();


        } catch(Exception e){
            e.printStackTrace();
        }

        }
    }
