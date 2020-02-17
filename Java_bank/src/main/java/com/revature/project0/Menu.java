package com.revature.project0;

import java.util.Scanner;

public class Menu {
	private String option;
	public static int returned;
	public Menu (){
		super ();	
	}
	Scanner console = new Scanner (System.in);
	
	public int DisplaymainMenu () {
		
		System.out.println("****************************************************************************");
		System.out.println("                          WELCOME TO JAVA BANK                              ");
		System.out.println(" ");
		System.out.println("            PlEASE SELECT THE FOLLOWING OPTION TO CONTINUE                  ");
		System.out.println(" ");
		System.out.println("                        C     -- CREATE NEW USER                            ");
		System.out.println(" ");
		System.out.println("                        S     -- SIGN IN                                    ");
		System.out.println(" ");
		System.out.println("                        E     -- EXIT                                       ");
		System.out.println("****************************************************************************");
		
		System.out.print("Enter Selected option: ");
		option = console.nextLine();
		
			switch (option) {
			case "C":
				if (option.equals("C")){
						returned = 1;
				}
			break;
			
			case "c":
				if (option.equals("c")){
					returned = 1;
				}
			break;
			
			case "S": 
				if (option.equals("S")) {
					returned = 2;
				}
			break;
			
			case "s": 
				if (option.equals("s")) {
					returned = 2;
				}
			break;
			
			case "E":
				if (option.equals("E")) {
					returned = 3;
				}
			break;
			
			case "e":
				if (option.equals("e")) {
					returned = 3;
				}
			break;
			
			default:
				System.out.println ("Invalid Entry !!!");
			break;
			}
				return returned;
	}
	
	public int DisplayUserMenu () {
		
		System.out.println("****************************************************************************");
		System.out.println("            PlEASE SELECT THE FOLLOWING OPTION TO CONTINUE                  ");
		System.out.println(" ");
		System.out.println("                         V     -- VIEW BALANCE                            	");
		System.out.println(" ");
		System.out.println("                         D     -- MAKE DEPOSIT                            	");
		System.out.println(" ");
		System.out.println("                         W     -- WITHDRAW                                  ");
		System.out.println(" ");
		System.out.println("                         N     -- NEW ACCOUNT                             	");
		System.out.println(" ");
		System.out.println("                         A     -- ADD OWNER                                 ");
		System.out.println(" ");
		System.out.println("                         C     -- CLOSE ACCOUNT                            	");
		System.out.println(" ");
		System.out.println("                         R     -- RETURN TO MAIN MENU                       ");
		System.out.println("****************************************************************************");
	
		System.out.print("Enter Selected option: ");
		option = console.nextLine();
		
		switch (option) {
		
		case "V":
			if (option.equals("V")) {
				returned = 4;
			}
		break;
		
		case "v":
			if (option.equals("v")) {
				returned = 4;
			}
		break;
		
		case "D":
			if (option.equals("D")) {
				returned = 5;
			}
		break;
		
		case "d":
			if (option.equals("d")) {
				returned = 5;
			}
		break;
		
		case "W":
			if (option.equals("W")) {
				returned = 6;
			}
		break;
		
		case "w":
			if (option.equals("w")) {
				returned = 6;
			}
		break;
		
		case "N":
			if (option.equals("N")) {
				returned = 7;
			}
		break;
		
		case "n":
			if (option.equals("n")) {
				returned = 7;
			}
		break;
		
		case "A":
			if (option.equals("A")) {
				returned = 8;
			}
		break;
		
		case "a":
			if (option.equals("a")) {
				returned = 8;
			}
		break;
		
		case "C":
			if (option.equals("C")) {
				returned = 9;
			}
		break;
		
		case "c":
			if (option.equals("c")) {
				returned = 9;
			}
		break;
		
		case "R":
			if (option.equals("R")) {
				returned = 10;
			}
		break;
		
		case "r":
			if (option.equals("r")) {
				returned = 10;
			}
		break;
		default:
			System.out.println ("Invalid Entry !!!");
		break;
		}
			return returned;

	}
	
	
}
