package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entityDTO.AdminDTO;
import com.example.learningdatabase.entityDTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface AccountService {
    public Account saveAccount(Account account);
    public Account getAccountByID(int id);
    public ArrayList<Account> getAllListAccount();

    public void updateEmailAccountByID(int id, String email);
    public void changePassword(int id, String oldPass, String newPass);
    public void deleteAccountByID(int id);
    public boolean exist(int id);

    public void updateIsLoginByID(int id, Boolean b);

    public StudentDTO loginStudent(String username, String password);

    public AdminDTO loginAdmin(String username, String password);

    public boolean register(String username, String password, String email);


}
