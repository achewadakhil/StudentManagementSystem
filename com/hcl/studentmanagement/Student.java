package com.hcl.studentmanagement;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate dateOfJoining;
   
    Student(String name, int id, LocalDate dateOfJoining){
        this.name = name;
        this.id = id;
        this.dateOfJoining = dateOfJoining;
    }

    public int getId(){
        return this.id;
    }

    public LocalDate getDate(){
        return this.dateOfJoining;
    }
    
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", dateOfJoining=" + dateOfJoining;
    }

}


