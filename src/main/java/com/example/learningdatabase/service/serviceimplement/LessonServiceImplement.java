package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Lesson;
import com.example.learningdatabase.repository.LessonRepository;
import com.example.learningdatabase.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LessonServiceImplement implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public Lesson saveLesson(Lesson lession) {
        try {
            if (!lessonRepository.existsById(lession.getId())) {
                lessonRepository.save(lession);
                return lession;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateLessonByID(int id, Lesson lession) {

    }

    @Override
    public void deleteLessonByID(int id) {

    }

    @Override
    public boolean exist(int id) {
        if (lessonRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Lesson getLessonByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Lesson> getListLesson(ArrayList<Integer> listID) {
        return null;
    }
}
