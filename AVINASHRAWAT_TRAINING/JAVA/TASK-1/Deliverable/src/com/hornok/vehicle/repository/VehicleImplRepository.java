package com.hornok.vehicle.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hornok.vehicle.model.Vehicle;

public class VehicleImplRepository implements IVehicleRepository {

	Connection connection = null;
	PreparedStatement statement = null;

	@Override
	public void addVehicle(Vehicle vehicle) {
		connection=ModelDAO.openConnection();
		String sql ="insert into vehicle values(?,?,?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, vehicle.getVehicleNum());
			statement.setString(2, vehicle.getBrand());
			statement.setInt(3, vehicle.getRentPrice());
			statement.setDouble(4, vehicle.getMilage());
			statement.setString(5, vehicle.getStatus());
			statement.setString(6, vehicle.getFuelType());
			statement.setInt(7, vehicle.getSeatCapacity());



			statement.execute();
			System.out.println("Vehicle Added");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
			              
				}
			ModelDAO.closeConnection();
		}
	}

	@Override
	public boolean deleteVehicle(int vehicleNum) throws Exception {
		int value = 0;
		boolean result = true;
		connection = ModelDAO.openConnection();
		String sql = "delete from vehicle where vehicleNum=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, vehicleNum);
			value = statement.executeUpdate();
			if (value == 0) {
				result = false;
			}

		} catch (SQLException e) {
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
		return result;
	}

	@Override
	public Vehicle getVehicleById(int vehicleNum) throws Exception {
		//boolean value = false;
		Vehicle vehicle = null;
		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle where vehicleNum=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, vehicleNum);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				//value = true;
				vehicle= new Vehicle();
				vehicle.setVehicleNum(vehicleNum);
				vehicle.setBrand(rs.getString(2));
				vehicle.setRentPrice(rs.getInt(3));
				vehicle.setMilage(rs.getDouble(4));
				vehicle.setStatus(rs.getString(5));
				vehicle.setFuelType(rs.getString(6));
				vehicle.setSeatCapacity(rs.getInt(7));
			}

		} catch (SQLException e) {
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
		return vehicle;
	}

	@Override
	public boolean updateVehicle(int vehicleNum, int rentPrice) throws Exception {
		boolean value = false;
		connection = ModelDAO.openConnection();
		String sql = "update vehicle set rentPrice=? where vehicleNum=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rentPrice);
			statement.setInt(2, vehicleNum);
			int result = statement.executeUpdate();
			if(result!=0) {
				value=true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
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
	public List<Vehicle> getAllVehicles() throws Exception {
		List<Vehicle> vehicle = new ArrayList<>();

		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle";
		try {
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Vehicle vehicle1 = new Vehicle();
				vehicle1.setVehicleNum(rs.getInt(1));
				vehicle1.setBrand(rs.getString(2));
				vehicle1.setRentPrice(rs.getInt(3));
				vehicle1.setMilage(rs.getDouble(4));
				vehicle1.setStatus(rs.getString(5));
				vehicle1.setFuelType(rs.getString(6));
				vehicle1.setSeatCapacity(rs.getInt(7));
				vehicle.add(vehicle1);
			}

		} catch (SQLException e) {
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
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicleByBrand(String brand) throws Exception {
		boolean value = false;
		List<Vehicle> vehicleList = new ArrayList<>();

		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle where brand=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, brand);
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
	public List<Vehicle> getVehicleByrentPrice(int rentPrice) throws Exception {
		boolean value = false;
		List<Vehicle> vehicle = new ArrayList<>();

		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle where rentPrice<=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, rentPrice);
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
				vehicle.add(vehicle1);
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
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicleByMilage(double milage) throws Exception {
		boolean value = false;
		List<Vehicle> vehicle = new ArrayList<>();

		connection = ModelDAO.openConnection();
		String sql = "select * from vehicle where milage>=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, milage);
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
				vehicle.add(vehicle1);
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
		return vehicle;
	}

	

}