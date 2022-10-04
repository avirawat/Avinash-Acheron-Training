package com.shristi.atm;

public class Account {
	double balance;
	
	
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	void withdraw(int amount) {
		System.out.println("In ABC bank Withdrawing "+amount);
		//balance-=amount;
	}
	void deposit(int amount) {
		System.out.println("In ABC bank depositing "+amount);
		//balance+=amount;
	}
	double getBalance() {
		return balance;
	}
	
}
