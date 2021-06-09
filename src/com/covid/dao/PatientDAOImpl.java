package com.covid.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.covid.model.Patient;
import com.covid.util.DBConnectionUtil;

public class PatientDAOImpl implements PatientDAO {

	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement;
	PreparedStatement preparedStatement = null;

	@Override
	public boolean save(Patient pt) {

		System.out.print(pt);
		boolean flag = false;
		String sql = "insert into patient(uid,name,phone,email,gender,age,address,blood_group,disease,result,sc_id)values('"
				+ pt.getUid() + "','" + pt.getName() + "','" + pt.getPhone() + "','" + pt.getEmail() + "','"
				+ pt.getGender() + "','" + pt.getAge() + "','" + pt.getAddress() + "','" + pt.getBlood_group() + "','"
				+ pt.getDisease() + "','" + pt.getResult() + "','" + pt.getSc_id() + "')";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Patient> getPatients() {
		List<Patient> listPatients = null;
		Patient patient = null;

		try {
			listPatients = new ArrayList<Patient>();
			String sql = "select * from patient";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				patient = new Patient();

				patient.setPt_id(resultSet.getInt("pt_id"));
				patient.setUid(resultSet.getInt("uid"));
				patient.setName(resultSet.getString("name"));
				patient.setPhone(resultSet.getString("phone"));
				patient.setEmail(resultSet.getString("email"));
				
				patient.setGender(resultSet.getString("gender"));
				patient.setAge(resultSet.getInt("age"));
				patient.setAddress(resultSet.getString("address"));
				patient.setBlood_group(resultSet.getString("blood_group"));
				patient.setDisease(resultSet.getString("disease"));

				patient.setResult(resultSet.getString("result"));
				patient.setDr_id(resultSet.getInt("dr_id"));
				patient.setSc_id(resultSet.getInt("sc_id")); 

				listPatients.add(patient);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPatients;

	}

	@Override
	public Patient selectPatient(int pt_id) {
		Patient patient = null;
		String sql = "select * from patient where pt_id=?";
		try {
			patient = new Patient();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pt_id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				patient.setPt_id(resultSet.getInt("pt_id"));
				patient.setUid(resultSet.getInt("uid"));
				patient.setName(resultSet.getString("name"));
				patient.setPhone(resultSet.getString("phone"));
				patient.setEmail(resultSet.getString("email"));
				
				patient.setGender(resultSet.getString("gender"));
				patient.setAge(resultSet.getInt("age"));
				patient.setAddress(resultSet.getString("address"));
				patient.setBlood_group(resultSet.getString("blood_group"));
				patient.setDisease(resultSet.getString("disease"));

				patient.setResult(resultSet.getString("result"));
				patient.setDr_id(resultSet.getInt("dr_id"));
				patient.setSc_id(resultSet.getInt("sc_id")); 

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public boolean update(Patient pt) {

		//System.out.println("Patient DAO"+pt.getPt_id());
		
		boolean flag = false;
		
		String sql = "UPDATE `patient` SET `uid` = '"+pt.getUid()+"', `name` = '"+pt.getName()+"', `phone` = '"+pt.getPhone()+"', `email` = '"+pt.getEmail()+"', `gender` = '"+pt.getGender()+"', `age` = '"+pt.getAge()+"', `address` = '"+pt.getAddress()+"', `blood_group` = '"+pt.getBlood_group()+"', `disease` = '"+pt.getDisease()+"', `result` = '"+pt.getResult()+"', `dr_id` = '"+pt.getDr_id()+"', `sc_id` = '"+pt.getSc_id()+"'  WHERE `patient`.`pt_id` = '"+pt.getPt_id()+"'";
		
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int pt_id) {

		System.out.println("Patient DAO"+pt_id);
		
		boolean flag = false;
		
		String sql = "DELETE FROM `patient` WHERE `patient`.`pt_id` = '"+pt_id+"'";
		 
		
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
