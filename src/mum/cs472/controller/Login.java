package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.dao.LoginDao;
import mum.cs472.dao.LoginDaoImplementation;
import mum.cs472.dao.UserDao;
import mum.cs472.dao.UserDaoImplementation;

@WebServlet("/loginServlet")
public class Login extends HttpServlet {
	private LoginDao loginDao;
	private UserDao userDao;

	public Login() {
		loginDao = new LoginDaoImplementation();
		userDao = new UserDaoImplementation();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		if (loginDao.validate(email, password)) {
			String fullname = userDao.findFullNameByEmail(email);
			session.setAttribute("username", fullname);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", true);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}

	}

}
