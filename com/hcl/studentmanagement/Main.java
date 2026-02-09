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


    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        int ch = 0;
        System.out.println("STUDENT MANAGEMENT SYSTEM:");
        System.out.println("1)Add part time student");
        System.out.println("2)Add full time student ");
        System.out.println("3)Remove Student");
       
        System.out.println("11)ViewAll");
        do{
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    StudentManager.createPartTimeStudent();
                break;

                case 2 : 
                    StudentManager.createFullTimeStudent();
                break;
                case 3 : 
                    System.out.println("Enter id to remove : ");
                    StudentManager.removeStudent(sc.nextInt());
                case 11 : 
                    StudentManager.printAllStudents();
                break;
                default:
                    break;
            }

        }while(ch != 0);
        sc.close();
    }
    
}
