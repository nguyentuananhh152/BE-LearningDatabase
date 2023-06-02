package com.example.learningdatabase.api;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.repository.AdminRepository;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
//    @Autowired
//    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private AdminRepository adminRepository;
    public AdminController() {}
//    @GetMapping("/get-account/{id}")
    @GetMapping("home")
    @ResponseBody
    public Admin get_getAdminByID() {
        return adminRepository.findById(1).get();
    }
}
