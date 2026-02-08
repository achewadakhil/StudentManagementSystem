package com.hcl.studentmanagement;


public class Student {
    private int id;
    private String name;
    private String dateOfJoining;
   
    Student(String name, int id, String dateOfJoining){
        this.name = name;
        this.id = id;
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", dateOfJoining=" + dateOfJoining;
    }

}


