package com.hcl.studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


public class StudentManager {

    Scanner sc = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void createPartTimeStudent() {
        System.out.println("Enter name : ");
        String name = sc.next();
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println("Enter date of joining : (DD-MM-YYYY)");
        String doj = sc.next();
        LocalDate dateOfJoining = LocalDate.parse(doj,formatter);
        PartTimeStudent partTimeStudent = new PartTimeStudent(name, id, dateOfJoining);
        students.add(partTimeStudent);
        System.out.println("Added new part time student");
    }

    public void createFullTimeStudent() {
        System.out.println("Adding new full time student : ");
        System.out.println("Enter name : ");
        String name = sc.next();
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println("Enter date of joining : (DD-MM-YYYY)");
        String doj = sc.next();
        LocalDate dateOfJoining = LocalDate.parse(doj,formatter);
        System.out.println("Enter fees : ");
        long fees = sc.nextLong();
        FullTimeStudent fullTimeStudent = new FullTimeStudent(name,id, dateOfJoining, fees);
        students.add(fullTimeStudent);
        System.out.println("Added new full time student");
    }

    public void printAllStudents() {
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

    public void removeStudent(int id){
        for( Student s : students){
            if(s.getId() == id){
                students.remove(s);
            System.out.println("Removed successfully");
            return;
            }
        }
        System.out.println("Id not found");
    }

    public Student viewStudent(int id){
        for(Student s : students){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public List<Student> sortById(){
        List<Student> sortedList = new ArrayList<>();

        sortedList.addAll(students);

        Collections.sort(sortedList,(a,b)-> a.getId() - b.getId());

        return sortedList;
    }

    public List<Student> sortByDate(){
        List<Student> sortedList = new ArrayList<>();
        
        sortedList.addAll(students);

        Collections.sort(sortedList,(a,b)->a.getDate().compareTo(b.getDate()));

        return sortedList;
    }
}
// s = 1 2 3
// s2 = 1 2 3