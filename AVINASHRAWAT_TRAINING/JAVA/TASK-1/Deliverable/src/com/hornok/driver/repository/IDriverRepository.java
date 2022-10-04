package com.hornok.driver.repository;

import com.hornok.driver.model.*;

public interface IDriverRepository {
	
	void register(Driver driver);
	boolean logIn(int driverId,String password) throws Exception;
	public Driver rentedDriverDetails(int vehicleNum) throws Exception; 
	
}
