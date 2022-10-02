package com.rest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createDatabase {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/";
	   static final String DB_NAME = "shoes";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "simplilearn";
	   
	   public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...\n");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query	    
		      stmt = conn.createStatement();
		      
		      //Drop database if exist
		      String sql = "DROP DATABASE IF EXISTS shoes";
		      stmt.executeUpdate(sql);
		           
		      //Create Shoes database
		      System.out.println("Creating database...");
		      sql = "CREATE DATABASE shoes";
		      stmt.executeUpdate(sql);
		      System.out.println("shoes Database created successfully...\n");
		      conn.close();
		      stmt.close();
		      
		      //Use Shoes database
		      System.out.println("Connecting to shoes database...\n");
		      conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
		      stmt = conn.createStatement();
		      
		      //Create product table
		      System.out.println("Creating product Table...");
		      sql = "CREATE TABLE product ("
		      		+ "productId INT NOT NULL PRIMARY KEY,"
		      		+ "productName VARCHAR(100),"
		      		+ "season VARCHAR(100),"
		      		+ "brand VARCHAR(100),"
		      		+ "category VARCHAR(100),"
		      		+ "price INT,"
		      		+ "color VARCHAR(100),"
		      		+ "createdDate DATE,"
		      		+ "discount INT,"
		      		+ "quantity INT);";
		      	
		      stmt.executeUpdate(sql);
		      System.out.println("product Table created successfully...\n");
		      
		    //Create user table
		      System.out.println("Creating user Table...");
		      sql = "CREATE TABLE user ("
		      		+ "userId INT NOT NULL PRIMARY KEY,"
		      		+ "userName VARCHAR(200),"
		      		+ "password VARCHAR(200),"
		      		+ "email VARCHAR(200),"
		      		+ "phone_number VARCHAR(100));";	
		      stmt.executeUpdate(sql);
		      System.out.println("user Table created successfully...\n");
		      
		    //Create product_order table
		      System.out.println("Creating product_order Table...");
		      sql = "CREATE TABLE product_order ("
		    		+ "productOrderId INT NOT NULL PRIMARY KEY,"
		      		+ "userId INT,"
		      		+ "productId INT,"
		      		+ "FOREIGN KEY (userId) REFERENCES user (userId),"
		      		+ "FOREIGN KEY (productId) REFERENCES product (productId));";	
		      stmt.executeUpdate(sql);
		      System.out.println("booking Table created successfully...\n");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Have A Nice Day");
		}//end main
}
