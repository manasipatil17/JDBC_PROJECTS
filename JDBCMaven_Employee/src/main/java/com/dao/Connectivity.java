package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {

	static Connection c;
	
	public static Connection conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3360/1043JDBCMaven","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
