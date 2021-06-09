package com.covid.dao;

import java.util.List;

import com.covid.model.HigherOfficials;

public interface HigherOfficialsDAO {
	boolean save(HigherOfficials ho);

	String HoLogin(HigherOfficials hoLogin);

	List<HigherOfficials> getHigherOfficials();
}
