package com.hcl.studentmanagement;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String dateOfJoining;
   
    Student(String name, int id, String dateOfJoining){
        this.name = name;
        this.id = id;
        this.dateOfJoining = dateOfJoining;
        System.out.println(name + " " + id + " " + dateOfJoining+" added successfully");
    }
}


