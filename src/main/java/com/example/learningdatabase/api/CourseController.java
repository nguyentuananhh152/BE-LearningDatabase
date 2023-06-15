package com.example.learningdatabase.api;

import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.service.serviceimplement.CourseServiceImplement;
import com.example.learningdatabase.service.serviceimplement.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller
public class CourseController {

    @Autowired
    private CourseServiceImplement courseServiceImplement;

    @Autowired
    private StudentServiceImplement studentServiceImplement;
    public CourseController() {}


    @GetMapping("/get-course")
    @ResponseBody
    public Course get_getCourseByID(@PathParam("id") int id) {
        try {
            Course course = courseServiceImplement.getCourseByID(id);
            return course;
        } catch (Exception e) {
            return new Course();
        }
    }

    @GetMapping("/get-all-list-course")
    @ResponseBody
    public ArrayList<Course> get_allListCourse() {
        try {
            ArrayList<Course> arr = new ArrayList<>();
            arr = courseServiceImplement.getAllListCourse();
            return arr;
        } catch (Exception e) {
            return new ArrayList<Course>();
        }
    }

    @GetMapping("/my-list-course")
    @ResponseBody
    public ArrayList<Course> get_myList(@PathParam("id") int id) {
        try {
            if (studentServiceImplement.exist(id)) {
                Student student = studentServiceImplement.getStudentByID(id);
//                System.out.println("List integer: " + student.stringToList(student.getListCourseRegistered()));
//                System.out.println("List Course: " + courseServiceImplement.getListCourse(student.stringToList(student.getListCourseRegistered())));
                return courseServiceImplement.getListCourse(student.stringToList(student.getListCourseRegistered()));
            } else {
                return new ArrayList<Course>();
//                return null;
            }
        } catch (Exception e) {
            return new ArrayList<Course>();
        }
    }

}
