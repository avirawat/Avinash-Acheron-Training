package com.hornok.vehicle.model;

public class Vehicle {
	private int vehicleNum;
	private String brand;
	private int rentPrice;
	private double milage;
	private String status;
	private String fuelType;
	private int seatCapacity;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int vehicleNum, String brand, int rentPrice, double milage, String status, String fuelType,
			int seatCapacity) {
		super();
		this.vehicleNum = vehicleNum;
		this.brand = brand;
		this.rentPrice = rentPrice;
		this.milage = milage;
		this.status = status;
		this.fuelType = fuelType;
		this.seatCapacity = seatCapacity;
	}

	public int getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(int vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public double getMilage() {
		return milage;
	}

	public void setMilage(double milage) {
		this.milage = milage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNum=" + vehicleNum + ", brand=" + brand + ", rentPrice=" + rentPrice + ", milage="
				+ milage + ", status=" + status + ", fuelType=" + fuelType + ", seatCapacity=" + seatCapacity + "]";
	}

}