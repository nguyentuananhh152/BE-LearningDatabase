package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface LessonService {
    public void saveLession(Lesson lession);

    public void updateLessionByID(int id, Lesson lession);

    public void deleteLessionByID(int id);

    public Lesson getLessionByID(int id);

    public ArrayList<Lesson> getListLession(ArrayList<Integer> listID);
}
