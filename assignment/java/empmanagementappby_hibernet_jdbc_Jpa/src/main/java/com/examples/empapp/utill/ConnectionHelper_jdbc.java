package com.examples.empapp.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionHelper_jdbc {
private static Connection conn = null ; 
	
	static final String dburl = "jdbc:mysql://localhost:3306/empdata";
	
	public static Connection createConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(dburl,"root","Shubham@555");
				System.out.println("Connection Created");
				return conn ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn ; 
	}

}
