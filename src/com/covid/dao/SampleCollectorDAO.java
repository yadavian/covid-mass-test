package com.covid.dao;

import java.util.List;

import com.covid.model.SampleCollector;

public interface SampleCollectorDAO {
	boolean save(SampleCollector sc);

	String scLogin(SampleCollector scLogin);

	List<SampleCollector> getSampleCollectors();
}
