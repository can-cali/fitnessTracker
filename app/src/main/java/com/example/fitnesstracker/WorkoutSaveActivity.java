package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class WorkoutSaveActivity extends AppCompatActivity {
    SQLiteDatabase workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_save);

        try {

            workout = this.openOrCreateDatabase("Workout", MODE_PRIVATE, null);
            workout.execSQL("CREATE TABLE IF NOT EXISTS workout (id INTEGER PRIMARY KEY AUTOINCREMENT, bodyPart VARCHAR, workout VARCHAR, sets INTEGER, reps INTEGER, weight REAL, date VARCHAR);");


            Spinner spinnerBodyParts = findViewById(R.id.spinnerBodyParts);
            Spinner spinnerWorkouts = findViewById(R.id.spinnerWorkouts);
            Button saveButton = findViewById(R.id.buttonSave);
            EditText weight = findViewById(R.id.inputWeight);
            EditText set = findViewById(R.id.inputSet);
            EditText rep = findViewById(R.id.inputRep);
            EditText date = findViewById(R.id.inputDate);

            String[] parentItems = new String[]{"Chest", "Back", "Arms", "Shoulder", "Legs", "Core"};
            ArrayAdapter<String> parentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, parentItems);
            spinnerBodyParts.setAdapter(parentAdapter);

            spinnerBodyParts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Object item = parent.getItemAtPosition(position);
                    if (item != null) {
                        String selectedItem = item.toString();


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




            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sqlString = "INSERT INTO workout (bodyPart, workout, sets, reps, weight, date) VALUES ('?', ?, ?, ?, ?, ?);";
                    SQLiteStatement sqLiteStatement = workout.compileStatement(sqlString);
                    sqLiteStatement.bindString(1, spinnerBodyParts.getSelectedItem().toString());
                    sqLiteStatement.bindString(2, spinnerWorkouts.getSelectedItem().toString());
                    sqLiteStatement.bindLong(3, Long.parseLong(set.getText().toString()));
                    sqLiteStatement.bindLong(4, Long.parseLong(rep.getText().toString()));
                    sqLiteStatement.bindDouble(5, Double.parseDouble(weight.getText().toString()));
                    sqLiteStatement.bindLong(6, Long.parseLong(date.getText().toString()));

                    sqLiteStatement.execute();
                }
            });

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}