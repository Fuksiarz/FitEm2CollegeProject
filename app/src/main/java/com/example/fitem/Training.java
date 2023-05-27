package com.example.fitem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Training implements Serializable {
    private String name;
    private List<Exercise> exercises;

    private int id;

    public Training(String name, List<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }
    public Training(String name) {
        this.name = name;
        this.exercises = new ArrayList<>(); // Możemy inicjalizować listę ćwiczeń jako pustą listę
    }
    public Training() {
        this.name = name;
        this.exercises = new ArrayList<>(); // Możemy inicjalizować listę ćwiczeń jako pustą listę
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}