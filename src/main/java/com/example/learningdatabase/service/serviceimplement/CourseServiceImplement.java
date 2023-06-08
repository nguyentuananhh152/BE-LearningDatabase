package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.repository.CommentRepository;
import com.example.learningdatabase.repository.CourseRepository;
import com.example.learningdatabase.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseServiceImplement implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course saveCourse(Course course) {
        try {
            if (!courseRepository.existsById(course.getId())) {
                courseRepository.save(course);
                return course;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateCourseByID(int id, Course course) {

    }

    @Override
    public void deleteCourseByID(int id) {

    }

    @Override
    public boolean exist(int id) {
        if (courseRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Course getCourseByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Course> getListCourse(ArrayList<Integer> listID) {
        return null;
    }
}
