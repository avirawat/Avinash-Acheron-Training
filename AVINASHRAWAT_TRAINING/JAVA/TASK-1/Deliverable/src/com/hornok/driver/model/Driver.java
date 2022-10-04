package com.hornok.driver.model;

public class Driver {
   private int driverId;
   private String driverName;
   private String password;
   private String city;
   
	
	public Driver() {
	super();
	// TODO Auto-generated constructor stub
}
	public Driver(int driverId, String driverName, String password, String city) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.password = password;
		this.city = city;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", password=" + password + ", city="
				+ city + "]";
	}
}
