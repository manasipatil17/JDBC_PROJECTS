package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.Connectivity;
import com.pojo.Employee;
 

public class Logic {

	Scanner sc=new Scanner(System.in);
	public void createTable() throws Exception {
		Connection c=Connectivity.conn();
		PreparedStatement ps=c.prepareStatement("create table Employee(id int primary key,name varchar(50) not null,city varchar(50))");
	    ps.execute();
	    System.out.println("Table created successfully");
	}
	
	public void insertRow() throws Exception {
		System.out.println("Enter new Employees id, name, city");
		Employee e=new Employee(sc.nextInt(), sc.next(),sc.next());
		Connection c=Connectivity.conn();
		PreparedStatement ps= c.prepareStatement("insert into Employee(id, name, city) values (?,?,?)");
        ps.setInt(1, e.getId());
        ps.setString(2, e.getName());
        ps.setString(3, e.getCity());
        System.out.println("New data inserted...");
		ps.executeUpdate();
	}
	
	public void updateEmpName() {
		System.out.println("Enter id where you want to update name : ");
		int id=sc.nextInt();
		System.out.println("Enter new name : ");
		String name=sc.next();
		Connection c=Connectivity.conn();
		try {
			PreparedStatement ps=c.prepareStatement("update Employee set name=? where id=?");
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Name updated successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateEmpCity() {
		System.out.println("Enter id where you want to update city : ");
		int id=sc.nextInt();
		System.out.println("Enter new city name : ");
		String city=sc.next();
		Connection c=Connectivity.conn();
		try {
			PreparedStatement ps=c.prepareStatement("update Employee set city=? where id=?");
			ps.setString(1, city);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("City name updated successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee() {
		System.out.println("Enter id you want to delete : ");
		int id=sc.nextInt();
		Connection c=Connectivity.conn();
		try {
			PreparedStatement ps=c.prepareStatement("Delete from Employee where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Employee deleted successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void read1Emp() {
		System.out.println("Enter id you want to read particular Employee : ");
		int id=sc.nextInt();
		Connection c=Connectivity.conn();
		try {
			PreparedStatement ps=c.prepareStatement("select * from Employee where id =? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setCity(rs.getString(3));
				System.out.println(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void ReadAll() {
	Connection c=Connectivity.conn();
	try {
		PreparedStatement ps=c.prepareStatement("select * from Employee");

		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setCity(rs.getString(3));
			System.out.println(e);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
