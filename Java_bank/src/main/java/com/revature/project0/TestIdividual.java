package com.revature.project0;

import java.util.Scanner;

public class TestIdividual {

	public static void main(String[] args){
		Scanner console = new Scanner (System.in);
		String userName;
		//String passWord;
		int choice;
		String setAccountType = " ";
		NewAccount na = new NewAccount();
		//AddJointOwnerToAccount  ao = new AddJointOwnerToAccount ();
		userName = console.nextLine();
		//passWord = console.nextLine();
		choice = console.nextInt();
		try {
		if (choice == 1) {
			setAccountType = "CHKG";
		}else if (choice == 2) {
			setAccountType = "SVNG";
		}
		na.addAccount(setAccountType,  userName);
		console.close ();
		} catch (ClassNotFoundException c){
			c.printStackTrace();
		}
		/*try {
			ao.addOwner(userName, passWord);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
