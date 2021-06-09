package com.covid.dao;

import java.util.List;

import com.covid.model.Patient;

public interface PatientDAO {
	boolean save(Patient pt);
	boolean update(Patient pt);
	boolean delete(int pt_id);

	List<Patient> getPatients();

	Patient selectPatient(int pt_id);
}
