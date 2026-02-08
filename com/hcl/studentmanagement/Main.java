package com.hcl.studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> students = new ArrayList<>();

    static Scanner sc;

    /*
        STUDENT MANAGEMENT SYSTEM::
        1)Add part time student
        2)Add full time student 
        3)Remove Student
        4)View student
        5)View students
        6)Sort based on id
        7)Sort based on date of joining
        8)Sort by first name
        9)Exit
    
    */

    public static void createPartTimeStudent() {
        System.out.println("Enter name : ");
        String name = sc.next();
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println("Enter date of joining : ");
        String dateOfJoining = sc.next();
        PartTimeStudent partTimeStudent = new PartTimeStudent("akhil", 101, "2023-01-01");
        students.add(partTimeStudent);
        System.out.println("Added new part time student");
    }

    public static void createFullTimeStudent() {
        System.out.println("Adding new full time student : ");
        System.out.println("Enter name : ");
        String name = sc.next();
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println("Enter date of joining : ");
        String dateOfJoining = sc.next();
        System.out.println("Enter fees : ");
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
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        int ch = 0;
        System.out.println("STUDENT MANAGEMENT SYSTEM:");
        System.out.println("1)Add part time student");
        System.out.println("2)Add full time student ");
        System.out.println("11)ViewAll");
        do{
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    createPartTimeStudent();
                break;

                case 2 : 
                    createFullTimeStudent();
                break;
                case 11 : 
                    printAllStudents();
                break;
                default:
                    break;
            }

        }while(ch <= 9);
        sc.close();
    }
    
}
