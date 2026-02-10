package com.hcl.studentmanagement.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
