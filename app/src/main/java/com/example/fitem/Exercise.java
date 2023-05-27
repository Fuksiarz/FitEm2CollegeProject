package com.example.fitem;

import java.io.Serializable;

public class Exercise implements Serializable {
    private String name;
    private int repetitions;
    private int sets;
    private int countdownTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public Exercise(String name, int repetitions, int sets, int countdownTime) {
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
        this.countdownTime = countdownTime;
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