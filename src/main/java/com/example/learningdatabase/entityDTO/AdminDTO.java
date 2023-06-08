package com.example.learningdatabase.entityDTO;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.entity.User;


public class AdminDTO {
    private int ID;
    private String Username;
    private String PassWord = "";
    private String Email;
    private String Name;
    private String Image;
    private int numberAge;
    private String Address;

    public AdminDTO() {}

    public AdminDTO(Account account, User user, Admin admin) {
        this.ID = admin.getId();
        this.Username = account.getUsername();
        this.Email = account.getEmail();
        this.Name = user.getName();
        this.Image = user.getImage();
        this.numberAge = user.getNumberAge();
        this.Address = user.getAddress();
    }
}
