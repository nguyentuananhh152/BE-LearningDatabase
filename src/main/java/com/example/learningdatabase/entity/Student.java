package com.example.learningdatabase.entity;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ListCourseRegistered;

    private String ListLessionLearned;

    private String ListExerciseDone;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getListCourseRegistered() {
        return ListCourseRegistered;
    }

    public void setListCourseRegistered(String listCourseRegistered) {
        ListCourseRegistered = listCourseRegistered;
    }

    public String getListLessionLearned() {
        return ListLessionLearned;
    }

    public void setListLessionLearned(String listLessionLearned) {
        ListLessionLearned = listLessionLearned;
    }

    public String getListExerciseDone() {
        return ListExerciseDone;
    }

    public void setListExerciseDone(String listExerciseDone) {
        ListExerciseDone = listExerciseDone;
    }

    public ArrayList<Integer> stringToList(String str) {
        String replace = str.replace("[","");
        String replace1 = replace.replace("]","");
        ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(replace1.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList()));
        System.out.println(myList.toString());
        return myList;
    }
}
