package com.example.fitnesstracker;

public class Exercise {
    private String bodyPart;
    private String exercise;
    private int sets;
    private int reps;
    private double weight;
    private String date;
    private double points;

    public Exercise(){

    }

    public Exercise(String bodyPart, String exercise, int sets, int reps, double weight, String date) {
        this.bodyPart = bodyPart;
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                ", bodyPart='" + bodyPart + '\'' +
                ", exerciseName='" + exercise + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", date='" + date + '\'' +
                '}';
    }

    public double getPoints() {
        points = reps * (1+(0.333 * reps)) * sets; // formula to calculate exercise points
        return points;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getExercise() {
        return exercise;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }

    public String getDate() { return date; }

    public void setBodyPart() {
        this.bodyPart = bodyPart;
    }

    public void setExercise() {
        this.exercise = exercise;
    }

    public void setSets() {
        this.sets = sets;
    }

    public void setReps() {
        this.reps = reps;
    }

    public void setWeight() {
        this.weight = weight;
    }

    public void setDate() {
        this.date = date;
    }
}

