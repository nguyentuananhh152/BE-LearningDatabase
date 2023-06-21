package com.example.learningdatabase.api;

import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.entity.Lesson;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.service.serviceimplement.CourseServiceImplement;
import com.example.learningdatabase.service.serviceimplement.LessonServiceImplement;
import com.example.learningdatabase.service.serviceimplement.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller
@CrossOrigin
public class LessonController {
    @Autowired
    private LessonServiceImplement lessonServiceImplement;

    @Autowired
    private StudentServiceImplement studentServiceImplement;

    @Autowired
    private CourseServiceImplement courseServiceImplement;

    public LessonController() {}


    @GetMapping("/get-lesson")
    @ResponseBody
    public Lesson get_lessonByID(@PathParam("id") int id) {
        try {
            if (lessonServiceImplement.exist(id)) {
                return lessonServiceImplement.getLessonByID(id);
            } else {
                return new Lesson();
            }
        } catch (Exception e) {
            return new Lesson();
        }
    }

    @GetMapping("/get-list-lesson")
    @ResponseBody
    public ArrayList<Lesson> get_listLessonByIDCourse(@PathParam("id") int id) {
        try {
            if (courseServiceImplement.exist(id)) {
                Course course = courseServiceImplement.getCourseByID(id);
                return lessonServiceImplement.getListLesson(course.stringToList(course.getListLesson()));
            } else {
                return new ArrayList<Lesson>();
            }
        } catch (Exception e) {
            return new ArrayList<Lesson>();
        }
    }


    @GetMapping("/my-list-lesson")
    @ResponseBody
    public ArrayList<Lesson> get_myListLesson(@PathParam("id") int id) {
        try {
            if (studentServiceImplement.exist(id)) {
                Student student = studentServiceImplement.getStudentByID(id);
                return lessonServiceImplement.getListLesson(student.stringToList(student.getListLessonLearned()));
            } else {
                return new ArrayList<Lesson>();
            }
        } catch (Exception e) {
            return new ArrayList<Lesson>();
        }
    }

//    @GetMapping("/add-lesson")
//    @ResponseBody


}
