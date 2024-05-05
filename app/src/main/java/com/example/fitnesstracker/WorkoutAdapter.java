package com.example.fitnesstracker;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstracker.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>{

    ArrayList<Workout> workoutArrayList;

    public WorkoutAdapter(ArrayList<Workout> workoutArrayList) {
        this.workoutArrayList = workoutArrayList;
    }
    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WorkoutViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout currentWorkout = workoutArrayList.get(position);
        holder.binding.recyclerViewBodyPart.setText(currentWorkout.getBodyPart());
        holder.binding.recyclerViewWorkout.setText(currentWorkout.getWorkout());
        holder.binding.recyclerViewSet.setText(String.valueOf(currentWorkout.getSets()));
        holder.binding.recyclerViewRep.setText(String.valueOf(currentWorkout.getReps()));
        holder.binding.recyclerViewWeight.setText(String.valueOf(currentWorkout.getWeight()));
        holder.binding.recyclerViewPoints.setText(String.valueOf(currentWorkout.getPoints()));
    }


    @Override
    public int getItemCount() {
        return workoutArrayList.size();
    }

    public class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;
        public WorkoutViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
