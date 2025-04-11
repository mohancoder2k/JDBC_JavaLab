package com.mohan.DBOperator;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;
		String url = "jdbc:mysql://localhost:3306/";
		while(true) {
			 System.out.println("\n=== Menu ===");
	            System.out.println("1. TO Create Database ");
	            System.out.println("2. To create table");
	            System.out.println("3. Insert values into an Table");
	            System.out.println("4. Display an Table");
	            System.out.println("5. Exit ");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            switch(choice) {
	            case 1:
	            	DBCreation db = new DBCreation();
	            	db.createDatabase(url);
	            	
	            case 2:
	            	TableCreate tc = new TableCreate();
	            	tc.creatTable(url);
	            	
	            case 3:
	            	InsertValues iv = new InsertValues();
	            	iv.insert(url);
	            	
	            case 4:
	            	DisplayTable dt = new DisplayTable();
	            	dt.display(url);
	            	
	            case 5:
	            	System.out.println("Exiting");
	            	return;
	            }
		}

	}

}
