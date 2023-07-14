package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    public Admin() {
    }

    public Admin(int id) {
        ID = id;
    }


    public int getId() {
        return ID;
    }

}
