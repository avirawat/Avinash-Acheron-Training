package com.hornok.vehicle.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hornok.vehicle.model.Vehicle;


public class VehicleFunctionImplRepository implements IVehicleFunctionRepository{

	Connection connection = null;
	PreparedStatement statement = null;
	public boolean updateVehicleStatus(int vehicleNum) throws Exception {
		boolean value=false;
		connection = ModelDAO.openConnection();
		String sql = "update vehicle set status=? where vehicleNum=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,"Not Available");
			statement.setInt(2, vehicleNum);
			int result = statement.executeUpdate();
			if(result!=0) {
				value=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
			               throw e;
				}
			ModelDAO.closeConnection();
		}
		return value;
	}
	@Override
	public List<Vehicle> getVehicleByFuelType(String fuelType) throws Exception {
		boolean value = false;
		List<Vehicle> vehicleList = new ArrayList<>();

		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle where fuelType=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, fuelType);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				value = true;
				Vehicle vehicle1 = new Vehicle();
				vehicle1.setVehicleNum(rs.getInt(1));
				vehicle1.setBrand(rs.getString(2));
				vehicle1.setRentPrice(rs.getInt(3));
				vehicle1.setMilage(rs.getDouble(4));
				vehicle1.setStatus(rs.getString(5));
				vehicle1.setFuelType(rs.getString(6));
				vehicle1.setSeatCapacity(rs.getInt(7));
				vehicleList.add(vehicle1);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
			               throw e;
				}
			ModelDAO.closeConnection();
		}
		return vehicleList;

	}
	@Override
	public List<Vehicle> getVehicleBySeatCapacity(int seatCapacity) throws Exception {
		boolean value = false;
		List<Vehicle> vehicleList = new ArrayList<>();

		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle where seatCapacity>=? and seatCapacity<=12";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, seatCapacity);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				value = true;
				Vehicle vehicle1 = new Vehicle();
				vehicle1.setVehicleNum(rs.getInt(1));
				vehicle1.setBrand(rs.getString(2));
				vehicle1.setRentPrice(rs.getInt(3));
				vehicle1.setMilage(rs.getDouble(4));
				vehicle1.setStatus(rs.getString(5));
				vehicle1.setFuelType(rs.getString(6));
				vehicle1.setSeatCapacity(rs.getInt(7));
				vehicleList.add(vehicle1);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
			               throw e;
				}
			ModelDAO.closeConnection();
		}
		return vehicleList;
	}
	@Override
	public boolean updateDriver(int driverId, int vehicleNum) {
		boolean value=false;
		connection= ModelDAO.openConnection();
		String sql="update driver set vehicleNum=? where driverId=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,vehicleNum);
			statement.setInt(2,driverId);
			statement.execute();
			value=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
	
				}
			ModelDAO.closeConnection();
		}
		return value;
	}

}
