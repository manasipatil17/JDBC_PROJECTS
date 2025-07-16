package com.controller;

import java.util.Scanner;

import com.services.Logic;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Logic l = new Logic();
		// l.createTable();

		while (true) {
			System.out.println("Enter 1-7 button");
			System.out.println("1 : Insert row ");
			System.out.println("2 : Read one row ");
			System.out.println("3 : Read all row ");
			System.out.println("4 : Update book title row ");
			System.out.println("5 : Update book price row ");
			System.out.println("6 : Search book by title row ");
			System.out.println("7 : delete row ");

			int btn = sc.nextInt();

			switch (btn) {
			case 1:
				l.insertRow();
				break;
			case 2:
				l.read1Book();
				break;
			case 3:
				l.ReadAll();
				break;
			case 4:
				l.updateBookTitle();
				break;
			case 5:
				l.updateBookPrice();
				break;
			case 6:
				l.searchByTitle();
				break;
			case 7:
				l.deleteBookRow();
				break;

			default:
				System.exit(8);
			}

		}
	}
}
