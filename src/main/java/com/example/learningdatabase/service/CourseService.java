package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CourseService {
    public void saveCourse(Course course);
    public void updateCourseByID(int id, Course course);

    public void deleteCourseByID(int id);

    public Course getCourseByID(int id);

    public ArrayList<Course> getListCourse(ArrayList<Integer> listID);

}
