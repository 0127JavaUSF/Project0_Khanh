package com.revature.project0;

import java.util.Scanner;

public class Java_Bank {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner console = new Scanner(System.in);
		String userName ;
		String passWord;
		Menu me = new Menu ();
		User user = new User ();
		CreateUser cruser = new CreateUser ();
		UserValidation uv = new UserValidation ();
		me.DisplaymainMenu();
		
		
		for (int i = 1; i > 0; i++)	{
			
			if (Menu.returned == 1) {
				System.out.print("Enter New Username: ");
				userName = console.nextLine();
				user.setUserName(userName);
				System.out.print("Enter New Password: ");
				passWord = console.nextLine();
				//user.setUserName(userName);
				//user.setPassWord(passWord);
				cruser.addUser(userName, passWord);
				break;
			}
			
			if (Menu.returned == 2) {
				System.out.print("Enter New Username: ");
				userName = console.nextLine();
				user.setUserName(userName);
				System.out.print("Enter New Password: ");
				passWord = console.nextLine();
				//user.setUserName(userName);
				//user.setPassWord(passWord);
				uv.checkValidation(userName, passWord);
				if (UserValidation.validation == true) {
					System.out.println ("Log In Successful");
					me.DisplayUserMenu();
				}else
					System.out.println ("Log In FAIL !!!"); 
					me.DisplaymainMenu();
					if (Menu.returned == 3) {
						System.out.println ("GOOD BYE");}
					break;
			}
			
			if (Menu.returned == 7) {
				me.DisplaymainMenu();
			}
			
			if (Menu.returned == 3) {
				System.out.println ("GOOD BYE");
				break;
			}
			
			else 
				System.out.println ("INVALID ENTRY");
				me.DisplayUserMenu();
			
		}
		console.close();
	}

}
