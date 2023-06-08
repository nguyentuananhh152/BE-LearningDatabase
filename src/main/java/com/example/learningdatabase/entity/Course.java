package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    private String Name;

    private String Description;

    private String ListLesson;

    public Course() {
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getListLesson() {
        return ListLesson;
    }

    public void addLesson(int idLesson) {
        this.ListLesson  = ListLesson.replace("]","");
        this.ListLesson += "," + idLesson + "]";
    }

    public void replaceLesson(int idLesson, int idNewLesson) {
        ArrayList<Integer> list = stringToList(ListLesson);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idLesson) {
                list.set(i, idNewLesson);
            }
        }
    }

    public void removeLesson(int idLesson) {
        ArrayList<Integer> list = stringToList(ListLesson);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idLesson) {
                list.remove(i);
            }
        }
    }

    public Boolean isEmptyLesson() {
        if(this.stringToList(ListLesson).isEmpty()) {
            return true;
        } else {
            return false;
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
