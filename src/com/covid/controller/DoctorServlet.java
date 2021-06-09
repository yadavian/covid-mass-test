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
import com.covid.model.Doctor;

@WebServlet({ "/DoctorServlet", "/DoctorServlet/create", "/DoctorServlet/login" })
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DoctorDAO doctorDAO = null;

	public DoctorServlet() {
		super();
		doctorDAO = new DoctorDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		switch (action) {
			case "/DoctorServlet":

				List<Doctor> listDoctors = doctorDAO.getDoctors();
				request.setAttribute("list", listDoctors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("view/doctor/list-doctors.jsp");
				dispatcher.forward(request, response);

				break;

			case "/DoctorServlet/login":

				dispatcher = request.getRequestDispatcher("../view/doctor/login.jsp");
				dispatcher.forward(request, response);

				break;

			case "/DoctorServlet/create":

				dispatcher = request.getRequestDispatcher("../view/doctor/register.jsp");
				dispatcher.forward(request, response);

				break;
			case "/DoctorServlet/edit":
				break;

			case "/DoctorServlet/delete":
				break;

			default:
				break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//String pt_id = request.getParameter("pt_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));

		String address = request.getParameter("address");
		String blood_group = request.getParameter("blood_group");
		int sc_id = Integer.parseInt(request.getParameter("sc_id"));

		String action = request.getServletPath();

		switch (action) {
			case "/DoctorServlet":
				break;
			case "/DoctorServlet/login":

				HttpSession session = request.getSession();

				Doctor drLogin = new Doctor();

				drLogin.setEmail(email);
				drLogin.setPassword(password);

				String status = doctorDAO.DoctorLogin(drLogin);

				if (status.equals("true")) {
					session.setAttribute("drEmail", drLogin.getEmail());
					System.out.println("IN SERVLET SET");
					response.sendRedirect("../DoctorServlet");
				} else if (status.equals("false")) {
					request.setAttribute("message", "Login Failed");
					System.out.println("Login Invalid");
					doGet(request, response);
				} else {
					request.setAttribute("message", "Login Error");
					System.out.println("Error");
					doGet(request, response);
				}

				break;
			case "/DoctorServlet/create":

				System.out.println("POST" + action);

				Doctor dr = new Doctor();

				dr.setPassword(password);
				dr.setName(name);
				dr.setPhone(phone);

				dr.setEmail(email);
				dr.setGender(gender);
				dr.setAge(age);

				dr.setAddress(address);
				dr.setBlood_group(blood_group);
				dr.setSc_id(sc_id);

				if (doctorDAO.save(dr)) {
					request.setAttribute("message", "Doctor Details Inserted Successfully.");
					response.sendRedirect("../DoctorServlet/login");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}

				break;
			case "/DoctorServlet/edit":
				break;
			case "/DoctorServlet/delete":
				break;
			default:
				break;
		}
	}

}
