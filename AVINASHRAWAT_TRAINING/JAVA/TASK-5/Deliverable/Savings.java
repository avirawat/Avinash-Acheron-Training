package com.shristi.atm;

public class Savings extends Account {

	public Savings(double balance) {
		super(balance);
		}

	@Override
	void withdraw(int amount) {
		System.out.println("Saving Withdarw");
		balance=balance-amount;
		super.withdraw(amount);
	}

	@Override
	void deposit(int amount) {
		System.out.println("Saving deposit");
		balance=balance+amount+100;
		super.deposit(amount);
	}
	
}
