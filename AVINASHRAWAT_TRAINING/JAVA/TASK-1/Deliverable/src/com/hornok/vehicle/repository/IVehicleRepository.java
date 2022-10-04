package com.hornok.vehicle.repository;

import java.util.List;

import com.hornok.vehicle.model.Vehicle;

public interface IVehicleRepository {
	// call by admin
	
	void addVehicle(Vehicle vehicle);

	boolean deleteVehicle(int vehicleNum) throws Exception;

	Vehicle getVehicleById(int vehicleNum) throws Exception;

	boolean updateVehicle(int vehicleNum, int rentPrice) throws Exception;

	// called by driver

	List<Vehicle> getAllVehicles() throws Exception;

	List<Vehicle> getVehicleByBrand(String brand) throws Exception;

	List<Vehicle> getVehicleByrentPrice(int rentPrice) throws Exception;

	List<Vehicle> getVehicleByMilage(double milage) throws Exception;
}