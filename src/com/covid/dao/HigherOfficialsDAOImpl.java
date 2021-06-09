package com.covid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.covid.model.HigherOfficials;
import com.covid.util.DBConnectionUtil;

public class HigherOfficialsDAOImpl implements HigherOfficialsDAO {
	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;

	@Override
	public boolean save(HigherOfficials ho) {
		boolean flag = false;
		String sql = "insert into higher_officials(password,name,phone,email,address)values('" + ho.getPassword()
				+ "','" + ho.getName() + "','" + ho.getPhone() + "','" + ho.getEmail() + "','" + ho.getAddress() + "')";
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
	public String HoLogin(HigherOfficials hoLogin) {
		String sql = "select * from higher_officials where email=? and password=?";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, hoLogin.getEmail());
			preparedStatement.setString(2, hoLogin.getPassword());
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
	public List<HigherOfficials> getHigherOfficials() {
		List<HigherOfficials> listHigherOfficials = null;
		HigherOfficials higherOfficials = null;

		try {
			listHigherOfficials = new ArrayList<HigherOfficials>();
			String sql = "select * from higher_officials";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				higherOfficials = new HigherOfficials();

				higherOfficials.setHo_id(resultSet.getInt("ho_id"));
				higherOfficials.setPassword(resultSet.getString("password"));
				higherOfficials.setName(resultSet.getString("name"));
				higherOfficials.setPhone(resultSet.getString("phone"));
				higherOfficials.setEmail(resultSet.getString("email"));
				higherOfficials.setAddress(resultSet.getString("address"));

				listHigherOfficials.add(higherOfficials);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listHigherOfficials;
	}

}
