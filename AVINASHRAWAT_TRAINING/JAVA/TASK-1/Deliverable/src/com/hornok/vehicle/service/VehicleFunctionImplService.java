package com.hornok.vehicle.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.hornok.vehicle.exceptions.VehicleNotFoundException;
import com.hornok.vehicle.model.Vehicle;
import com.hornok.vehicle.repository.IVehicleFunctionRepository;
import com.hornok.vehicle.repository.IVehicleRepository;
import com.hornok.vehicle.repository.VehicleFunctionImplRepository;
import com.hornok.vehicle.repository.VehicleImplRepository;


public class VehicleFunctionImplService implements IVehicleFunctionService{

	IVehicleFunctionRepository vehicleRepo=new VehicleFunctionImplRepository();
	public boolean updateVehicleStatus(int vehicleNum) throws VehicleNotFoundException,Exception {
		if(!vehicleRepo.updateVehicleStatus(vehicleNum)) {
			throw new VehicleNotFoundException("Vehicle Not Found");
		}
		return true;
	}
	@Override
	public List<Vehicle> getVehicleByFuelType(String fuelType) throws VehicleNotFoundException, Exception {
		List<Vehicle> allVehicles = vehicleRepo.getVehicleByFuelType(fuelType);
		if (allVehicles.isEmpty()) {
			throw new VehicleNotFoundException("--Sorry!--Vehicle is not available with this Fuel Type");
		}
		return allVehicles;
	}
	@Override
	public List<Vehicle> getVehicleBySeatCapacity(int seatCapacity) throws VehicleNotFoundException, Exception {
		List<Vehicle> allVehicles = vehicleRepo.getVehicleBySeatCapacity(seatCapacity);
		if (allVehicles.isEmpty()) {
			throw new VehicleNotFoundException("--Sorry!--Vehicle is not available with in this capacity");
		}
		return allVehicles;
	}
	@Override
	public boolean updateDriver(int driverId, int vehicleNum) {
		return vehicleRepo.updateDriver(driverId, vehicleNum);
	}

}
