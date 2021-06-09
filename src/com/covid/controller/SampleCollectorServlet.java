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

import com.covid.dao.SampleCollectorDAO;
import com.covid.dao.SampleCollectorDAOImpl;
import com.covid.model.SampleCollector;

@WebServlet({ "/SampleCollectorServlet", "/SampleCollectorServlet/create", "/SampleCollectorServlet/login" })
public class SampleCollectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SampleCollectorDAO sampleCollectorDAO = null;

	public SampleCollectorServlet() {
		super();
		sampleCollectorDAO = new SampleCollectorDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String action = request.getServletPath();
		System.out.println("SampleCollectorServlet"+action);
		switch (action) {
			case "/SampleCollectorServlet":

				List<SampleCollector> listSampleCollectors = sampleCollectorDAO.getSampleCollectors();
				request.setAttribute("list", listSampleCollectors);
				dispatcher = request.getRequestDispatcher("view/sample-collector/list-sample-collector.jsp");
				dispatcher.forward(request, response); 
				 
				break;

			case "/SampleCollectorServlet/login":

				dispatcher = request.getRequestDispatcher("../view/sample-collector/login.jsp");
				dispatcher.forward(request, response);

				break;

			case "/SampleCollectorServlet/create":

				dispatcher = request.getRequestDispatcher("../view/sample-collector/register.jsp");
				dispatcher.forward(request, response);

				break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

		String address = request.getParameter("address");
		String blood_group = request.getParameter("blood_group");
		String ho_id = request.getParameter("ho_id");

		String action = request.getServletPath();
		switch (action) {
			case "/SampleCollectorServlet":

				break;

			case "/SampleCollectorServlet/login":

				HttpSession session = request.getSession();

				SampleCollector scLogin = new SampleCollector();

				scLogin.setEmail(email);
				scLogin.setPassword(password);

				String status = sampleCollectorDAO.scLogin(scLogin);

				if (status.equals("true")) {
					session.setAttribute("scEmail", scLogin.getEmail());
					response.sendRedirect("../SampleCollectorServlet");
				} else if (status.equals("false")) {
					request.setAttribute("message", "Login Failed");
					doGet(request, response);
				} else {
					request.setAttribute("message", "Login Error");
					doGet(request, response);
				}

				break;

			case "/SampleCollectorServlet/create":

				SampleCollector sc = new SampleCollector();

				sc.setPassword(password);
				sc.setName(name);
				sc.setPhone(phone);

				sc.setEmail(email);
				sc.setGender(gender);
				sc.setAge(age);

				sc.setAddress(address);
				sc.setBlood_group(blood_group);
				sc.setHo_id(ho_id);

				if (sampleCollectorDAO.save(sc)) {
					request.setAttribute("message", "Inserted Successfully.");
					response.sendRedirect("../SampleCollectorServlet/login");
					// doGet(request, response);
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}

				break;
		}
	}

}
