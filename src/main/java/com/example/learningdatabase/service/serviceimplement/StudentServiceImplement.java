package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.repository.CourseRepository;
import com.example.learningdatabase.repository.LessonRepository;
import com.example.learningdatabase.repository.StudentRepository;
import com.example.learningdatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Student saveStudent(Student student) {
        try {
            if (!studentRepository.existsById(student.getId())) {
                return studentRepository.save(student);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteStudentByID(int id) {
        try {
            if (exist(id)) {
                studentRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }

    @Override
    public void deleteAll() {
        try {
            studentRepository.deleteAll();
        } catch(Exception e) {
        }
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
    public ArrayList<Integer> getListCourseRegistered(int idStudent) {
        try {
            if (exist(idStudent)) {
                Student student = studentRepository.findById(idStudent).get();
                return student.stringToList(student.getListCourseRegistered());
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Integer> getListLessonLearned(int idStudent) {
        try {
            if (exist(idStudent)) {
                Student student = studentRepository.findById(idStudent).get();
                return student.stringToList(student.getListLessonLearned());
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

//    @Override
//    public ArrayList<Integer> getListLessonLearnedByCourse(int idStudent, int idCourse) {
//        try {
//            if (exist(idStudent)) {
//                Student student = studentRepository.findById(idStudent).get();
//                ArrayList<Integer> listCourseRegistered = getListCourseRegistered(idStudent);
//                if (listCourseRegistered.contains(idCourse)) {
//                    Course course = courseRepository.findById(idCourse).get();
//                    ArrayList<Integer> listLesson = course.stringToList(course.getListLesson());
//                }
//                return student.stringToList(student.)
//            }
//        } catch (Exception e) {
//            return null;
//        }
//    }

    @Override
    public void registerCourse(int idStudent, int idCourse) {
        try {
            if (exist(idStudent) && courseRepository.existsById(idCourse)) {
                Student student = studentRepository.findById(idStudent).get();
                student.setListCourseRegistered(idCourse);
                studentRepository.saveAndFlush(student);
            }
        } catch (Exception e) {}
    }

    @Override
    public void addLessonLearned(int idStudent, int idLesson) {
        try {
            if (exist(idStudent) && lessonRepository.existsById(idLesson)) {
                Student student = studentRepository.findById(idStudent).get();
                student.setListLessonLearned(idLesson);
                studentRepository.saveAndFlush(student);
            }
        } catch (Exception e) {}
    }

    @Override
    public Student getStudentByID(int id) {
        try {
            if (exist(id)) {
                return studentRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
