package com.doctor.main;

import java.util.Scanner;

import com.doctor.exception.DoctorNotFound;
import com.doctor.service.DoctorServiceImple;

public class DoctorMain {
public static void main(String[] args) {
	Scanner kb = new Scanner(System.in);
	DoctorServiceImple c = new DoctorServiceImple();
	Doctor[] doctorDetails = null;
	int choice = 0;
	do {
		System.out.println(
				"enter choice \n Press 1 to get all the deatils " +
				"\n Press 2 to get the doctor of a name " + 
				"\n Press 3 to get the doctor y Id" + 
				"\n Press 4 to get the specality doctor"+
				" \n Press 0 to exit");
		choice = kb.nextInt();
		try {
			switch (choice) {

			case 1:

				doctorDetails = c.getDetails();
				for (Doctor d : doctorDetails) {
					System.out.print(d.getDocName() + "  ");
					System.out.print(d.getDocId()+ "  ");
					System.out.print(d.getFee() + "  ");
					System.out.print(d.getSpeciality() + "  ");
					System.out.println();
					System.out.println("---------------------------------");

				}
				break;

			case 2:
				System.out.println("enter doctor name");
				kb.nextLine();
				String name = kb.nextLine();

				doctorDetails = c.getByName(name);
				for (Doctor d1 : doctorDetails) {
					if(d1!= null) {
					System.out.print(d1.getDocId() + "  ");
					System.out.print(d1.getDocName()+ "  ");
					System.out.print(d1.getFee() + "  ");
					System.out.print(d1.getSpeciality() + "  ");
					System.out.println();
					System.out.println("---------------------------------");
					}
					else
						break;
					
				}

				break;
			case 3:
				System.out.println("enter doctor ID");
				 int DoctorID = kb.nextInt();
				 
				Doctor d=c.getById(DoctorID);
				System.out.print(d.getDocName() + "  ");
				System.out.print(d.getDocId()+ "  ");
				System.out.print(d.getFee() + "  ");
				System.out.print(d.getSpeciality() + "  ");
				System.out.println();
				System.out.println("---------------------------------");
				break;
				
				
			case 4:
				System.out.println("enter doctor speclatily");
				String spec= kb.next();
				 
				Doctor [] specDetails=c.getBySpeciality(spec);
				for (Doctor doc : specDetails) {
					if(doc!= null) {
					System.out.print(doc.getDocName() + "  ");
					System.out.print(doc.getDocId()+ "  ");
					System.out.print(doc.getFee() + "  ");
					System.out.print(doc.getSpeciality() + "  ");
					System.out.println();
					System.out.println("---------------------------------");
					}
					else
						break;
					}
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("enter right choice");
				break;

			}
		}

		catch (DoctorNotFound e) {
			System.out.println(e.getMessage());
		}

	} while (choice != 0);
	
}
}
