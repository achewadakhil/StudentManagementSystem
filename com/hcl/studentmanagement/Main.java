package com.hcl.studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> students = new ArrayList<>();

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

        int ch = 0;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("STUDENT MANAGEMENT SYSTEM:");
            System.out.println("1)Add part time student");

            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Adding new part time student : ");
                    System.out.print("Enter name : ");
                    String name = sc.next();
                    System.out.print("Enter id : ");
                    int id = sc.nextInt();
                    System.out.print("Enter date of joining : ");
                    String dateOfJoining = sc.next();
                    //adding
                    students.add(new PartTimeStudent(name, id, dateOfJoining));
                break;
                default:
                    break;
            }

        }while(ch <= 9);

    }
    
}
