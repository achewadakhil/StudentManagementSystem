package com.hcl.studentmanagement;


public class PartTimeStudent extends Student {
    private int hours;

    public PartTimeStudent(String name, int id, String dateOfJoining) {
        super(name, id, dateOfJoining);
        this.hours = 20;
    }
}

