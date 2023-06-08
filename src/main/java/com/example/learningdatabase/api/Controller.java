package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.AdminDTO;
import com.example.learningdatabase.entityDTO.StudentDTO;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import com.example.learningdatabase.service.serviceimplement.AdminServiceImplement;
import com.example.learningdatabase.service.serviceimplement.StudentServiceImplement;
import com.example.learningdatabase.service.serviceimplement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        return "home.html";
    }


    @GetMapping("/home")
    @ResponseBody
    public String get_getAccountByID() {
        return "Welcome";
    }


    @GetMapping("/admin/login")
    @ResponseBody
    public AdminDTO get_loginAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
        return accountServiceImplement.loginAdmin(username, password);
    }

    @GetMapping("/user/login")
    @ResponseBody
    public StudentDTO get_loginStudent(@PathVariable("username") String username, @PathVariable("password") String password) {
        return accountServiceImplement.loginStudent(username, password);
    }

    @GetMapping("/test/insert")
    public void get_insertUser() {
        User user = new User();
        user.setId(5);
        user.setNumberStudentID(1);
        userServiceImplement.saveUser(new User());

        Student student = new Student();
        student.setId(1);
        studentServiceImplement.saveStudent(student);

    }
    @DeleteMapping("/delete-account/{id}")
    public void delete_deleteAccountByID(@PathVariable("id") int id) {
        accountServiceImplement.deleteAccountByID(id);
    }

    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/create-account-default")
    public void post_createAccountDefault() {
        Account acc = new Account();
        acc.setUserName("new Account");
        acc.setPassword("password");
        acc.setUserID(0);
        acc.setEmail("email@gmail.com");
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
//        accountRepository.save(acc);
    }

    @PostMapping("/create-account/username={username}/password={password}/email={email}")
    public void post_createAccount(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("email") String email) {
        Account acc = new Account();
        acc.setUserName(username);
        acc.setPassword(password);
        acc.setUserID(0);
        acc.setEmail(email);
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
//        accountRepository.save(acc);
    }
}
