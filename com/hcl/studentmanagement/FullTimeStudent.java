package com.hcl.studentmanagement;

public class FullTimeStudent extends Student {

    private long fees;
    
    public FullTimeStudent(String name, int id, String dateOfJoining,long fees) {
        super(name, id, dateOfJoining);
        this.fees = fees;
    }

    public long getFees() {
        return fees;
    }
}
