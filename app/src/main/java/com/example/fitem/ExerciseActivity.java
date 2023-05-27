package com.example.fitem;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fitem.databinding.ActivityExerciseBinding;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {
    private List<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // Odczyt danych przekazanych z MainActivity
        Training training = (Training) getIntent().getSerializableExtra("training");
        this.exercises = training.getExercises();

        ListView listView = (ListView) findViewById(R.id.exerciseListView);
        ExerciseAdapter adapter = new ExerciseAdapter(this, exercises);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExerciseActivity.this, ExerciseDetailsActivity.class);
                intent.putExtra("exercise", exercises.get(position));
                startActivity(intent);
            }
        });

        Button editButton = (Button) findViewById(R.id.editExerciseButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kod do edycji listy ćwiczeń
            }
        });
    }
}