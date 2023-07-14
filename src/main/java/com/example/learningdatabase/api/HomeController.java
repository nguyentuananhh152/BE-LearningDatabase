package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Course;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.StudentDTO;
import com.example.learningdatabase.service.serviceimplement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
@CrossOrigin
public class HomeController {

    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;
    @Autowired
    private AdminServiceImplement adminServiceImplement;
    @Autowired
    StudentServiceImplement studentServiceImplement;

    @Autowired
    private CourseServiceImplement courseServiceImplement;

    public HomeController() {}

    @RequestMapping("/")
    public String home(Model model,
                       HttpServletRequest request,
                       HttpServletResponse response) {
        return "home.html";
    }


//    @GetMapping("/")
//    public String get_getAccountByID() {
//        return "home.html";
//    }



    @DeleteMapping("/delete-account/{id}")
    public void delete_deleteAccountByID(@PathVariable("id") int id) {
        System.out.println("Delete account, id account = " + id);
        accountServiceImplement.deleteAccountByID(id);
    }



    @GetMapping("/get-all-account")
    @ResponseBody
    public ArrayList<Account> getlistaccount() {
        System.out.println("Get all account");
        return accountServiceImplement.getAllListAccount();
    }

//    @GetMapping("/test-find-id-by-username")
//    public void ptest() {
//        List<Account> acc = accountServiceImplement.findIDAccountByUsername("hahah");
//        acc.forEach(a -> System.out.println(a));
//    }
    @GetMapping("/search")
    @ResponseBody
    public ArrayList<Course> get_search(@RequestParam("keyword") String keyword) {
        System.out.println("Search, keyword = " + keyword);
        ArrayList<Course> arr = new ArrayList<>();
        courseServiceImplement.getAllListCourse().forEach(course -> {
            if (course.getName().contains(keyword)) {
                arr.add(course);
            }
        });
        return arr;
    }
}
