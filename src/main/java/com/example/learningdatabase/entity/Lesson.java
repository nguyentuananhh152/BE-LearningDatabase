package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    private String Name;

    private String Content;

    private String ListExercise;

    private String ListComment;

    public Lesson() {
    }

    public int getID() {
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

    public String getListExercise() {
        return ListExercise;
    }

    public void addExercise(int id) {
        ListExercise = ListExercise.replace("]", "");
        ListExercise += "," + id + "]";
    }

    public void replaceExercise(int idEx, int idNewEx) {
        ArrayList<Integer> list = stringToList(ListExercise);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idEx) {
                list.set(i, idNewEx);
            }
        }
    }

    public void removeExercise(int id) {
        ArrayList<Integer> list = stringToList(ListExercise);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == id) {
                list.remove(i);
            }
        }
    }

    public String getListComment() {
        return ListComment;
    }

    public void addComment(int id) {
        ListComment = ListComment.replace("]", "");
        ListComment += "," + id + "]";
    }

    public void removeComment(int id) {
        ArrayList<Integer> list = stringToList(ListComment);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == id) {
                list.remove(i);
            }
        }
    }

    public ArrayList<Integer> stringToList(String str) {
        String replace = str.replace("[","");
        String replace1 = replace.replace("]","");
        ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(replace1.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList()));
        System.out.println(myList.toString());
        return myList;
    }
}
