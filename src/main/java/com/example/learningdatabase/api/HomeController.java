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



    @DeleteMapping("/delete-account/{id}")
    public void delete_deleteAccountByID(@PathVariable("id") int id) {
        accountServiceImplement.deleteAccountByID(id);
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
