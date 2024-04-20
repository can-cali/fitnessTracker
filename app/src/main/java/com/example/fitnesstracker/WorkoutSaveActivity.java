package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WorkoutSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_save);

        Spinner spinnerBodyParts = findViewById(R.id.spinnerBodyParts);
        String[] parentItems = new String[]{"Chest", "Back", "Arms", "Shoulder", "Legs", "Core"};
        ArrayAdapter<String> parentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, parentItems);
        spinnerBodyParts.setAdapter(parentAdapter);

        spinnerBodyParts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                if (item != null) {
                    String selectedItem = item.toString();

                    Spinner spinnerWorkouts = findViewById(R.id.spinnerWorkouts);
                    String[] childItems;
                    switch (selectedItem) {
                        case "Chest":
                            childItems = new String[]{"Bench Press", "Bench Press (Dumbbell)","Incline Bench Press","Incline Bench Press (Dumbbell)","Butterfly Machine","Chest Press"};
                            break;
                        case "Back":
                            childItems = new String[]{"Lateral Pulldown", "Row Machine", "Reversed Arm Barbell Row", "Close Grip Pulldown", "Pullup Machine"};
                            break;
                        case "Arms":
                            childItems = new String[]{"Dumbbell Biceps Curl", "Z-Bar Biceps Curl", "Biceps Rope Machine", "Triceps Pulldown Rope Machine", "Triceps Machine"};
                            break;
                        case "Shoulder":
                            childItems = new String[]{"Shoulder Press", "Shoulder Press (Dumbbell)", "Lateral Raise", "Lateral Raise (Dumbbell)", "Front Raise"};
                            break;
                        case "Legs":
                            childItems = new String[]{"Leg Press", "Squat"};
                            break;
                        case "Core":
                            childItems = new String[]{"Abdominal Machine"};
                            break;
                        default:
                            childItems = new String[]{"NONE"};
                    }
                    ArrayAdapter<String> childAdapter = new ArrayAdapter<>(WorkoutSaveActivity.this,android.R.layout.simple_spinner_dropdown_item,childItems);
                    spinnerWorkouts.setAdapter(childAdapter);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}