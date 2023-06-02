package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Exercise;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ExerciseService {
    public void saveExercise(Exercise exercise);
    public void updateExerciseByID(int id, Exercise exercise);

    public void deleteExerciseByID(int id);

    public Exercise getExerciseByID(int id);

    public ArrayList<Exercise> getListExercise(ArrayList<Integer> listID);
}
