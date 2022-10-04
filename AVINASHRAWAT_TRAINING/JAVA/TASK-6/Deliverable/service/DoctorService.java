package com.doctor.service;

import com.doctor.exception.DoctorNotFound;
import com.doctor.main.Doctor;

public interface DoctorService {
	Doctor getById(int id) throws DoctorNotFound;
	Doctor[] getByName(String name) throws DoctorNotFound;
	Doctor[] getAll();
	Doctor[] getBySpeciality(String spec) throws DoctorNotFound;
	
}
