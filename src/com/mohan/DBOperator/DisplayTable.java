package com.mohan.DBOperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayTable {
	public void display(String url) {
		  try {
	            Scanner sc = new Scanner(System.in);

	            System.out.print("Select a Database: ");
	            String dbName = sc.next();
	            String url2 = url + dbName;
	            System.out.println("Updated url: " + url2);

	            System.out.print("Select the table: ");
	            String tableName = sc.next();
	            System.out.println("Selected table name: " + tableName);

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url2, "root", "12345678");
	            Statement st = con.createStatement();

	            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();

	            System.out.println("\n--- Table Data ---");

	            // Print column names
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.print(rsmd.getColumnName(i) + "\t");
	            }
	            System.out.println();

	            // Print rows
	            while (rs.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    System.out.print(rs.getString(i) + "\t");
	                }
	                System.out.println();
	            }

	            con.close();
	            System.out.println("Connection closed.");
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	}
}
