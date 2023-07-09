package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Lesson;
import com.example.learningdatabase.repository.LessonRepository;
import com.example.learningdatabase.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void updateLessonByID(int id, Lesson lesson) {
        try {
            if (exist(id)) {
                Lesson lessonUpdate = lessonRepository.findById(id).get();
                lessonUpdate.setContent(lesson.getContent());
                lessonUpdate.setName(lesson.getName());
                lessonUpdate.setListComment(lesson.getListComment());
                lessonUpdate.setListExercise(lesson.getListExercise());
                lessonRepository.saveAndFlush(lessonUpdate);
            }
        } catch (Exception e) {}
    }

    @Override
    public void deleteLessonByID(int id) {
        try {
            if (exist(id)) {
                lessonRepository.deleteById(id);
            }
        } catch (Exception e) {}
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
        try {
            if (exist(id)) {
                return lessonRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Lesson> getListLesson(ArrayList<Integer> listID) {
        try {
            List<Lesson> lessonList = lessonRepository.findAllById(listID);
            if (!lessonList.isEmpty()) {
                ArrayList<Lesson> lessonArrayList= new ArrayList<>();
                for (Lesson l : lessonList) {
                    lessonArrayList.add(l);
                }
                return lessonArrayList;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Lesson> getAllLesson() {
        try {
            List<Lesson> lessonList = lessonRepository.findAll();
            if (!lessonList.isEmpty()) {
                ArrayList<Lesson> lessonArrayList= new ArrayList<>();
                for (Lesson l : lessonList) {
                    lessonArrayList.add(l);
                }
                return lessonArrayList;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
