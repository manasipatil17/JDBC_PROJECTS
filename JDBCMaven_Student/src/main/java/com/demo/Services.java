package com.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Services {

	public void createStudent() throws SQLException {
		Connection c=Dao.conn();
	     Statement s=c.createStatement();
	     s.execute("create table Student(id int Primary key, name varchar(50), city varchar(50))");
	     System.out.println("table created");
	     c.close();
	}
	public void insertRows() {
		Connection c = Dao.conn();
	   Statement s;
	try {
		s = c.createStatement();
	   s.executeUpdate("insert into student(id,name,city) values (103,'raj','akola')");
	   System.out.println("row inserted");
	   c.close();
	} catch (SQLException e) {
		System.out.println("row not added");
		}
	}
	
	public void readAllRows() throws Exception {
		Connection c=Dao.conn();
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select * from student");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
		c.close();
		}
	public void deleteRow() throws Exception {
		Connection c=Dao.conn();
		Statement s=c.createStatement();
		s.executeUpdate("delete from student where id=101");
		System.out.println("row deleted");
		c.close();
	}
	
	public void updateName() throws Exception {
		Connection c=Dao.conn();
		Statement s=c.createStatement();
		s.executeUpdate("update student set name='rajaram' where id=103");
		System.out.println("name updated");
		c.close();
	}
}
