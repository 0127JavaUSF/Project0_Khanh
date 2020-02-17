package com.revature.project0;

import java.util.Scanner;

public class Java_Bank {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner console = new Scanner(System.in);
		String userName ;
		String passWord;
		String setAccountType = " ";
		int choice;
		Menu me = new Menu ();
		//User user = new User ();
		CreateUser cruser = new CreateUser ();
		UserValidation uv = new UserValidation ();
		NewAccount na = new NewAccount ();
		AddJointOwnerToAccount ao = new AddJointOwnerToAccount ();
		CloseAccount clacct = new CloseAccount ();
		AccountActivity aa= new AccountActivity ();
		me.DisplaymainMenu();
		
		
		for (int i = 1; i > 0; i++)	{
			
			if (Menu.returned == 1) {
				System.out.print("Enter New Username: ");
				userName = console.nextLine();
				//user.setUserName(userName);
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
				//user.setUserName(userName);
				System.out.print("Enter New Password: ");
				passWord = console.nextLine();
				//user.setUserName(userName);
				//user.setPassWord(passWord);
				uv.checkValidation(userName, passWord);
				if (UserValidation.validation == true) {
					System.out.println ("Log In Successful");
					me.DisplayUserMenu();
				 
			
					if (Menu.returned == 3) {
						System.out.println ("GOOD BYE");
					}
				
					if (Menu.returned == 4);{
						aa.viewBalance(userName);
					}
					
					if(Menu.returned == 5) {
						aa.deposit(userName);
						break;
					}
					
					if(Menu.returned == 6) {
						aa.withdraw(userName);
						break;
					}
					
					if(Menu.returned == 7) {
						
						System.out.println("Please select account type: 1 -- Checking  ||  2 -- Saving");
						choice = console.nextInt();
						if (choice == 1) {
							setAccountType = "CHKG";
						}
						else if (choice == 2) {
							setAccountType = "SVNG";
						}
						na.addAccount(setAccountType, userName);
					}
					
					if(Menu.returned == 8) {
						ao.addOwner(userName, passWord);
					}
					
					if(Menu.returned == 9) {
						clacct.closeAccount(userName, passWord);
					}
					
				}
				else
					System.out.println ("Log In FAIL !!!"); 
					break;
			}
			
			if (Menu.returned == 10) {
				me.DisplaymainMenu();
			}
			
			if (Menu.returned == 3) {
				System.out.println ("GOOD BYE");
				
			}
			
			else 
				System.out.println ("INVALID ENTRY");
				me.DisplayUserMenu();
			
		}
			console.close();
	}
}
			

