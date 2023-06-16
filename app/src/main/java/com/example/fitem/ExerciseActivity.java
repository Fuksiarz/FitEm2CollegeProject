package com.example.fitem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {
    private List<Exercise> exercises;
    private TrainingDBHelper dbHelper;
    private Training training;
    private ExerciseAdapter adapter;
    ActivityResultLauncher<Intent> exerciseDetailLauncher;
    private int currentTrainingId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // Odczyt danych przekazanych z MainActivity
        Training training = (Training) getIntent().getSerializableExtra("training");
        currentTrainingId = training.getId();
        exercises = initializeExercises(currentTrainingId);

        this.dbHelper = new TrainingDBHelper(this);
        exerciseDetailLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Odśwież listę ćwiczeń po zakończeniu ExerciseDetailsActivity
                        exercises = initializeExercises(currentTrainingId);
                        adapter.setExercises(exercises);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        ListView listView = (ListView) findViewById(R.id.exerciseListView);
        adapter = new ExerciseAdapter(this, exercises,dbHelper);
        listView.setAdapter(adapter);

        Button addExerciseButton = findViewById(R.id.addExerciseButton);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExerciseActivity.this, ExerciseDetailsActivity.class);
                intent.putExtra("EXERCISE_ID", exercises.get(position).getId());
                exerciseDetailLauncher.launch(intent);
            }
        });

        Button editButton = (Button) findViewById(R.id.editExerciseButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setEditMode(!adapter.isInEditMode());
            }
        });
        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ExerciseActivity.this);
                builder.setTitle("Dodaj cwiczenie");

                // Ustaw EditText do wprowadzenia nazwy ćwiczenia
                final EditText input = new EditText(ExerciseActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // Ustaw przyciski do obsługi wprowadzonej nazwy ćwiczenia
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String exerciseName = input.getText().toString();

                        // Tworzenie nowego obiektu Exercise
                        Exercise exercise = new Exercise(exerciseName, 0, 0, 0, currentTrainingId);

                        // Dodaj ćwiczenie do bazy danych
                        dbHelper.addExerciseToTraining(exercise,training);

                        // Dodaj ćwiczenie do listy i aktualizuj adapter
                        List<Exercise> newExerciseList = dbHelper.getAllExercisesForTraining(currentTrainingId);
                        adapter.setExercises(newExerciseList);
                        adapter.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        // Odśwież adapter tutaj
        adapter.notifyDataSetChanged();
    }

    private List<Exercise> initializeExercises(int trainingId) {
        TrainingDBHelper dbHelper = new TrainingDBHelper(this);
        List<Exercise> exercises;
        try {
            exercises = dbHelper.getAllExercisesForTraining(trainingId);
        } finally {
            dbHelper.close();
        }
        return exercises;
    }
}