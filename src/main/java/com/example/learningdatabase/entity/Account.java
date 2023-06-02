package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//public class Account implements Serializable {

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    @Column (name = "username", nullable = false, length = 50)
    private String UserName;

    @Column (name = "password", nullable = false, length = 50)
    private String PassWord;

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @JoinColumn(name = "user")
//    private User user;
    @Column(name = "userid", nullable = false)
    private int UserID;


    @Column (name = "email", length = 50)
    private String Email;

    @Column (name = "isLogin", nullable = false)
    private Boolean IsLogin;

    public int getId() {
        return ID;
    }

    public String getUsername() {
        return UserName;
    }


    public void setPassword(String password) {
        this.PassWord = password;
    }

    public int getUserid() {
        return UserID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public Boolean IsLogin() {
        return IsLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.IsLogin = isLogin;
    }

    @PrePersist()
    private void preInsert() {

    }
}
