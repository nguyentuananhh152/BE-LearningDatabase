package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface StudentService {
    public void saveStudent(Student student);

    public void deleteStudentByID(int id);

    public ArrayList<Integer> getListCourseRegistered();

    public ArrayList<Integer> getListLessionLearned();

    public ArrayList<Integer> getListLessionLearnedByCourse(int idCourse);

    public void registerCourse(int id);

    public void addLessionLearned(int id);

    public Student getStudentByID(int id);
}
