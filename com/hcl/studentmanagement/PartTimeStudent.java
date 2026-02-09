package com.hcl.studentmanagement;

import java.time.LocalDate;

public class PartTimeStudent extends Student {
    private int hours;

    public PartTimeStudent(String name, int id, LocalDate dateOfJoining) {
        super(name, id, dateOfJoining);
        this.hours = 20;
    }

    public int getHours() {
        return hours;
    }
}

