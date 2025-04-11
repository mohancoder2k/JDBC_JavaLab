package com.mohan.JDBC;

import java.sql.*;

public class DBCreation {
    public static void main(String[] args) {
        try {
            // 1) Register the MYSQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2) Creating a connection
            String url = "jdbc:mysql://localhost:3306";
            String username = "root";
            String password = "12345678";
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established...");

            // 3) Create Database
            Statement st = con.createStatement();
            String DB_Name = "Smvec_LAB2";
            String DBCreate = "CREATE DATABASE " + DB_Name; 
            st.executeUpdate(DBCreate);
            System.out.println("Database created successfully");

            // Closing the first initial connection
            con.close();

            // 4) Reconnect to the created database
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_Name, username, password);
            st = con.createStatement();

            // 5) Create Table
            String Tab_Name = "cseA";
            String Tab_Query = "CREATE TABLE " + Tab_Name + " (" +
                               "rno INT, " +
                               "Name VARCHAR(100), " +
                               "City VARCHAR(100))";
            st.executeUpdate(Tab_Query);
            System.out.println("Table created successfully");

            con.close();
            
            // Inserting Values into table 
            //con = DriverManager.getConnection(url)
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
