package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numberStudentID;

    private int numberAdminID;

    private String Name = "";

    private String Image = "";

    private int numberAge;

    private String Address = "";

    private Boolean IsAdmin = false;

    public User() {}

    public User(int numberStudentID, int numberAdminID, String name, String image, int numberAge, String address) {
        this.numberStudentID = numberStudentID;
        this.numberAdminID = numberAdminID;
        Name = name;
        Image = image;
        this.numberAge = numberAge;
        Address = address;
    }

    public User(int numberStudentID, int numberAdminID, String name, String image, int numberAge, String address, Boolean isAdmin) {
        this.numberStudentID = numberStudentID;
        this.numberAdminID = numberAdminID;
        Name = name;
        Image = image;
        this.numberAge = numberAge;
        Address = address;
        IsAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }
//
//    public int getStudentID() {
//        return numberStudentID;
//    }
//
//    public int getAdminID() {
//        return numberAdminID;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public String getImage() {
//        return Image;
//    }
//
//    public void setImage(String image) {
//        Image = image;
//    }
//
//    public int getAge() {
//        return numberAge;
//    }
//
//    public void setAge(int age) {
//        numberAge = age;
//    }
//
//    public String getAddress() {
//        return Address;
//    }
//
//    public void setAddress(String address) {
//        Address = address;
//    }
//
//    public Boolean IsAdmin() {
//        return IsAdmin;
//    }
//
//    public void setIsAdmin(Boolean admin) {
//        IsAdmin = admin;
//    }
}
