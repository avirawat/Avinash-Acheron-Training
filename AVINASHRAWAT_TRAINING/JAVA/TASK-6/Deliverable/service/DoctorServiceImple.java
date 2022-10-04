package com.doctor.service;

import com.doctor.exception.DoctorNotFound;
import com.doctor.main.Doctor;

public class DoctorServiceImple implements DoctorService {

	@Override
	public Doctor getById(int id) throws DoctorNotFound {
		// TODO Auto-generated method stub
		Doctor[] doc=getDetails();
		int flag=0;
		Doctor DoctorById=new Doctor();
		
		for(Doctor val:doc) {
			if(val.getDocId()==id) {
				flag=1;
				DoctorById=val;
			}
		}
		if(flag==1) {
			return DoctorById;
		}
		else {
			throw new DoctorNotFound("Plaese select coreect Id");
		}
	}

	@Override
	public Doctor[] getByName(String name) throws DoctorNotFound {
		Doctor[] doc=getDetails();
		int flag=0,index=0;
		Doctor[] DoctorByName=new Doctor[4];
		
		for(Doctor val:doc) {
			if(val.getDocName().equals(name)) {
				flag=1;
				DoctorByName[index++]=val;
			}
		}
		if(flag!=0) {
			return DoctorByName;
		}
		else {
			throw new DoctorNotFound("Plaese select coreect name");
		}
	}

	@Override
	public Doctor[] getAll() {
		return getDetails();
	}

	@Override
	public Doctor[] getBySpeciality(String spec) throws DoctorNotFound {
		Doctor[] doc=getDetails();
		int flag=0,index=0;
		Doctor[] DoctorByName=new Doctor[10];
		
		for(Doctor val:doc) {
			if(val.getSpeciality().equals(spec)) {
				flag=1;
				DoctorByName[index++]=val;
			}
		}
		if(flag!=0) {
			return DoctorByName;
		}
		else {
			throw new DoctorNotFound("Plaese select coreect spec");
		}
		}
	public Doctor[] getDetails() {
		Doctor[] doc=new Doctor[7];
		doc[0]=new Doctor("Dr mehta",123,"Seargon",1200);
		doc[1]=new Doctor("Dr Bhatra",122,"Cardio",1500);
		doc[2]=new Doctor("Dr Sharma",124,"Physician",1000);
		doc[3]=new Doctor("Dr Gupta",130,"Skin Specialist",1300);
		doc[4]=new Doctor("Dr shegil",145,"Gynacologist",1800);
		doc[5]=new Doctor("Dr rawat",150,"Neurologist",2000);
		doc[6]=new Doctor("Dr Arawal",150,"Skin",2000);
		 
		return doc;
	}

}
