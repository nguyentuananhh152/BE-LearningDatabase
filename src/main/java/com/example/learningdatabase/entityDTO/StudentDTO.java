package com.example.learningdatabase.entityDTO;

import com.example.learningdatabase.entity.Account;
import com.example.learningdatabase.entity.Student;
import com.example.learningdatabase.entity.User;

import java.util.ArrayList;

public class StudentDTO {
    private int ID;
    private String Username;
    private String Email;
    private String Name;
    private String Image;
    private int numberAge;
    private String Address;
//    private ArrayList<Integer> ListCourseRegistered;
//    private ArrayList<Integer> ListLessonLearned;
//    private ArrayList<Integer> ListExerciseDone;

    public StudentDTO() {}

    public StudentDTO(Account account, User user, Student student) {
        this.ID = student.getId();
        this.Username = account.getUsername();
        this.Email = account.getEmail();
        this.Name = user.getName();
        this.Image = user.getImage();
        this.numberAge = user.getNumberAge();
        this.Address = user.getAddress();
//        this.ListCourseRegistered = student.stringToList(student.getListCourseRegistered());
//        this.ListLessonLearned = student.stringToList(student.getListLessonLearned());
//        this.ListExerciseDone = student.stringToList(student.getListExerciseDone());
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public int getNumberAge() {
        return numberAge;
    }

    public String getAddress() {
        return Address;
    }

//    public ArrayList<Integer> getListCourseRegistered() {
//        return ListCourseRegistered;
//    }
//
//    public ArrayList<Integer> getListLessonLearned() {
//        return ListLessonLearned;
//    }
//
//    public ArrayList<Integer> getListExerciseDone() {
//        return ListExerciseDone;
//    }


}
