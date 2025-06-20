package com.hardik;

import java.sql.ResultSet;
import java.util.Scanner;

public class Register {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		try {

			UserDAO dao = new UserDAO();

			System.out.println("what do you want login for login press 1  or register  press 2 ");
			int no = sc.nextInt();
			sc.nextLine();

			if (no == 1) {
				Login.logUser(dao);

			} else {

				System.out.println("enter your name ");
				String name = sc.nextLine();

				System.out.println("enter your  course");
				String course = sc.nextLine();

				System.out.println("enter your address ");
				String address = sc.nextLine();

				System.out.println("enter your number ");
				Long number = sc.nextLong();
				sc.nextLine();

				System.out.println("enter your gmail");
				String gmail = sc.nextLine();

				System.out.println("enter your pass");
				String pass = sc.nextLine();

				User user = new User(name, course, address, number, gmail, pass);

				if (dao.checkIsRegister(gmail) != null) {
					System.out.println("User already exist ");
				} else {
					int count = dao.registerUser(user);
					System.out.println("row effected : " + count);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}
}
