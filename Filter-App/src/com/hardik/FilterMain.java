package com.hardik;

import java.util.ArrayList;
import java.util.Scanner;

public class FilterMain {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location : ");
		String location = sc.nextLine();
		System.out.println("Enter the dept Name : ");
		String dept = sc.nextLine();
		
		System.out.println("Enter the gender : ");
		String gender = sc.nextLine();

		FilterLogic logic = new FilterLogic();
		ArrayList<Employ> empList = logic.employData(location, dept, gender);
		if (empList.isEmpty()) {
			System.out.println("NO rec found");
		} else {
			for (Employ emp : empList) {
				System.out.println(emp);
			}
		}

		sc.close();
	}
}
