package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Exercise;
import com.example.learningdatabase.repository.ExerciseRepository;
import com.example.learningdatabase.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExerciseServiceImplement implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Override
    public Exercise saveExercise(Exercise exercise) {
        try {
            if (!exerciseRepository.existsById(exercise.getId())) {
                exerciseRepository.save(exercise);
                return exercise;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateExerciseByID(int id, Exercise exercise) {

    }

    @Override
    public void deleteExerciseByID(int id) {

    }

    @Override
    public boolean exist(int id) {
        if (exerciseRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Exercise getExerciseByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Exercise> getListExercise(ArrayList<Integer> listID) {
        return null;
    }
}
