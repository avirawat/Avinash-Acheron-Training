package com.hornok.vehicle.service;

import java.util.List;

import com.hornok.vehicle.exceptions.BrandNotFoundException;
import com.hornok.vehicle.exceptions.MilageNotFoundException;
import com.hornok.vehicle.exceptions.RentPriceNotFoundException;
import com.hornok.vehicle.exceptions.VehicleNotFoundException;
import com.hornok.vehicle.model.Vehicle;
import com.hornok.vehicle.repository.IVehicleRepository;
import com.hornok.vehicle.repository.VehicleImplRepository;


public class VehicleServiceImpl implements IVehicleService {

	IVehicleRepository vehicleRepo=new VehicleImplRepository();
	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleRepo.addVehicle(vehicle);
	}

	@Override
	public boolean deleteVehicle(int vehicleNum) throws VehicleNotFoundException, Exception {
		if (vehicleRepo.deleteVehicle(vehicleNum)) {
			return true;
		}
		throw new VehicleNotFoundException("Vehicle not available with this number!!!");
	}

	@Override
	public Vehicle getVehicleById(int vehicleNum) throws VehicleNotFoundException, Exception {

		Vehicle vehicleById = vehicleRepo.getVehicleById(vehicleNum);
		if (vehicleById == null) {
			throw new VehicleNotFoundException("Vehicle Number not available");
		}
		return vehicleById;
	}

	@Override
	public boolean updateVehicle(int vehicleNum, int rentPrice) throws VehicleNotFoundException, Exception {
		if (!vehicleRepo.updateVehicle(vehicleNum, rentPrice)) {
			throw new VehicleNotFoundException("Vehicle not available with this number!!!");
		}
		return true;
	}

	@Override
	public List<Vehicle> getAllVehicles() throws VehicleNotFoundException,Exception{
		List<Vehicle> allVehicles = vehicleRepo.getAllVehicles();
		if (allVehicles.isEmpty()) {
			throw new VehicleNotFoundException("TNo vehicle is available at this time");
		}
		return allVehicles;
	}

	@Override
	public List<Vehicle> getVehicleByBrand(String brand) throws BrandNotFoundException, Exception {
		List<Vehicle> vehicleByBrand = vehicleRepo.getVehicleByBrand(brand);
		if (vehicleByBrand.isEmpty()) {
			throw new BrandNotFoundException("This Brand is not available!!!");
		}
		return vehicleByBrand;
	}

	@Override
	public List<Vehicle> getVehicleByrentPrice(int rentPrice) throws RentPriceNotFoundException, Exception {
		List<Vehicle> vehicleByRentPrice = vehicleRepo.getVehicleByrentPrice(rentPrice);
		if (vehicleByRentPrice.isEmpty()) {
			throw new RentPriceNotFoundException("Vehicle Not available in this Price");
		}
		return vehicleByRentPrice;
	}

	@Override
	public List<Vehicle> getVehicleByMilage(double milage) throws MilageNotFoundException, Exception {
		List<Vehicle> vehicleByMilage = vehicleRepo.getVehicleByMilage(milage);
		if (vehicleByMilage.isEmpty()) {
			throw new MilageNotFoundException("Vehicle Not available in this milage");
		}
		return vehicleByMilage;
	}

}