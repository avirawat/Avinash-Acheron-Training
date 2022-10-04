package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exceptions.NotEligibleException;
import com.voterapp.service.ElectionBooth;

public class VoterMain {

	public static void main(String[] args) throws NotEligibleException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ElectionBooth booth=new ElectionBooth();
		System.out.print("Enter your Age");
		int age=sc.nextInt();
		System.out.print("Enter your ID");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter your Address");
		String address=sc.nextLine();
		Voter v= new Voter(age,id,address);
		boolean ceck=booth.checkEligibility(age,address,id);
		if(ceck) {
			System.out.print("vote casted");
			System.out.print(v.toString());
		}
		
		
	}

}
