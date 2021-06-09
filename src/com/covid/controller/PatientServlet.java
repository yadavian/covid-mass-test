package com.covid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.covid.dao.DoctorDAO;
import com.covid.dao.DoctorDAOImpl;
import com.covid.dao.PatientDAO;
import com.covid.dao.PatientDAOImpl;
import com.covid.model.Doctor;
import com.covid.model.Patient;

@WebServlet({ "/PatientServlet", "/PatientServlet/create", "/PatientServlet/edit/*", "/PatientServlet/delete/*", "/PatientServlet/update" })
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DoctorDAO doctorDAO = null;
	PatientDAO patientDAO = null;

	public PatientServlet() {
		super();
		patientDAO = new PatientDAOImpl();
		doctorDAO = new DoctorDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();

		switch (action) {
			case "/PatientServlet":
				List<Doctor> listDoctors = doctorDAO.getDoctors();
				request.setAttribute("listDoctors", listDoctors);	
				List<Patient> listPatient = patientDAO.getPatients();
				request.setAttribute("list", listPatient);
				dispatcher = request.getRequestDispatcher("view/patient/list-patients.jsp");
				dispatcher.forward(request, response);
				break;
			case "/PatientServlet/create":
				session.removeAttribute(action);
				session.setAttribute("action", "create");
				dispatcher = request.getRequestDispatcher("../view/patient/register.jsp");
				dispatcher.forward(request, response);
				break;
			case "/PatientServlet/edit":
				session.removeAttribute(action);
				int pt_id = Integer.parseInt(request.getParameter("pt_id"));
				System.out.println(pt_id);

				Patient getPatient = patientDAO.selectPatient(pt_id);
				request.setAttribute("getPatient", getPatient);
				System.out.println(patientDAO.selectPatient(1));
				session.setAttribute("action", "edit");
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("../view/patient/register.jsp");
				dispatcher1.forward(request, response);
				// response.sendRedirect("../view/patient/register.jsp");
				break;

			case "/PatientServlet/delete": 
				int pt_id1 = Integer.parseInt(request.getParameter("pt_id"));
				if (patientDAO.delete(pt_id1)) {
					request.setAttribute("message", "Deleted Successfully.");
					System.out.println("Deleted Successfully.");
					response.sendRedirect("../PatientServlet");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}
				break;
				
			default:
				break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));

		String address = request.getParameter("address");
		String blood_group = request.getParameter("blood_group");

		String disease = request.getParameter("disease");
		int sc_id = Integer.parseInt(request.getParameter("sc_id"));

		Patient pt = new Patient();

		
		pt.setUid(uid);
		pt.setName(name);
		pt.setPhone(phone);

		pt.setEmail(email);
		pt.setGender(gender);
		pt.setAge(age);

		pt.setAddress(address);
		pt.setBlood_group(blood_group);
		pt.setDisease(disease);

		pt.setSc_id(sc_id);


		
		System.out.println(action);
		switch (action) {
			case "/PatientServlet":
				break;
			case "/PatientServlet/create":

				System.out.println(pt);
				if (patientDAO.save(pt)) {
					request.setAttribute("message", "Inserted Successfully.");
					System.out.println("Inserted Successfully.");
					response.sendRedirect("../PatientServlet");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}
				break;
			case "/PatientServlet/update": 

				int pt_id = Integer.parseInt(request.getParameter("pt_id"));
				int dr_id = Integer.parseInt(request.getParameter("dr_id"));
				String result = request.getParameter("result");
				
				pt.setPt_id(pt_id);
				pt.setResult(result);
				pt.setDr_id(dr_id);
				if (patientDAO.update(pt)) {
					
					request.setAttribute("message", "Updated Successfully.");
					System.out.println("Updated Successfully.");
					response.sendRedirect("../PatientServlet");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}
				break;

			default:
				break;
		}
	}

}
