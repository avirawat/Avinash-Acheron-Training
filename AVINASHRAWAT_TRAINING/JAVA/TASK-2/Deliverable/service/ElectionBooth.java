package com.voterapp.service;

import com.voterapp.exceptions.LocalityNotFound;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.exceptions.NotEligibleException;
import com.voterapp.exceptions.UnderAgeException;

public class ElectionBooth {
	String []localities= {"ABC Nagar","XYZ Nagar","RK Nagar"};
	
	boolean checkAge(int age) throws UnderAgeException{
		if(age<18) {
			return false;
		}
		else {
			return true;
		}
		//throw new UnderAgeException("Age is below 18");
	}
	boolean locality(String localityName) throws LocalityNotFound{
		for(String str:localities) {
			if(str.equals(localityName))
				return true;
		}
		return false;
		//throw new LocalityNotFound("Address is wrong");
	}
	boolean checkVoterId(int vid) throws NoVoterIDException{
		if(vid>=1000 && vid<=9000) {
		return true;
		}
		else {
			return false;
			//throw new NoVoterIDException("Voter ID is wrong");
		}
	}
	
	public boolean checkEligibility(int age,String localityName,int vid)throws NotEligibleException {
		try {
			if(!checkAge(age)) {
				throw new UnderAgeException("Age is below 18");
			}
			if(!locality(localityName)) {
				throw new LocalityNotFound("Address is wrong");
			}
			if(!checkVoterId(vid)) {
				throw new NoVoterIDException("Voter ID is wrong");
			}
			return true;
		 }catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		}catch (LocalityNotFound e) {
			System.out.println(e.getMessage());
		}catch (NoVoterIDException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
}
