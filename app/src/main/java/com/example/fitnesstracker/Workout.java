package com.example.fitnesstracker;
import java.util.ArrayList;

public class Workout extends Exercise{
    private ArrayList<Exercise> exercises;

    public Workout(){
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    public ArrayList<Exercise> getExercises(){
        return exercises;
    }
}
