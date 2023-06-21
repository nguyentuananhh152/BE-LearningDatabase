package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Account;
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


    @GetMapping("/studentDTO")
    @ResponseBody
    public StudentDTO test() {
        Account testAcc = accountServiceImplement.getAccountByID(5);
        User testUser = userServiceImplement.getUserByID(3);
        Student student = studentServiceImplement.getStudentByID(3);
        return new StudentDTO(testAcc, testUser, student);
    }

    @RequestMapping("/test/insert")
    public void get_insertUser() {
        User user = new User();
        user.setId(5);
        user.setIsAdmin(false);
        Student student = new Student();
        studentServiceImplement.saveStudent(student);
        user.setNumberStudentID(student.getId());
        userServiceImplement.saveUser(user);
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
