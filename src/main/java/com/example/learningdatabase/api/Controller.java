package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.*;
import com.example.learningdatabase.service.serviceimplement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;
    @Autowired
    private AdminServiceImplement adminServiceImplement;
    @Autowired
    StudentServiceImplement studentServiceImplement;

    public Controller() {}

    @RequestMapping("/")
    public String home(Model model) {
        return "Welcome to web service of group 3 CNPM";
    }


    @GetMapping("/home")
    @ResponseBody
    public String get_getAccountByID() {
        return "home.html";

    }


    @GetMapping("/test/insert")
    public void get_insertUser() {
        User user = new User();
        user.setId(5);
        user.setIsAdmin(false);
        Student student = studentServiceImplement.saveStudent(new Student());
        user.setNumberStudentID(student.getId());
        userServiceImplement.saveUser(new User());


    }
    @DeleteMapping("/delete-account/{id}")
    public void delete_deleteAccountByID(@PathVariable("id") int id) {
        accountServiceImplement.deleteAccountByID(id);
    }

    @GetMapping("/create-account-default")
    public void post_createAccountDefault() {
        Account acc = new Account();
        acc.setUserName("new Account");
        acc.setPassword("password");
        acc.setUserID(0);
        acc.setEmail("email@gmail.com");
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
    }

    @PostMapping("/create-account")
    public void post_createAccount(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        Account acc = new Account();
        acc.setUserName(username);
        acc.setPassword(password);
        acc.setUserID(0);
        acc.setEmail(email);
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
    }

    @GetMapping("/get-all-account")
    @ResponseBody
    public ArrayList<Account> getlistaccount() {
        return accountServiceImplement.getAllListAccount();
    }

//    @GetMapping("/test-find-id-by-username")
//    public void ptest() {
//        List<Account> acc = accountServiceImplement.findIDAccountByUsername("hahah");
//        acc.forEach(a -> System.out.println(a));
//    }
}
