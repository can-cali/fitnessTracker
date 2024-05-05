package com.example.fitnesstracker;

public class Workout {
    int id;
    String bodyPart;
    String workout;
    int sets;
    int reps;
    double weight;
    String date;

    public Workout(int id, String bodyPart, String workout, int sets, int reps, double weight, String date) {
        this.id = id;
        this.bodyPart = bodyPart;
        this.workout = workout;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", bodyPart='" + bodyPart + '\'' +
                ", workoutName='" + workout + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getWorkout() {
        return workout;
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

    public String getDate() {
        return date;
    }
}
