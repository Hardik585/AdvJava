package com.hardik;

import java.util.Scanner;

public class Login {

	public static void logUser(UserDAO dao) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your gmail");
		String gmail = sc.nextLine();

		System.out.println("enter your pass");
		String pass = sc.nextLine();

		try {
			User user = dao.checkIsRegister(gmail);
			if(user == null){
				System.out.println("not valid credential or user not exist ");
				return ; 
			} 
			if(user.getPass().equals(pass)) {
					System.out.println("successfully login ");	
			}else {
				System.out.println("not valid password or credential ");
			}
			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			sc.close();
		}
	}
}
