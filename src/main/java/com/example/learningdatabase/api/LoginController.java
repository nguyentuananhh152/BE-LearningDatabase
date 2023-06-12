package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.entityDTO.AdminDTO;
import com.example.learningdatabase.entityDTO.StudentDTO;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.repository.UserRepository;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import com.example.learningdatabase.service.serviceimplement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;


    @GetMapping("/admin/login")
    @ResponseBody
    public AdminDTO get_loginAdmin(@Param("username") String username, @Param("password") String password) {
        try {
            return accountServiceImplement.loginAdmin(username, password);
        } catch(Exception e) {
            return null;
        }
    }

    @GetMapping("/login")
    @ResponseBody
    public StudentDTO get_loginStudent(@Param("username") String username, @Param("password") String password) {
        return accountServiceImplement.loginStudent(username, password);
    }
}
