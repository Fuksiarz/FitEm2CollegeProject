package com.example.fitem;

import java.io.Serializable;

public class Exercise implements Serializable {
    private String name;
    private int repetitions;
    private int sets;
    private int countdownTime;
    private int id;

    private int trainingId;

    public int getId() {
        return id;
    }

    public int getTrainingId() { // Getter dla trainingId
        return trainingId;
    }
    public void setTrainingId(int trainingId) { // Setter dla trainingId
        this.trainingId = trainingId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public Exercise(String name, int repetitions, int sets, int countdownTime, int trainingId) {
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
        this.countdownTime = countdownTime;
        this.trainingId = trainingId;
    }

    public Exercise(String name, int repetitions, int sets, int countdownTime) {
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
        this.countdownTime = countdownTime;
        this.trainingId = trainingId;

    }
    public Exercise(String name) {
        this.name = name;
        this.repetitions = 0;  // Ustaw wartości domyślne
        this.sets = 0;
        this.countdownTime = 0;
        this.trainingId = 0;
    }
    public Exercise() {
        this.name ="";
        this.repetitions = 0;  // Ustaw wartości domyślne
        this.sets = 0;
        this.countdownTime = 0;
        this.trainingId = 0;


    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(int countdownTime) {
        this.countdownTime = countdownTime;
    }
}