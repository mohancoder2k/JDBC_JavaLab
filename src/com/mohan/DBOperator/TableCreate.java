package com.mohan.DBOperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TableCreate {

    public void creatTable(String url) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Select a Database: ");
            String dbName = sc.next();
            String url2 = url + dbName;
            System.out.println("Updated url " + url2);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url2, "root", "12345678");
            Statement st = con.createStatement();

            System.out.print("Enter the Table Name to create: ");
            String tabName = sc.next();

            System.out.print("Enter number of attributes: ");
            int attrCount = sc.nextInt();

            StringBuilder query = new StringBuilder("CREATE TABLE " + tabName + " (");

            for (int i = 1; i <= attrCount; i++) {
                System.out.print("Enter attribute " + i + " name: ");
                String attrName = sc.next();

                System.out.print("Enter datatype for " + attrName + ": ");
                String dataType = sc.next();

                query.append(attrName).append(" ").append(dataType);

                if (i < attrCount) {
                    query.append(", ");
                }
            }

            query.append(")");

            st.executeUpdate(query.toString());
            System.out.println("Table '" + tabName + "' created successfully.");

            con.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
