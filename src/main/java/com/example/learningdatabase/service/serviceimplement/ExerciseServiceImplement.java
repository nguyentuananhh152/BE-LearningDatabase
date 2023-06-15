package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Exercise;
import com.example.learningdatabase.repository.ExerciseRepository;
import com.example.learningdatabase.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        try {
            if (exist(id)) {
                Exercise exUpdate = exerciseRepository.findById(id).get();
                exUpdate.setName(exercise.getName());
                exUpdate.setContent(exercise.getContent());
                exUpdate.setAnswer(exercise.getAnswer());
                exerciseRepository.saveAndFlush(exUpdate);
            }
        } catch (Exception e) {}
    }

    @Override
    public void deleteExerciseByID(int id) {
        try {
            if (exist(id)) {
                exerciseRepository.deleteById(id);
            }
        } catch (Exception e) {}
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
        try {
            if (exist(id)) {
                return exerciseRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Exercise> getListExercise(ArrayList<Integer> listID) {
        try {
            List<Exercise> exerciseList = exerciseRepository.findAllById(listID);
            if (!exerciseList.isEmpty()) {
                ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
                for (Exercise ex : exerciseList) {
                    exerciseArrayList.add(ex);
                }
                return exerciseArrayList;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
