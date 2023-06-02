package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.repository.AccountRepository;
import com.example.learningdatabase.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImplement() {}


    @Override
    public Account getAccountByID(int id) {
        try {
            if (accountRepository.existsById(id)) {
                Account acc = accountRepository.findById(id).get();
                acc.setPassword("");
                return acc;
            } else {
                return new Account();
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Account> getAllListAccount() {
        try {
            ArrayList<Account> arr = new ArrayList<>();
            accountRepository.findAll().forEach(account -> {
                account.setPassword("");
                arr.add(account);
            });
            return arr;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            accountRepository.save(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateEmailAccountByID(int id, String email) {
        try {
            if (accountRepository.existsById(id)) {
                Account acc = accountRepository.findById(id).get();
                acc.setEmail(email);
                accountRepository.save(acc);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void changePassword(int id, String oldPass, String newPass) {
        try {
            if (accountRepository.existsById(id)) {
                if (oldPass == accountRepository.findById(id).get().getPassWord()) {
                    Account acc = accountRepository.findById(id).get();
                    acc.setPassword(newPass);
                    accountRepository.save(acc);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteAccountByID(int id) {
        try {
            if (accountRepository.existsById(id)) {
                accountRepository.deleteById(id);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void updateIsLoginByID(int id, Boolean b) {
        try {
            if (accountRepository.existsById(id)) {
                accountRepository.findById(id).get().setIsLogin(b);
            }
        } catch (Exception e) {
        }
    }
}
