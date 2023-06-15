package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CourseService {
    public Course saveCourse(Course course);
    public void updateCourseByID(int id, Course course);

    public void addLesson(int idLesson, int idCourse);

    public void removeLesson(int idLesson, int idCourse);

    public void deleteCourseByID(int id);
    public boolean exist(int id);

    public Course getCourseByID(int id);

    public ArrayList<Course> getAllListCourse();

    public ArrayList<Course> getListCourse(ArrayList<Integer> listID);

}
