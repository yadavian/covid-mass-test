package com.covid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.covid.model.SampleCollector;
import com.covid.util.DBConnectionUtil;

public class SampleCollectorDAOImpl implements SampleCollectorDAO {
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement;
	PreparedStatement preparedStatement = null;

	@Override
	public boolean save(SampleCollector sc) {
		boolean flag = false;
		String sql = "insert into sample_collector(password,name,phone,email,gender,age,address,blood_group,ho_id)values('"
				+ sc.getPassword() + "','" + sc.getName() + "','" + sc.getPhone() + "','" + sc.getEmail() + "','"
				+ sc.getGender() + "','" + sc.getAge() + "','" + sc.getAddress() + "','" + sc.getBlood_group() + "','"
				+ sc.getHo_id() + "')";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String scLogin(SampleCollector scLogin) {
		String sql = "select * from sample_collector where email=? and password=?";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, scLogin.getEmail());
			preparedStatement.setString(2, scLogin.getPassword());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return "true";
			} else {
				return "false";
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "error";
	}

	@Override
	public List<SampleCollector> getSampleCollectors() {
		List<SampleCollector> listSampleCollectors = null;
		SampleCollector sampleCollector = null;

		try {
			listSampleCollectors = new ArrayList<SampleCollector>();
			String sql = "select * from sample_collector";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				sampleCollector = new SampleCollector();

				sampleCollector.setPassword(resultSet.getString("password"));
				sampleCollector.setName(resultSet.getString("name"));
				sampleCollector.setPhone(resultSet.getString("phone"));
				sampleCollector.setEmail(resultSet.getString("email"));
				sampleCollector.setGender(resultSet.getString("gender"));

				sampleCollector.setAge(resultSet.getString("age"));
				sampleCollector.setAddress(resultSet.getString("address"));
				sampleCollector.setBlood_group(resultSet.getString("blood_group"));

				listSampleCollectors.add(sampleCollector);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listSampleCollectors;
	}

}
