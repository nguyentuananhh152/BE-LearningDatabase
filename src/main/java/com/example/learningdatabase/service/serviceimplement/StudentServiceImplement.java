package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.repository.StudentRepository;
import com.example.learningdatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        try {
            if (!studentRepository.existsById(student.getId())) {
                studentRepository.save(student);
                return student;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteStudentByID(int id) {

    }

    @Override
    public boolean exist(int id) {
        if (studentRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Integer> getListCourseRegistered() {
        return null;
    }

    @Override
    public ArrayList<Integer> getListLessonLearned() {
        return null;
    }

    @Override
    public ArrayList<Integer> getListLessonLearnedByCourse(int idCourse) {
        return null;
    }

    @Override
    public void registerCourse(int id) {

    }

    @Override
    public void addLessonLearned(int id) {

    }

    @Override
    public Student getStudentByID(int id) {
        return null;
    }
}
