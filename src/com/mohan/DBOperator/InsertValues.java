package com.mohan.DBOperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertValues {
    public void insert(String url) {
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

            System.out.print("Enter number of columns to insert values into: ");
            int columnCount = sc.nextInt();

            StringBuilder columns = new StringBuilder("(");
            StringBuilder values = new StringBuilder("VALUES (");

            for (int i = 1; i <= columnCount; i++) {
                System.out.print("Enter column " + i + " name: ");
                String colName = sc.next();
                System.out.print("Enter value for " + colName + ": ");
                String value = sc.next();

                columns.append(colName);
                // Quote the value if it's not numeric
                if (value.matches("-?\\d+(\\.\\d+)?")) {
                    values.append(value); // numeric
                } else {
                    values.append("'").append(value).append("'"); // string
                }

                if (i < columnCount) {
                    columns.append(", ");
                    values.append(", ");
                }
            }

            columns.append(")");
            values.append(")");

            String query = "INSERT INTO " + tableName + " " + columns + " " + values;
            System.out.println("Generated Query: " + query);

            st.executeUpdate(query);
            System.out.println("Values inserted successfully.");

            con.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
