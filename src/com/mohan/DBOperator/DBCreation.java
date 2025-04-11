package com.mohan.DBOperator;
import java.sql.*;
import java.util.*;
public  class DBCreation {
	
	public void createDatabase(String url) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection( url, "root", "12345678");
			Statement st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the database name to create : ");
			String dbName = sc.next();
			String query = "CREATE DATABASE " + dbName;
			st.executeUpdate(query);
			System.out.println("Database Created successfully");
			con.close();
			System.out.println("Connection closed");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
