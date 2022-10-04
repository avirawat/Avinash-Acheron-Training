package com.hornok.main;

import java.util.List;
import java.util.Scanner;

import com.hornok.driver.exceptions.DriverNotFoundException;
import com.hornok.driver.model.Driver;
import com.hornok.driver.service.DriverServiceImpl;
import com.hornok.driver.service.IDriverService;
import com.hornok.vehicle.exceptions.VehicleNotFoundException;
import com.hornok.vehicle.model.Vehicle;
import com.hornok.vehicle.repository.IVehicleFunctionRepository;
import com.hornok.vehicle.repository.VehicleFunctionImplRepository;
import com.hornok.vehicle.service.IVehicleFunctionService;
import com.hornok.vehicle.service.IVehicleService;
import com.hornok.vehicle.service.VehicleFunctionImplService;
import com.hornok.vehicle.service.VehicleServiceImpl;

public class DriverMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		IDriverService driver = new DriverServiceImpl();
		IVehicleService vehicleService = new VehicleServiceImpl();
		VehicleFunctionImplService vehicleRep=new VehicleFunctionImplService();
		
		System.out.println("Enter your choice.... \n 1 :- Admin \n 2:- Driver");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			// admin
			System.out.println("Enter your Id....");
			int id = sc.nextInt();
			System.out.println("Enter your password....");
			String password = sc.next();
			if (id == 123 && password.equals("admin")) {
				System.out.println("A for Add Vehicle \n D for Delete vehicle \n"
						+ "U for update vehicle \n G for Get Vehicle Details\n"
						+ "V for fetch Driver Details with vehicle number");
				char ch;
				do {
					ch = sc.next().charAt(0);
					switch (ch) {
					case 'A':
						System.out.println("Enter Vehicle Number...");
						int vehicleNum = sc.nextInt();
						System.out.println("Enter Vehcle Brand...");
						String brand = sc.next();
						System.out.println("Enter Rental Price...");
						int rentPrice = sc.nextInt();
						System.out.println("Enter milage");
						double milage = sc.nextDouble();
						System.out.println("Enter Vehicle status...");
						String status = sc.next();
						System.out.println("Enter vehicle fuel Type...");
						String fuelType = sc.next();
						System.out.println("Enter vehicle Seating Capacity ...");
						int seatCapacity = sc.nextInt();
						Vehicle vehicle = new Vehicle();
						vehicle.setVehicleNum(vehicleNum);
						vehicle.setBrand(brand);
						vehicle.setRentPrice(rentPrice);
						vehicle.setMilage(milage);
						vehicle.setStatus(status);
						vehicle.setFuelType(fuelType);
						vehicle.setSeatCapacity(seatCapacity);
						vehicleService.addVehicle(vehicle);
						break;
					case 'D':
						System.out.println("Enter vehicle number...");
						int vehicleNumber = sc.nextInt();
						try {
							if (vehicleService.deleteVehicle(vehicleNumber)) {
								System.out.println("vehicle Details Deleted");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 'U':
						System.out.println("Enter your Vehicle Number...");
						int VehicleNumber = sc.nextInt();
						System.out.println("Enter your rental price...");
						int rentalPrice = sc.nextInt();

						try {
							if (vehicleService.updateVehicle(VehicleNumber, rentalPrice)) {
								System.out.println("Vehicle updated...");
							}
						} catch (VehicleNotFoundException e) {
							System.out.println(e.getMessage());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 'G':
						System.out.println("Enter Vehicle Number...");
						int vehicleNo = sc.nextInt();
						try {
							Vehicle vehicleDetails = vehicleService.getVehicleById(vehicleNo);
							System.out.println(vehicleDetails);
						} catch (VehicleNotFoundException e) {
							System.out.println(e.getMessage());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 'V':
						System.out.println("Enter vehicle Number for checking Rented Driver Details");
						int vehicleNum1=sc.nextInt();
						try {
							
						System.out.println(driver.rentedDriverDetails(vehicleNum1));
						System.out.println(vehicleService.getVehicleById(vehicleNum1));
						} catch (DriverNotFoundException e) {
							System.out.println(e.getMessage());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 'E':
						System.exit(0);
					default:
						System.out.println("---wrong choice---");
					}
				} while (ch != '\0');
			} else {
				System.out.println("----You are not permitted---");
			}
			break;
		case 2:
			// Driver Login
			System.out.println(" (R):- for Registration \n (L):- for Login");
			char ch = sc.next().charAt(0);
			switch (ch) {
			case 'R':
				System.out.println("Enter Driver Id...");
				int driverId = sc.nextInt();
				System.out.println("Enter Driver name...");
				String driverName = sc.next();
				System.out.println("Enter Password...");
				String password1 = sc.next();
				System.out.println("Enter city...");
				String city = sc.next();
				Driver driverDetails = new Driver(driverId, driverName, password1, city);
				driverDetails.setDriverId(driverId);
				driverDetails.setDriverName(driverName);
				driverDetails.setPassword(password1);
				driverDetails.setCity(city);
				driver.register(driverDetails);
				break;
			case 'L':
				System.out.println("Enter driverId...");
				int driverID = sc.nextInt();
				System.out.println("Enter Password...");
				String DriverPassword = sc.next();
				boolean value=false;
				try {
					if (driver.logIn(driverID, DriverPassword)) {
						value=true;
	
						System.out.println("\nFilter\n 10:-Getting All vehicles details"
								+ "\n 11:- Get Vehicle By Brand \n 12:- Get vehicles By Rental price"
								+ "\n 13:-Get Vehicle By Milage \n 14:- Get Vehicle By Fuel Type"
								+ "\n 15:-Get Vehicle By seating Capacity \n16 Select Avaialble Vehicle number");

					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if(value) {
					int vehicleChoice;
					do {
					vehicleChoice = sc.nextInt();
					switch (vehicleChoice) {
					case 10:
						List<Vehicle> allVehicles=null;
						try {
							allVehicles = vehicleService.getAllVehicles();
							allVehicles.forEach(System.out::println);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 11:
						System.out.println("Enter Brand Name...");
						String brand = sc.next();
						List<Vehicle> vehiclesByBrand=null;
						try {
							vehiclesByBrand = vehicleService.getVehicleByBrand(brand);
							vehiclesByBrand.forEach(System.out::println);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						
						break;
					case 12:
						System.out.println("Enter Rental Price...");
						int rentalPrice = sc.nextInt();
						List<Vehicle> vehiclesByPrice=null;
						try {
							vehiclesByPrice = vehicleService.getVehicleByrentPrice(rentalPrice);
							vehiclesByPrice.forEach(System.out::println);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 13:
						System.out.println("Enter Milage");
						double milage = sc.nextDouble();
						List<Vehicle> vehiclesByMilage=null;
						try {
							vehiclesByMilage = vehicleService.getVehicleByMilage(milage);
							vehiclesByMilage.forEach(System.out::println);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 14:
						System.out.println("Enter fuel Type...");
						String fuelType = sc.next();
						List<Vehicle> vehiclesByFuelType=null;
						try {
							vehiclesByFuelType = vehicleRep.getVehicleByFuelType(fuelType);
							vehiclesByFuelType.forEach(System.out::println);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 15:
						System.out.println("Enter Seating Capacity(4-8)...");
						int seatCapacity = sc.nextInt();
						List<Vehicle> vehiclesBySeatCapacity=null;
						try {
							vehiclesBySeatCapacity = vehicleRep.getVehicleBySeatCapacity(seatCapacity);
							vehiclesBySeatCapacity.forEach(System.out::println);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 16:
						System.out.println("Enter selected Vehicle number");
						int selectNum=sc.nextInt();
						try {
							System.out.println(vehicleService.getVehicleById(selectNum));
							vehicleRep.updateVehicleStatus(selectNum);
							if(vehicleRep.updateDriver(driverID, selectNum)) {
								System.out.println("--------Happy Ride--------");
							}

							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 0:
						System.exit(0);
					default:
						System.out.println("wrong choice");
					}
					}while(vehicleChoice!=0);
				}
				else {
					System.out.println("You are not permitted");
				}
				break;
			default:
				System.out.println("wrong choice");
			}
			break;
		default:
			System.out.println("wrong choice for admin/driver");
		}
	}
}
