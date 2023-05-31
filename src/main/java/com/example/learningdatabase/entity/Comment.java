package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    private int UserID;

    @Column(columnDefinition = "varchar(255) default ''")
//    @Column(columnDefinition = "boolean default false")
    private String Content;

    private int numberLike;

    private int Dislike;

    private int Flag;

    public Comment() {
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return UserID;
    }

    public String getContent() {
        return Content;
    }

    public int getLike() {
        return numberLike;
    }

    public int getDislike() {
        return Dislike;
    }

    public int getFlag() {
        return Flag;
    }

    public void setLike(int like) {
        numberLike = like;
    }

    public void setDislike(int dislike) {
        Dislike = dislike;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }
}
