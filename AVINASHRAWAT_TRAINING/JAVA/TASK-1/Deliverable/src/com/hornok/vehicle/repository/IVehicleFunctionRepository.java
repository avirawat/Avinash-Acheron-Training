package com.hornok.vehicle.repository;

import java.util.List;

import com.hornok.driver.model.Driver;
import com.hornok.vehicle.model.Vehicle;
public interface IVehicleFunctionRepository {
	
	boolean updateVehicleStatus(int vehicleNum) throws Exception;
	public List<Vehicle> getVehicleByFuelType(String fuelType) throws Exception;
	public List<Vehicle> getVehicleBySeatCapacity(int seatCapacity) throws Exception;
	boolean updateDriver(int driverId,int vehicleNum);
}
