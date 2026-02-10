package com.hcl.studentmanagement;

import java.time.LocalDate;
// import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hcl.studentmanagement.db.StudentManagerJDBC;
import com.hcl.studentmanagement.utils.InvalidChoiceException;

public class Main {

    static List<Student> students = new ArrayList<>();



    public static void validateChoice(int ch) throws InvalidChoiceException{
        if(ch < 0 || ch > 11){
            throw new InvalidChoiceException("Choice should be between 0 to 11");
        }
    }


    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            int ch = 0;
            System.out.println("STUDENT MANAGEMENT SYSTEM:");
            System.out.println("1)Add part time student");
            System.out.println("2)Add full time student ");
            System.out.println("3)Remove Student");
            System.out.println("4)View student by id");
            System.out.println("5)View all students");
            System.out.println("6)Sort by Id");
            System.out.println("7)Sort by Date");
        
        
            //System.out.println("11)ViewAll");
            do{
                System.out.print("Enter choice :");
                ch = sc.nextInt();

                sc.nextLine();

                validateChoice(ch);

                switch (ch) {
                    case 1: {
                        System.out.print("Enter name:");
                        String name = sc.nextLine();

                        System.out.print("Enter Date of Joining (yyyy-MM-dd): ");
                        String doj = sc.nextLine();

                        LocalDate dateOfJoin = LocalDate.parse(doj);


                        System.out.print("Enter working hours: ");
                        int hours = sc.nextInt();

                        StudentManagerJDBC.insertStudent(
                                name,
                                java.sql.Date.valueOf(dateOfJoin),
                                false,
                                null,
                                hours
                        );
                        break;
                    }

                    case 2 : {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Date of Joining (yyyy-MM-dd): ");
                        String doj = sc.nextLine();

                        LocalDate dateOfJoin = LocalDate.parse(doj);


                        System.out.print("Enter fees: ");
                        int fees = sc.nextInt();

                        StudentManagerJDBC.insertStudent(
                                name,
                                java.sql.Date.valueOf(dateOfJoin),
                                true,
                                fees,
                                null
                        );
                        break;
                    }
                    case 3 :{ 
                        System.out.print("Enter id to remove: ");
                        int id = sc.nextInt();
                        StudentManagerJDBC.removeStudent(id);
                        break;
                    }
                    case 4 : { 
                        System.out.print("Enter id to view: ");
                        int id = sc.nextInt();
                        StudentManagerJDBC.getStudentDetails(id);
                        break;
                    }
                    case 5 : {
                        StudentManagerJDBC.viewStudents();
                        break;
                    }
                    case 6 :
                        StudentManagerJDBC.sortById();
                        break;
                    case 7 : 
                        StudentManagerJDBC.sortByDate();
                        break;
                    default:
                        break;
                }

            }while(ch != 0 && ch <=7);
        }catch(InvalidChoiceException e){
            System.out.println(e.getMessage());
        }
    }
    
}
