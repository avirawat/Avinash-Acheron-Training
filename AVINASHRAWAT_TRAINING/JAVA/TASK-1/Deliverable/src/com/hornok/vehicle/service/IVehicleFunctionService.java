package com.hornok.vehicle.service;

import java.util.List;

import com.hornok.vehicle.exceptions.VehicleNotFoundException;
import com.hornok.vehicle.model.Vehicle;

public interface IVehicleFunctionService {
	
	boolean updateVehicleStatus(int vehicleNum) throws VehicleNotFoundException,Exception;
	public List<Vehicle> getVehicleByFuelType(String fuelType) throws VehicleNotFoundException,Exception;
	public List<Vehicle> getVehicleBySeatCapacity(int seatCapacity) throws VehicleNotFoundException,Exception;
	boolean updateDriver(int driverId,int vehicleNum);
}
