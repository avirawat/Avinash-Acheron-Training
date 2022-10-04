package com.hornok.driver.service;

import com.hornok.driver.exceptions.DriverNotFoundException;
import com.hornok.driver.model.Driver;

public interface IDriverService {
	
	void register(Driver driver);
	boolean logIn(int driverId,String password) throws DriverNotFoundException,Exception;
	public Driver rentedDriverDetails(int vehicleNum) throws DriverNotFoundException,Exception;
}
