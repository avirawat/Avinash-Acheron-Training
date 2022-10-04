package com.shristi.atm;

public class Current extends Account{

	public Current(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	void withdraw(int amount) {
		System.out.println("Current Account Withdarw");
		balance=balance-amount-100;
		super.withdraw(amount);
	}

	@Override
	void deposit(int amount) {
		System.out.println("Current Account deposit");
		balance=balance+amount;
		super.deposit(amount);
	}

}
