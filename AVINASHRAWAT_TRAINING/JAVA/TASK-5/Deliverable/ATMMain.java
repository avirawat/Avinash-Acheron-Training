package com.shristi.atm;

import java.util.Scanner;

public class ATMMain {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Account type:-\n S as Savings Account\n C as Current Account \n E as terminate switch");
	String accType;
	do {
		accType=sc.nextLine();
		Account account;
		switch(accType) {
			case "S":
				account=new Savings(500);
				break;
			case "C":
			    account=new Current(500);
			    break;
			case "E":
				System.exit(0);
			default:
				account=new Savings(1000);
		}
		account.withdraw(300);
		System.out.println("Balance "+account.getBalance());
		account.deposit(500);
		System.out.println("Balance "+account.getBalance());
	}while(!accType.equals("E"));
	sc.close();
	}

}
