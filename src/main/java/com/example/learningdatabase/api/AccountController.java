package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.service.AccountServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller("/api")
public class AccountController {

    @Autowired
    private AccountServiceImplement accountServiceImplement;

    public AccountController() {}

    @GetMapping("/")
    public String home() {
        return "home.html";
    }


    @GetMapping("/get-account/{id}")
    @ResponseBody
    public Account get_getAccountByID(@PathVariable("id") int id) {
        Account acc = accountServiceImplement.getAccountByID(id);
        return acc;
    }


    @GetMapping("/get-all-list-account")
    @ResponseBody
    public ArrayList<Account> get_getAllListAccount() {
        return accountServiceImplement.getAllListAccount();
    }

    @DeleteMapping("/delete-account/{id}")
    public void delete_deleteAccountByID(@PathVariable("id") int id) {
        accountServiceImplement.deleteAccountByID(id);
    }

    @PostMapping("/create-account-default")
    public void post_createAccountDefault() {
        Account acc = new Account();
        acc.setUserName("new Account");
        acc.setPassword("password");
        acc.setUserID(0);
        acc.setEmail("email@gmail.com");
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
    }

    @PostMapping("/create-account/username={username}/password={password}/email={email}")
    public void post_createAccount(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("email") String email) {
        Account acc = new Account();
        acc.setUserName(username);
        acc.setPassword(password);
        acc.setUserID(0);
        acc.setEmail(email);
        acc.setIsLogin(false);
        accountServiceImplement.saveAccount(acc);
    }
}
