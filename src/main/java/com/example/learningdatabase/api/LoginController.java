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
import org.springframework.boot.web.server.Cookie;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
@SessionAttributes("studentDTO")
public class LoginController {
    @ModelAttribute("studentDTO")
    public StudentDTO studentDTO() {
        return new StudentDTO();
    }
    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;


    @PostMapping("/admin/login")
    @ResponseBody
    public AdminDTO post_loginAdmin(@Param("username") String username, @Param("password") String password) {
        try {
//            Cookie cookie = new Cookie("adminDTO");
            AdminDTO adminDTO = accountServiceImplement.loginAdmin(username, password);
            return adminDTO;
        } catch(Exception e) {
            return null;
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public StudentDTO post_loginStudent(@Param("username") String username, @Param("password") String password) {
        try {
            StudentDTO studentDTO = accountServiceImplement.loginStudent(username, password);
            return studentDTO;
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
