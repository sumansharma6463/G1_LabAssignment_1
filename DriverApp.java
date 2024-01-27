package com.greatlearning.app;

import java.util.Scanner;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmpCredentialsImpl;

public class DriverApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Employee First Name");
		String f = sc.next();
		System.out.println("Please enter Employee Last Name");
		String l = sc.next();
		Employee emp = new Employee(f, l);

		EmpCredentialsImpl cred = new EmpCredentialsImpl();

		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. HR");
		System.out.println("4. Legal");

		System.out.println("Please chose your Department");
		int choice = sc.nextInt();
		String genEmail = "";
		String genPassword = "";

		switch (choice) {

		case 1:
			genEmail = cred.generateEmailId(emp.getFname().toLowerCase(), emp.getLname().toLowerCase(), "tech");
			break;

		case 2:
			genEmail = cred.generateEmailId(emp.getFname().toLowerCase(), emp.getLname().toLowerCase(), "admin");
			break;

		case 3:
			genEmail = cred.generateEmailId(emp.getFname().toLowerCase(), emp.getLname().toLowerCase(), "hr");
			break;

		case 4:
			genEmail = cred.generateEmailId(emp.getFname().toLowerCase(), emp.getLname().toLowerCase(), "legal");
			break;
		default:
			System.out.println("Please enter valid input");
		}
		genPassword = cred.generatePassword();
		emp.setEmailid(genEmail);
		emp.setPassword(genPassword);

		cred.showDetails(emp);
		sc.close();
	}
	

}
