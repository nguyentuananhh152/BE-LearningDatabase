package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.entity.Lesson;
import com.example.learningdatabase.repository.CommentRepository;
import com.example.learningdatabase.repository.CourseRepository;
import com.example.learningdatabase.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        // update name. descripsion
        try {
            if (exist(id)) {
                Course courseUpdate = courseRepository.findById(id).get();
                courseUpdate.setName(course.getName());
                courseUpdate.setDescription(course.getDescription());
                courseRepository.saveAndFlush(courseUpdate);
            }
        } catch (Exception e) {}
    }

    @Override
    public void addLesson(int idLesson, int idCourse) {
        try {
            if (exist(idCourse)) {
                Course course = courseRepository.findById(idCourse).get();
                if (!course.containerLesson(idLesson)) {
                    course.addLesson(idLesson);
                }
            }
        } catch (Exception e) {}
    }

    @Override
    public void removeLesson(int idLesson, int idCourse) {
        try {
            if (exist(idCourse)) {
                Course course = courseRepository.findById(idCourse).get();
                if (course.containerLesson(idLesson)) {
                    course.removeLesson(idLesson);
                }
            }
        } catch (Exception e) {}
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
        try {
            if (exist(id)) {
                return courseRepository.findById(id).get();
            } else {
                return new Course();
            }
        } catch (Exception e) {
            return new Course();
        }
    }

    @Override
    public ArrayList<Course> getAllListCourse() {
        try {
            List<Course> listCourse = courseRepository.findAll();
            ArrayList<Course> arrayListCourse = new ArrayList<>();
            if (!listCourse.isEmpty()) {
                for (Course l : listCourse) {
                    arrayListCourse.add(l);
                }
                return arrayListCourse;
            } else {
                return arrayListCourse;
            }
        } catch (Exception e) {
            return new ArrayList<Course>();
        }
    }

    @Override
    public ArrayList<Course> getListCourse(ArrayList<Integer> listID) {
        try {
            List<Course> listCourse = courseRepository.findAllById(listID);
            ArrayList<Course> arrayListCourse = new ArrayList<>();
            if (!listCourse.isEmpty()) {
                for (Course l : listCourse) {
//                    l.setID(0);
                    arrayListCourse.add(l);
                }
                return arrayListCourse;
            } else {
                return arrayListCourse;
            }
        } catch (Exception e) {
            return new ArrayList<Course>();
        }
    }
}
