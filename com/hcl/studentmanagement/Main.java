package com.hcl.studentmanagement;

// import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hcl.studentmanagement.db.StudentManagerJDBC;
import com.hcl.studentmanagement.utils.InvalidChoiceException;

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


    public static void validateChoice(int ch) throws InvalidChoiceException{
        if(ch < 0 || ch > 11){
            throw new InvalidChoiceException("Choice should be between 0 to 11");
        }
    }


    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        StudentManager sms = new StudentManager();
        int ch = 0;
        System.out.println("STUDENT MANAGEMENT SYSTEM:");
        System.out.println("1)Add part time student");
        System.out.println("2)Add full time student ");
        System.out.println("3)Remove Student");
        System.out.println("4)View student by id");
        System.out.println("5)View all students");
        System.out.println("6)Sort by Id");
        System.out.println("7)Sort by Date");
        // System.out.println("8)Sort by name");
    
       
        System.out.println("11)ViewAll");
        try{
            do{
                System.out.print("Enter choice :");
                ch = sc.nextInt();

                validateChoice(ch);

                switch (ch) {
                    case 1:
                        // sms.createPartTimeStudent();
                        StudentManagerJDBC.insertStudent("Akhil", java.sql.Date.valueOf("2004-08-08"), false, null, 10);
                    break;

                    case 2 : 
                        StudentManagerJDBC.insertStudent("Akash", java.sql.Date.valueOf("2009-08-29"), true, 200000, null);
                    break;
                    case 3 : 
                        System.out.println("Enter id to remove : ");
                        StudentManagerJDBC.removeStudent(sc.nextInt());
                    case 4 : 
                        System.out.println("Enter id to view :");
                        StudentManagerJDBC.getStudentDetails(sc.nextInt());
                    case 5 : 
                        
                        StudentManagerJDBC.viewStudents();
                        break;
                    case 6 :
                        List<Student> soretdById = sms.sortById();
                        for(Student ss : soretdById){
                            System.out.println(ss);
                        }
                        break;
                    case 7 : 
                        List<Student> sortedByDate = sms.sortByDate();
                        for(Student s1 : sortedByDate){
                            System.out.println(s1);
                        }
                
                    default:
                        break;
                }

            }while(ch != 0);
        }catch(InvalidChoiceException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
    
}
