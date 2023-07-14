package com.example.learningdatabase.api;

import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.service.serviceimplement.CourseServiceImplement;
import com.example.learningdatabase.service.serviceimplement.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseServiceImplement courseServiceImplement;

    @Autowired
    private StudentServiceImplement studentServiceImplement;
    public CourseController() {}


    @GetMapping("/get-course")
    @ResponseBody
    public Course get_getCourseByID(@PathParam("id") int id) {
        System.out.println("Get course, id course = " + id);
        Course course = courseServiceImplement.getCourseByID(id);
        return course;
    }

    @GetMapping("/get-all-list-course")
    @ResponseBody
    public ArrayList<Course> get_allListCourse() {
        System.out.println("Get all course");
        ArrayList<Course> arr = new ArrayList<>();
        arr = courseServiceImplement.getAllListCourse();
        return arr;
    }

    @DeleteMapping("/delete-course")
//    @ResponseBody
    public String delete_courseByID(@PathParam("id") int id) {
        System.out.println("Delete course by id = " + id);
        courseServiceImplement.deleteCourseByID(id);
        return "Success!";
    }

    @GetMapping("/my-list-course")
    @ResponseBody
    public ArrayList<Course> get_myList(@PathParam("id") int id) {
        System.out.println("Get my list course, id student = " + id);
        if (studentServiceImplement.exist(id)) {
            Student student = studentServiceImplement.getStudentByID(id);
//                System.out.println("List integer: " + student.stringToList(student.getListCourseRegistered()));
//                System.out.println("List Course: " + courseServiceImplement.getListCourse(student.stringToList(student.getListCourseRegistered())));
            return courseServiceImplement.getListCourse(student.stringToList(student.getListCourseRegistered()));
        } else {
            return new ArrayList<Course>();
//                return null;
        }
    }

}
