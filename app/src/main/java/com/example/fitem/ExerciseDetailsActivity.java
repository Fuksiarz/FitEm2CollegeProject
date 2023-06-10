package com.example.fitem;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fitem.databinding.ActivityExerciseDetailsBinding;

public class ExerciseDetailsActivity extends AppCompatActivity {
    private Exercise exercise;
    private TextView exerciseNameTextView;
    private TextView repetitionsTextView;
    private TextView setsTextView;
    private Button startTimerButton;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        // Odczyt danych przekazanych z ExerciseActivity
        this.exercise = (Exercise) getIntent().getSerializableExtra("exercise");

        TextView exerciseName = (TextView) findViewById(R.id.exerciseName);
        TextView repetitions = (TextView) findViewById(R.id.repetitions);
        TextView sets = (TextView) findViewById(R.id.sets);
        TextView countdownTime = (TextView) findViewById(R.id.countdownTime);

        exerciseName.setText(exercise.getName());
        repetitions.setText(String.valueOf(exercise.getRepetitions()));
        sets.setText(String.valueOf(exercise.getSets()));
        countdownTime.setText(String.valueOf(exercise.getCountdownTime()));

        Button editButton = (Button) findViewById(R.id.editExerciseDetailsButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kod do edycji szczegółów ćwiczenia
            }
        });
    }
}