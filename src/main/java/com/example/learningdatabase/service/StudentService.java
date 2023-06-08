package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface StudentService {
    public Student saveStudent(Student student);

    public void deleteStudentByID(int id);
    public boolean exist(int id);

    public ArrayList<Integer> getListCourseRegistered();

    public ArrayList<Integer> getListLessonLearned();

    public ArrayList<Integer> getListLessonLearnedByCourse(int idCourse);

    public void registerCourse(int id);

    public void addLessonLearned(int id);

    public Student getStudentByID(int id);
}
