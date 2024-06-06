package com.example.fitnesstracker;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstracker.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>{

    ArrayList<Exercise> exerciseArrayList;

    public ExerciseAdapter(ArrayList<Exercise> exerciseArrayList) {
        this.exerciseArrayList = exerciseArrayList;
    }
    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ExerciseViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise currentExercise = exerciseArrayList.get(position);
        holder.binding.recyclerViewBodyPart.setText(currentExercise.getBodyPart());
        holder.binding.recyclerViewExercise.setText(currentExercise.getExercise());
        holder.binding.recyclerViewSet.setText(String.valueOf(currentExercise.getSets()));
        holder.binding.recyclerViewRep.setText(String.valueOf(currentExercise.getReps()));
        holder.binding.recyclerViewWeight.setText(String.valueOf(currentExercise.getWeight()));
        holder.binding.recyclerViewPoints.setText(String.valueOf(currentExercise.getPoints()));
    }


    @Override
    public int getItemCount() {
        return exerciseArrayList.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;
        public ExerciseViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
