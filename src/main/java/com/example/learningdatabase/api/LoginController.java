package com.example.learningdatabase.api;


import com.example.learningdatabase.LearningDatabaseApplication;
import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.AdminDTO;
import com.example.learningdatabase.entityDTO.StudentDTO;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.repository.UserRepository;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import com.example.learningdatabase.service.serviceimplement.AdminServiceImplement;
import com.example.learningdatabase.service.serviceimplement.StudentServiceImplement;
import com.example.learningdatabase.service.serviceimplement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Controller
@CrossOrigin
//@SessionAttributes("studentDTO")
public class LoginController {
//    @ModelAttribute("studentDTO")
//    public StudentDTO studentDTO() {
//        return new StudentDTO();
//    }

    public void checkDatabase() {

    }
    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;

    @Autowired
    private StudentServiceImplement studentServiceImplement;

    @Autowired
    private AdminServiceImplement adminServiceImplement;

    private ArrayList<Account> accountArrayList;

    private int numberID = 0;



    public void checkData() throws InterruptedException {
        accountArrayList = accountServiceImplement.getAllListAccount();
        if (accountArrayList == null) {
            System.out.println("Array is empty. Restarting server");
            for (int i = 3; i < 1; i--) {
                System.out.println("Server will restart after: " + i + "s");
                TimeUnit.SECONDS.sleep(1);
            }
            LearningDatabaseApplication.restart();
        }
    }
    @GetMapping("/admin/login")
    @ResponseBody
    public AdminDTO get_loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            checkData();
            AdminDTO adminDTO;
            System.out.println("Input: username = " + username + " & pasword = " + password);
            for (Account acc : accountArrayList) {
                if (acc.login(username, password)) {
                    User user = userServiceImplement.getUserByID(acc.getUserid());
                    if (user.getIsAdmin()) {
                        System.out.print("Login success! - ");
                        System.out.println("Is admin");

                        Admin admin = adminServiceImplement.getAdminByID(user.getNumberAdminID());
                        adminDTO = new AdminDTO(acc, user, admin);
                        return adminDTO;
                    } else {
                        System.out.println("Not admin");
                    }
                }
            }
            System.out.println("Input: username = " + username + " & password = " + password);
            System.out.println("Login failed");
            return new AdminDTO();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new AdminDTO();
        }
    }

    @GetMapping("/login")
    @ResponseBody
    public StudentDTO get_loginStudent(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            checkData();
            StudentDTO studentDTO;
            System.out.println("Input: username = " + username + " & password = " + password);
            for (Account acc : accountArrayList) {
                if (acc.login(username, password)) {
                    System.out.print("Login success! - ");
                    User user = userServiceImplement.getUserByID(acc.getUserid());
                    if (!user.getIsAdmin()) {
                        System.out.println("Is student");
                        Student student = studentServiceImplement.getStudentByID(user.getNumberStudentID());

                        studentDTO = new StudentDTO(acc, user, student);
                        return studentDTO;
                    }
                    else {
                        System.out.println("Not student");
                    }
                }
            }
            System.out.println("Input: username = " + username + " & password = " + password);
            System.out.println("Login failed");
            return new StudentDTO();
        } catch (Exception e) {
            System.out.println("Error login student: " + e.getMessage() + e.getLocalizedMessage());
            return new StudentDTO();
        }
    }


}
