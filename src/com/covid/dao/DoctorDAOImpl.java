package com.covid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.covid.model.Doctor;
import com.covid.util.DBConnectionUtil;

public class DoctorDAOImpl implements DoctorDAO {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Statement statement;

	@Override
	public boolean save(Doctor dr) {
		boolean flag = false;
		String sql = "insert into doctor(password,name,phone,email,gender,age,address,blood_group,sc_id)values('"
				+ dr.getPassword() + "','" + dr.getName() + "','" + dr.getPhone() + "','" + dr.getEmail() + "','"
				+ dr.getGender() + "','" + dr.getAge() + "','" + dr.getAddress() + "','" + dr.getBlood_group() + "','"
				+ dr.getSc_id() + "')";
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
	public String DoctorLogin(Doctor drlogin) {
		String sql = "select * from doctor where email=? and password=?";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, drlogin.getEmail());
			preparedStatement.setString(2, drlogin.getPassword());
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
	public List<Doctor> getDoctors() {
		List<Doctor> listDoctors = null;
		Doctor doctor = null;

		try {
			listDoctors = new ArrayList<Doctor>();
			String sql = "select * from doctor";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				doctor = new Doctor();

				doctor.setPassword(resultSet.getString("password"));
				doctor.setName(resultSet.getString("name"));
				doctor.setPhone(resultSet.getString("phone"));
				doctor.setEmail(resultSet.getString("email"));
				
				doctor.setGender(resultSet.getString("gender"));
				doctor.setAge(resultSet.getInt("age"));
				doctor.setAddress(resultSet.getString("address"));
				doctor.setBlood_group(resultSet.getString("blood_group"));  

				listDoctors.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listDoctors;

	}

	@Override
	public boolean update(Doctor dr) {
		boolean flag = false;
		
		String sql = "UPDATE `doctor` SET `password` = '"+dr.getPassword()+"', `name` = '"+dr.getName()+"', `phone` = '"+dr.getPhone()+"', `email` = '"+dr.getEmail()+"', `gender` = '"+dr.getGender()+"', `age` = '"+dr.getAge()+"', `address` = '"+dr.getAddress()+"', `blood_group` = '"+dr.getBlood_group()+"', `sc_id` = '"+dr.getSc_id()+"'  WHERE `patient`.`dr_id` = '"+dr.getDr_id()+"'";
		 
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
	public boolean delete(int dr_id) {
		boolean flag = false;

		String sql = "DELETE FROM `doctor` WHERE `patient`.`pt_id` = '"+dr_id+"'";
		
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

}
