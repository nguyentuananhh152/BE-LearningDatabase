package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface StudentService {
    public Student saveStudent(Student student);

    public void deleteStudentByID(int id);
    public void deleteAll();
    public boolean exist(int id);

    public ArrayList<Integer> getListCourseRegistered(int idStudent);

    public ArrayList<Integer> getListLessonLearned(int idStudent);

//    public ArrayList<Integer> getListLessonLearnedByCourse(int idStudent, int idCourse);

    public void registerCourse(int idStudent, int idCourse);

    public void addLessonLearned(int idStudent,int idLesson);

    public Student getStudentByID(int id);
}
