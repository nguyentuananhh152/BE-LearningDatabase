package com.example.learningdatabase.api;

import com.example.learningdatabase.LearningDatabaseApplication;
import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import com.example.learningdatabase.service.serviceimplement.AdminServiceImplement;
import com.example.learningdatabase.service.serviceimplement.StudentServiceImplement;
import com.example.learningdatabase.service.serviceimplement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Controller
@CrossOrigin
public class SignUpController {

    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;

    @Autowired
    private StudentServiceImplement studentServiceImplement;

    @Autowired
    private AdminServiceImplement adminServiceImplement;

    private ArrayList<Account> accountArrayList;

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

    @RequestMapping("/create-account")
    @ResponseBody
    public String post_createAccount(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam("email") String email,
                                   @RequestParam("name") String name,
                                   @RequestParam("age") int age,
                                   @RequestParam("address") String address) {
        try {
            checkData();
            System.out.print("Infor Signup account: ");
            System.out.print(", Username: " + username);
            System.out.print(", Pass word: " + password);
            System.out.print(", Email: " + email);
            System.out.print(", Name: " + name);
            System.out.print(", Age:" + age);
            System.out.println("Address: " + address);
            for (Account acc :accountArrayList) {
                if (acc.getUsername().equals(username)) {
                    System.out.println("Username: " + username + " - Account have been exist!" );
                    return "Account have been exist!" ;
                }
            }
            Student student = studentServiceImplement.saveStudent(new Student());
            User user = userServiceImplement.saveUser(new User(student.getId(), 0, name, "avatar.png", age, address));
            Account acc = accountServiceImplement.saveAccount(new Account(username, password, user.getId(), email));
            System.out.println("Create account student: ");
            System.out.println(student);
            System.out.println(user);
            System.out.println(acc);
            if (student.getId() == 0 || user.getId() == 0 || acc.getId() == 0 || student == null || user == null || acc == null) {
                return "Failed";
            }
            return "Success!";
        } catch(Exception e) {
            return "Failed, error!!" + e.getMessage();
        }
    }

    @RequestMapping("/create-account-admin")
    @ResponseBody
    public String post_createAccountAdmin(@RequestParam("username") String username,
                                         @RequestParam("password") String password,
                                         @RequestParam("email") String email,
                                         @RequestParam("name") String name,
                                         @RequestParam("age") int age,
                                         @RequestParam("address") String address) {
        System.out.println("Infor: ");
        System.out.println("Username: " + username);
        System.out.println("Pass word: " + password);
        System.out.println("Email: " + email);
        System.out.println("Name: " + name);
        System.out.println("Age:" + age);
        System.out.println("Address: " + address);
        Admin admin = adminServiceImplement.saveAdmin(new Admin());
        User user = userServiceImplement.saveUser(new User(0, admin.getId(), name, "avatar.png", age, address, true));
        Account acc = accountServiceImplement.saveAccount(new Account(username, password, user.getId(), email));
        System.out.println("Create account admin: ");
        System.out.println(admin);
        System.out.println(user);
        System.out.println(acc);
        if (admin.getId() == 0 || user.getId() == 0 || acc.getId() == 0 || admin == null || user == null || acc == null) {
            return "Failed!!";
        }
        return "Success!";
    }
}
