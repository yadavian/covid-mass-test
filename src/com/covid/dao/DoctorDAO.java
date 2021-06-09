package com.covid.dao;

import java.util.List;

import com.covid.model.Doctor; 

public interface DoctorDAO {
	boolean save(Doctor dr);
	boolean update(Doctor dr);
	boolean delete(int dr_id);

	String DoctorLogin(Doctor drlogin);

	List<Doctor> getDoctors();
}
