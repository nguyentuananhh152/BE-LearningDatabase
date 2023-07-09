package com.example.learningdatabase.api;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.service.serviceimplement.AccountServiceImplement;
import com.example.learningdatabase.service.serviceimplement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class SignUpController {

    @Autowired
    private AccountServiceImplement accountServiceImplement;

    @Autowired
    private UserServiceImplement userServiceImplement;
    @RequestMapping("/create-account-default")
    @ResponseBody
    public void post_createAccountDefault() {
        Account acc = new Account();
        acc.setID(101);
        acc.setUserName("new Account");
        acc.setPassword("password");
        acc.setUserID(0);
        acc.setEmail("email@gmail.com");
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
    }

    @RequestMapping("/create-account")
    public void post_createAccount(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam("email") String email,
                                   @RequestParam("name") String name,
                                   @RequestParam("age") int age,
                                   @RequestParam("address") String address) {
        Account acc = new Account();
        acc.setUserName(username);
        acc.setPassword(password);
        acc.setUserID(0);
        acc.setEmail(email);
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);

        User user = new User();
        user.setName(name);
        user.setNumberAge(age);
        user.setAddress(address);
        userServiceImplement.saveUser(user);
    }
}
