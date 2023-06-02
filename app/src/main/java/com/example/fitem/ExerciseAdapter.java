package com.example.fitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {
    public ExerciseAdapter(Context context, List<Exercise> exercises) {
        super(context, 0, exercises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Exercise exercise = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_item, parent, false);
        }

        TextView exerciseName = (TextView) convertView.findViewById(R.id.exerciseName);
        exerciseName.setText(exercise.getName());

        return convertView;
    }

    public void setExercises(List<Exercise> exercises) {
        clear();
        addAll(exercises);
        notifyDataSetChanged();
    }
}