package com.example.fitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TrainingAdapter extends ArrayAdapter<Training> {

    private Context context;
    private List<Training> trainings;
    private boolean isInEditMode = false; // Flagę, która określa, czy lista jest w trybie edycji

    public TrainingAdapter(Context context, List<Training> trainings) {
        super(context, 0, trainings);
        this.context = context;
        this.trainings = trainings;
    }
    public void setEditMode(boolean isInEditMode) {
        this.isInEditMode = isInEditMode;
        this.notifyDataSetChanged(); // Odświeża widok, gdy tryb edycji zmienia się
    }
    public boolean isInEditMode() {
        return this.isInEditMode;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.training_item, parent, false);

        TextView trainingName = (TextView) rowView.findViewById(R.id.trainingName);
        trainingName.setText(trainings.get(position).getName());

        Button deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
        deleteButton.setVisibility(isInEditMode ? View.VISIBLE : View.GONE); // Pokazuje przycisk Usuń tylko w trybie edycji
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainings.remove(position); // Usuwa trening
                notifyDataSetChanged(); // Odświeża widok
            }
        });

        return rowView;
    }
}