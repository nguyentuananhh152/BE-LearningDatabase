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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getNumberAge() {
        return numberAge;
    }

    public void setNumberAge(int numberAge) {
        this.numberAge = numberAge;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
