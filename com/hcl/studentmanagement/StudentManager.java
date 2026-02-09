package com.hcl.studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private static List<Student> students = new ArrayList<>();
    public static void createPartTimeStudent() {
        // System.out.println("Enter name : ");
        // String name = sc.next();
        // System.out.println("Ent  er id : ");
        // int id = sc.nextInt();
        // System.out.println("Enter date of joining : ");
        // String dateOfJoining = sc.next();
        PartTimeStudent partTimeStudent = new PartTimeStudent("akhil", 101, "2023-01-01");
        students.add(partTimeStudent);
        System.out.println("Added new part time student");
    }

    public static void createFullTimeStudent() {
        // System.out.println("Adding new full time student : ");
        // System.out.println("Enter name : ");
        // String name = sc.next();
        // System.out.println("Enter id : ");
        // int id = sc.nextInt();
        // System.out.println("Enter date of joining : ");
        // String dateOfJoining = sc.next();
        // System.out.println("Enter fees : ");
        FullTimeStudent fullTimeStudent = new FullTimeStudent("john", 102, "2023-02-01", 5000);
        students.add(fullTimeStudent);
        System.out.println("Added new full time student");
    }

    public static void printAllStudents() {
        System.out.println("All students:");
        for(Student s : students) {
            System.out.print(s+" ");


            // Example of downcasting
            if( s instanceof PartTimeStudent) {
                System.out.println(((PartTimeStudent) s).getHours());
            } else if(s instanceof FullTimeStudent) {
                System.out.println(((FullTimeStudent) s).getFees());
            }
        }   
    }

    public static void removeStudent(int id){
        for( Student s : students){
            if(s.getId() == id){
                students.remove(s);
            System.out.println("Removed successfully");
            return;
            }
        }
        System.out.println("Id not found");
    }
}
// s = 1 2 3
// s2 = 1 2 3