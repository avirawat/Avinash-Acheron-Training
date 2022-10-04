package com.hornok.driver.service;

import com.hornok.driver.exceptions.DriverNotFoundException;
import com.hornok.driver.model.Driver;
import com.hornok.driver.repository.DriverImplRepository;
import com.hornok.driver.repository.IDriverRepository;

public class DriverServiceImpl implements IDriverService {

	IDriverRepository driverRepo = new DriverImplRepository();
	@Override
	public void register(Driver driver) {
		driverRepo.register(driver);
		
	}

	@Override
	public boolean logIn(int driverId, String password) throws DriverNotFoundException, Exception {
		if(!driverRepo.logIn(driverId, password)) {
			throw new DriverNotFoundException("Invalid Value");
		}
		return true;
	}

	@Override
	public Driver rentedDriverDetails(int vehicleNum) throws DriverNotFoundException, Exception {
		Driver rentedDriverDetails=driverRepo.rentedDriverDetails(vehicleNum);
		if(rentedDriverDetails==null) {
			throw new DriverNotFoundException("Wrong Vehicle Number");
		}
		return rentedDriverDetails;
	}

	

}
