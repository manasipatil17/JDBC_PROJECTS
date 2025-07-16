package com.controller;

import java.util.Scanner;

import com.services.Logic;

public class Main {
public static void main(String[] args) throws Exception {
	Logic l=new Logic();
//	l.createTable();
	Scanner sc=new Scanner(System.in);
	
	while(true) {
	System.out.println("Enter button 1-6");
	System.out.println("1 : Insert new Employee data");
	System.out.println("2 : Delete Employee data");
	System.out.println("3 : Update Employee name");
	System.out.println("4 : Update Employee city name");
	System.out.println("5 : Read particular Employee data");
	System.out.println("6 : Read all Employee data");
	System.out.println("Enter any other key to exit the app");
	
	int btn=sc.nextInt();
	switch(btn) {
	case 1: l.insertRow();
	System.out.println("-------------------------------------------");
	break;
	case 2: l.deleteEmployee();
	System.out.println("-------------------------------------------");
	break;
	case 3: l.updateEmpName();
	System.out.println("-------------------------------------------");
	break;
	case 4: l.updateEmpCity();
	System.out.println("-------------------------------------------");
	break;
	case 5: l.read1Emp();
	System.out.println("-------------------------------------------");
	break;
	case 6: l.ReadAll();
	System.out.println("-------------------------------------------");
	break;
	default:
		System.exit(8);
		
	}
	
	}		
    
}
}
