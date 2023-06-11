package com.example.fitem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {


    private Context context;
    private List<Exercise> exercises;
    private TrainingDBHelper dbHelper;
    private boolean isInEditMode = false; // Flag to indicate if the list is in edit mode

    public ExerciseAdapter(Context context, List<Exercise> exercises, TrainingDBHelper dbHelper) {
        super(context, 0, exercises);
        this.context = context;
        this.exercises = exercises;
        this.dbHelper = dbHelper;
    }


    public void setEditMode(boolean isInEditMode) {
        this.isInEditMode = isInEditMode;
        this.notifyDataSetChanged(); // Refreshes the view when the edit mode changes
    }

    public boolean isInEditMode() {
        return this.isInEditMode;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.exercise_item, parent, false);

        TextView exerciseName = (TextView) rowView.findViewById(R.id.exerciseName);
        exerciseName.setText(exercises.get(position).getName());

        Button deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
        deleteButton.setVisibility(isInEditMode ? View.VISIBLE : View.GONE); // Shows the Delete button only in edit mode
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exercise exerciseToRemove = exercises.get(position);
                Log.d("ExerciseAdapter", "Usuwanie Ćwiczenia o id: " +  exerciseToRemove.getId() );
                exercises.remove(position); // Remove exercise

                dbHelper.deleteExercise(exerciseToRemove);
                notifyDataSetChanged(); // Refreshes the view
            }
        });

        return rowView;
    }

    public void setExercises(List<Exercise> exercises) {
        clear();
        addAll(exercises);
        notifyDataSetChanged();
    }

}