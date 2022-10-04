package com.hornok.driver.repository;

import java.sql.*;
import com.hornok.vehicle.repository.*;
import com.hornok.driver.model.Driver;

public class DriverImplRepository implements IDriverRepository{

	Connection connection=null;
	PreparedStatement ps=null;
	
	public void register(Driver driver) {
		connection= ModelDAO.openConnection();
		String sql="insert into driver(driverId,driverName,password,city) values(?,?,?,?)";
		try {
			ps=connection.prepareStatement(sql);
			ps.setInt(1,driver.getDriverId());
			ps.setString(2,driver.getDriverName());
			ps.setString(3,driver.getPassword());
			ps.setString(4,driver.getCity());
		
			ps.execute();
			System.out.println("Registration Successfull");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ModelDAO.closeConnection();
		}
		
	}
	@Override
	public boolean logIn(int driverId, String password) throws Exception {
		boolean value=false;
		connection= ModelDAO.openConnection();
		String sql="select * from driver where driverId=? and password=?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setInt(1,driverId);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				value=true;
				System.out.println("**********Driver Details****************");
				System.out.println(" Driver Id: "+rs.getInt(1)+"\n Driver Name: "+
						rs.getString(2)+"\n Driver City: "+rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
			               throw e;
				}
			ModelDAO.closeConnection();
		}
		return value;
	}
	@Override
	public Driver rentedDriverDetails(int vehicleNum) throws Exception {
		boolean value=false;
		Driver driverDetails=new Driver();
		connection= ModelDAO.openConnection();
		String sql="select * from driver where vehicleNum=?";
		try {
			
			ps=connection.prepareStatement(sql);
			ps.setInt(1,vehicleNum);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				value=true;
				driverDetails.setDriverId(rs.getInt(1));
				driverDetails.setDriverName(rs.getString(2));
				driverDetails.setCity(rs.getString(4));
				
				System.out.println("**********Vehicle Number****************");
				System.out.println(rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
			               throw e;
				}
			ModelDAO.closeConnection();
		}
		return driverDetails;
	}

}
