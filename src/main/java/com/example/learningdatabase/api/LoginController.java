package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.AdminDTO;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.repository.UserRepository;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import com.example.learningdatabase.service.serviceimplement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;

//    @GetMapping("/login")
//    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
//        int id = accountServiceImplement.loginAndGetUserID(username, password);
//        if (id != -1) {
//            boolean isadmin = userServiceImplement.getUserByID(id).getIsAdmin();
//            if (isadmin) {
//                return new Admin();
//            }
//        }
//    }
}
