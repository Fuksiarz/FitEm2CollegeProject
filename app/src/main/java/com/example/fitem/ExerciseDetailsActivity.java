package com.example.fitem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseDetailsActivity extends AppCompatActivity {
    private Exercise exercise;
    private TextView exerciseNameTextView;
    private TextView repetitionsTextView;
    private TextView setsTextView;
    private TextView countdownTimeTextView;
    private Button startTimerButton;
    private CountDownTimer countDownTimer;


    private TrainingDBHelper trainingDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        // Odczyt danych przekazanych z ExerciseActivity
        this.exercise = (Exercise) getIntent().getSerializableExtra("exercise");
        trainingDBHelper = new TrainingDBHelper(this);
        exerciseNameTextView = findViewById(R.id.exerciseName);
        repetitionsTextView = findViewById(R.id.repetitions);
        setsTextView = findViewById(R.id.sets);
        startTimerButton = findViewById(R.id.startTimerButton);
        countdownTimeTextView = findViewById(R.id.countdownTime);

        exerciseNameTextView.setText(exercise.getName());
        repetitionsTextView.setText(String.valueOf(exercise.getRepetitions()));
        setsTextView.setText(String.valueOf(exercise.getSets()));

        updateExerciseDetails();

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                countDownTimer = new CountDownTimer(exercise.getCountdownTime() * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        startTimerButton.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        startTimerButton.setText("done!");
                    }
                }.start();
            }
        });


        Button editButton = (Button) findViewById(R.id.editExerciseDetailsButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ExerciseDetailsActivity.this);
                builder.setTitle("Edit exercise");

                // Create layout for dialog
                LinearLayout layout = new LinearLayout(ExerciseDetailsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Set up the inputs
                final EditText inputName = new EditText(ExerciseDetailsActivity.this);
                inputName.setInputType(InputType.TYPE_CLASS_TEXT);
                inputName.setText(exercise.getName());
                layout.addView(inputName);

                final EditText inputRepetitions = new EditText(ExerciseDetailsActivity.this);
                inputRepetitions.setInputType(InputType.TYPE_CLASS_NUMBER);
                inputRepetitions.setText(String.valueOf(exercise.getRepetitions()));
                layout.addView(inputRepetitions);

                final EditText inputSets = new EditText(ExerciseDetailsActivity.this);
                inputSets.setInputType(InputType.TYPE_CLASS_NUMBER);
                inputSets.setText(String.valueOf(exercise.getSets()));
                layout.addView(inputSets);

                final EditText inputCountdownTime = new EditText(ExerciseDetailsActivity.this);
                inputCountdownTime.setInputType(InputType.TYPE_CLASS_NUMBER);
                inputCountdownTime.setText(String.valueOf(exercise.getCountdownTime()));
                layout.addView(inputCountdownTime);

                builder.setView(layout);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exercise.setName(inputName.getText().toString());
                        exercise.setRepetitions(Integer.parseInt(inputRepetitions.getText().toString()));
                        exercise.setSets(Integer.parseInt(inputSets.getText().toString()));
                        exercise.setCountdownTime(Integer.parseInt(inputCountdownTime.getText().toString()));

                        trainingDBHelper.updateExercise(exercise);
                        exercise = trainingDBHelper.getExerciseById(exercise.getId());
                        // Update the TextViews to reflect the new exercise details
                        updateExerciseDetails();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }
    private void updateExerciseDetails() {
        exerciseNameTextView.setText(exercise.getName());
        repetitionsTextView.setText(String.valueOf(exercise.getRepetitions()));
        setsTextView.setText(String.valueOf(exercise.getSets()));
        countdownTimeTextView.setText(String.valueOf(exercise.getCountdownTime()));
    }
}