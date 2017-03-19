package mum.cs472.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.dao.UserDao;
import mum.cs472.dao.UserDaoImplementation;
import mum.cs472.model.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUpServlet")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public SignUp() {
		userDao = new UserDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = new User();
		user.setFullname(request.getParameter("fullname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setGender(Integer.parseInt(request.getParameter("gender")));
		user.setState(request.getParameter("state"));
		user.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		user.setStreet(request.getParameter("street"));
		user.setCity(request.getParameter("city"));
		user.setBirthyear(Integer.parseInt(request.getParameter("birthyear")));

		String userId = request.getParameter("userId");

		if (userId == null || userId.isEmpty())
			userDao.addUser(user);
		else {
			user.setUserId(Integer.parseInt(userId));
			userDao.updateUser(user);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
		session.setAttribute("username", user.getFullname());
		dispatcher.forward(request, response);
	}
}
