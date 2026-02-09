package com.hcl.studentmanagement;

import java.time.LocalDate;

public class FullTimeStudent extends Student {

    private long fees;
    
    public FullTimeStudent(String name, int id, LocalDate dateOfJoining,long fees) {
        super(name, id, dateOfJoining);
        this.fees = fees;
    }

    public long getFees() {
        return fees;
    }
}
