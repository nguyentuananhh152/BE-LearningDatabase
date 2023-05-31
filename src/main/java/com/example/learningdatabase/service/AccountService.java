package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface AccountService {
    public Account getAccountByID(int id);
    public ArrayList<Account> getAllListAccount();
    public void saveAccount(Account account);
    public void updateEmailAccountByID(int id, Account account);
    public void changePassword(int id, String oldPass, String newPass);
    public void deleteAccountByID(int id);


}
