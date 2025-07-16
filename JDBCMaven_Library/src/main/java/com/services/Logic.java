package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.Connectivity;
import com.pojo.Library;

public class Logic {

	Scanner sc=new Scanner(System.in);
	public void createTable() throws Exception {
		Connection c=Connectivity.conn();
		PreparedStatement ps=c.prepareStatement("create table Library(id int primary key,title varchar(50) not null,author varchar(50), price int)");
	    ps.execute();
	    System.out.println("Table created successfully");
	}
	
	public void insertRow() throws Exception {
		System.out.println("Enter new book info id, title, author, price");
		Library l1=new Library(sc.nextInt(), sc.next(),sc.next(),sc.nextInt());
		Connection c=Connectivity.conn();
		PreparedStatement ps= c.prepareStatement("insert into Library(id, title, author, price) values (?,?,?,?)");
        ps.setInt(1, l1.getId());
        ps.setString(2, l1.getTitle());
        ps.setString(3, l1.getAuthor());
        ps.setInt(4, l1.getPrice());
        System.out.println("New data inserted...");
		ps.executeUpdate();
	}
	

	public void updateBookTitle() {
		System.out.println("Enter id where you want to update book title : ");
		int id=sc.nextInt();
		System.out.println("Enter new title : ");
		String title=sc.next();
		Connection c=Connectivity.conn();
		try {
			PreparedStatement ps=c.prepareStatement("update Library set title=? where id=?");
			ps.setString(1, title);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Title updated successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
		public void updateBookPrice() {
			System.out.println("Enter id where you want to update book price : ");
			int id=sc.nextInt();
			System.out.println("Enter new price : ");
			int price=sc.nextInt();
			Connection c=Connectivity.conn();
			try {
				PreparedStatement ps=c.prepareStatement("update Library set price=? where id=?");
				ps.setInt(1, price);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("Price updated successfully....");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			public void searchByTitle() {
		       
		        Connection c=Connectivity.conn();
		        Library l=new Library();
		        System.out.println("Enter title ");
		        String title=sc.nextLine();
		        try {
		             PreparedStatement ps = c.prepareStatement("SELECT * FROM library WHERE title LIKE ?");
		  
		            ps.setString(1, title);
		            ResultSet rs = ps.executeQuery();
		            while (rs.next()) {
		                System.out.println("Found: " + rs.getString("title"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
			public void read1Book() {
				System.out.println("Enter id you want to read particular Book : ");
				int id=sc.nextInt();
				Connection c=Connectivity.conn();
				try {
					PreparedStatement ps=c.prepareStatement("select * from Library where id =? ");
					ps.setInt(1, id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Library l=new Library();
						l.setId(rs.getInt(1));
						l.setTitle(rs.getString(2));
						l.setAuthor(rs.getString(3));
						l.setPrice(rs.getInt(4));
						System.out.println(l);
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
						Library l=new Library();
						l.setId(rs.getInt(1));
						l.setTitle(rs.getString(2));
						l.setAuthor(rs.getString(3));
						l.setPrice(rs.getInt(4));
						System.out.println(l);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public void deleteBookRow() {
				System.out.println("Enter id you want to delete : ");
				int id=sc.nextInt();
				Connection c=Connectivity.conn();
				try {
					PreparedStatement ps=c.prepareStatement("Delete from Library where id=?");
					ps.setInt(1, id);
					ps.executeUpdate();
					System.out.println("Book row deleted successfully....");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}
	
	

