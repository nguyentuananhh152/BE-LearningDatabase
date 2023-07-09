package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface LessonService {
    public Lesson saveLesson(Lesson lession);

    public void updateLessonByID(int id, Lesson lesson);

    public void deleteLessonByID(int id);
    public boolean exist(int id);

    public Lesson getLessonByID(int id);

    public ArrayList<Lesson> getListLesson(ArrayList<Integer> listID);

    public ArrayList<Lesson> getAllLesson();
}
