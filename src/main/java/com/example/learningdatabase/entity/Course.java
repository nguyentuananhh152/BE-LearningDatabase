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

    private String ListLession;

    public Course() {
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getListLession() {
        return ListLession;
    }

    public void addLession(int idLession) {
        this.ListLession  = ListLession.replace("]","");
        this.ListLession += "," + idLession + "]";
    }

    public void replaceLession(int idLession, int idNewLession) {
        ArrayList<Integer> list = stringToList(ListLession);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idLession) {
                list.set(i, idNewLession);
            }
        }
    }

    public void removeLession(int idLession) {
        ArrayList<Integer> list = stringToList(ListLession);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idLession) {
                list.remove(i);
            }
        }
    }

    public Boolean isEmptyLession() {
        if(this.stringToList(ListLession).isEmpty()) {
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
