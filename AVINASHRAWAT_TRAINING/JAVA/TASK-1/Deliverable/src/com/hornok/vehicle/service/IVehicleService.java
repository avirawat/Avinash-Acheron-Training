package com.hornok.vehicle.service;

import java.util.List;

import com.hornok.vehicle.exceptions.BrandNotFoundException;
import com.hornok.vehicle.exceptions.MilageNotFoundException;
import com.hornok.vehicle.exceptions.RentPriceNotFoundException;
import com.hornok.vehicle.exceptions.VehicleNotFoundException;
import com.hornok.vehicle.model.Vehicle;

public interface IVehicleService {
	// call by admin
	
	void addVehicle(Vehicle vehicle);

	boolean deleteVehicle(int vehicleNum) throws VehicleNotFoundException,Exception;

	Vehicle getVehicleById(int vehicleNum) throws VehicleNotFoundException,Exception;

	boolean updateVehicle(int vehicleNum, int rentPrice) throws VehicleNotFoundException,Exception;

	// called by driver

	List<Vehicle> getAllVehicles() throws Exception;

	List<Vehicle> getVehicleByBrand(String brand) throws BrandNotFoundException,Exception;

	List<Vehicle> getVehicleByrentPrice(int rentPrice) throws RentPriceNotFoundException,Exception;

	List<Vehicle> getVehicleByMilage(double milage) throws MilageNotFoundException,Exception;
}