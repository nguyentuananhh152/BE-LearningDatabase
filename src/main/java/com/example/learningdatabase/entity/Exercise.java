package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    private String Name;

    private String Content;

    private String Answer;
    public Exercise() {
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }

    public String getAnswer() {return Answer;}
    public void setAnswer(String answer) {
        Answer = answer;
    }
}
