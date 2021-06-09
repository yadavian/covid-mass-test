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

import com.covid.dao.HigherOfficialsDAO;
import com.covid.dao.HigherOfficialsDAOImpl;
import com.covid.model.HigherOfficials;

@WebServlet({ "/HighOfficialsServlet", "/HighOfficialsServlet/create", "/HighOfficialsServlet/login" })
public class HighOfficialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HigherOfficialsDAO higherOfficialsDAO = null;

	public HighOfficialsServlet() {
		super();
		higherOfficialsDAO = new HigherOfficialsDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		switch (action) {
			case "/HighOfficialsServlet":

				List<HigherOfficials> listHigherOfficials = higherOfficialsDAO.getHigherOfficials();
				request.setAttribute("list", listHigherOfficials);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/view/higher-officials/list-higher-officials.jsp");
				dispatcher.forward(request, response);

				break;

			case "/HighOfficialsServlet/login":

				dispatcher = request.getRequestDispatcher("../view/higher-officials/login.jsp");
				dispatcher.forward(request, response);

				break;

			case "/HighOfficialsServlet/create":

				dispatcher = request.getRequestDispatcher("../view/higher-officials/register.jsp");
				dispatcher.forward(request, response);

				break;
			case "/HighOfficialsServlet/edit":
				break;

			case "/HighOfficialsServlet/delete":
				break;

			default:
				break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		String action = request.getServletPath();
		System.out.println("Login Success" + action);

		switch (action) {
			case "/HighOfficialsServlet":

				break;

			case "/HighOfficialsServlet/login":

				System.out.println("Login Success" + action);
				HttpSession session = request.getSession();

				HigherOfficials hoLogin = new HigherOfficials();

				hoLogin.setEmail(email);
				hoLogin.setPassword(password);

				String status = higherOfficialsDAO.HoLogin(hoLogin);

				if (status.equals("true")) {
					// request.setAttribute("message", "Login Success");
					session.setAttribute("hoEmail", hoLogin.getEmail());
					response.sendRedirect("../HighOfficialsServlet");
					System.out.println("Login Success");
					// doGet(request, response);
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

			case "/HighOfficialsServlet/create":

				HigherOfficials ho = new HigherOfficials();

				ho.setPassword(password);
				ho.setName(name);
				ho.setPhone(phone);
				ho.setEmail(email);
				ho.setAddress(address);

				if (higherOfficialsDAO.save(ho)) {
					request.setAttribute("message", "Inserted Successfully.");
					response.sendRedirect("../HighOfficialsServlet/login");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}

				break;
			case "/HighOfficialsServlet/edit":
				break;

			case "/HighOfficialsServlet/delete":
				break;

			default:
				break;

		}
	}

}
