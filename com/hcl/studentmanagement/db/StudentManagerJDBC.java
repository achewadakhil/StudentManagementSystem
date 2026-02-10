package com.hcl.studentmanagement.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class StudentManagerJDBC {
    

    private static final String URL =
    "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "Password";
    
    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertStudent(String name,Date doj,boolean isFullTime,Integer fees, Integer hours){

        String query = "insert into students(name,dateOfJoin,isFullTime,fees,hours) values(?,?,?,?,?)";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setString(1,name);
            ps.setDate(2, doj);

            ps.setBoolean(3, isFullTime);

            if (fees != null) ps.setInt(4, fees);
            else ps.setNull(4, Types.INTEGER);

            if (hours != null) ps.setInt(5, hours);
            else ps.setNull(5, Types.INTEGER);

            int x = ps.executeUpdate();
            
            System.out.println(x);

        }catch(Exception e){    
            e.printStackTrace();
        }
    }


    public static void removeStudent(int id){

        String sql = "delete from students where id = ?";
        try(Connection con = getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1,id);

            int rowsAffected  = ps.executeUpdate();
            
            if(rowsAffected == 0) System.out.println("Couldn't delete");
            else    System.out.println(id + " is deleted");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void getStudentDetails(int id){


        String sql = "select * from students where id = ?";
        try(Connection con = getConnection();
        
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                Date doj = rs.getDate("dateOfJoin");
                boolean isFullTime = rs.getBoolean("isFullTime");
                int fees = rs.getInt("fees");   // careful with NULLs
                int hours = rs.getInt("hours");

                System.out.println(id + " " + name + " " + doj + " "+isFullTime+" "+fees +" "+hours);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void viewStudents(){

        String sql = "select * from students";

        try(Connection con = getConnection();
            Statement st = con.createStatement()){

            ResultSet rs = st.executeQuery(sql);
            
            System.out.println("All students are : ");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date doj = rs.getDate("dateOfJoin");
                boolean isFullTime = rs.getBoolean("isFullTime");
                int fees = rs.getInt("fees");   // careful with NULLs
                int hours = rs.getInt("hours");

                System.out.println(id + " " + name + " " + doj + " "+isFullTime+" "+fees +" "+hours);
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
