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

    private int numberID;

    @Bean
    public void createData() {
        try {
            accountArrayList = accountServiceImplement.getAllListAccount();
        } catch (Exception e) {}
    }
    @GetMapping("/admin/login")
    @ResponseBody
    public AdminDTO post_loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            AdminDTO adminDTO;
            if (accountArrayList == null) {
                System.out.println("Array is empty. Restarting server");
                for (int i = 3; i < 1; i--) {
                    System.out.println("Server will restart after: " + i + "s");
                    TimeUnit.SECONDS.sleep(1);
                }
                LearningDatabaseApplication.restart();
            }
            for (Account acc : accountArrayList) {
                System.out.println("Input: username = " + username + " & pasword = " + password);
                if (acc.login(username, password)) {
                    System.out.print("Login success! - ");
                    User user = userServiceImplement.getUserByID(acc.getUserid());
                    if (user.getIsAdmin() == true) {
                        System.out.println("Is admin");
                        Admin admin = adminServiceImplement.getAdminByID(user.getNumberAdminID());
                        adminDTO = new AdminDTO(acc, user, admin);
                        return adminDTO;
                    } else {
                        System.out.println("Not admin");
                    }
                }
            }
            return new AdminDTO();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new AdminDTO();
        }
    }

    @GetMapping("/login")
    @ResponseBody
    public StudentDTO post_loginStudent(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            StudentDTO studentDTO;
            if (accountArrayList == null) {
                System.out.println("Array is empty. Restarting server !!!");
                for (int i = 3; i < 1; i--) {
                    System.out.println("Server will restart after: " + i + "s");
                    TimeUnit.SECONDS.sleep(1);
                }
                LearningDatabaseApplication.restart();
            }
            for (Account acc : accountArrayList) {
                if (acc.login(username, password)) {
                    numberID = acc.getId();
                    acc.setIsLogin(true);
                    System.out.println("Input: username = " + username + " & pasword = " + password);
                    System.out.print("Login success! - ");
                    accountServiceImplement.saveAccount(acc);

                    User user = userServiceImplement.getUserByID(acc.getUserid());
                    if (!user.getIsAdmin()) {
                        System.out.println("Is student");
                        Student student = studentServiceImplement.getStudentByID(user.getNumberStudentID());
                        studentDTO = new StudentDTO(acc, user, student);
                        return studentDTO;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/both-login")
    public String doLogin(@ModelAttribute("studentDTO") StudentDTO studentDTO,
                          Model model,
                          @CookieValue(value = "studentDTO",defaultValue = "") StudentDTO studentDTOCookie,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        return "";
    }


}
