package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.dao.LoginDao;
import mum.cs472.dao.LoginDaoImplementation;
import mum.cs472.dao.UserDao;
import mum.cs472.dao.UserDaoImplementation;
import mum.cs472.model.User;
import mum.cs472.service.LoginService;
import mum.cs472.service.LoginServiceImplementation;
import mum.cs472.service.UserService;
import mum.cs472.service.UserServiceImplementation;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private LoginService loginService;
	
	public LoginServlet() {
		loginService = new LoginServiceImplementation();	
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Cookie c = new Cookie("cookiePermanentState", "cookiePermanentState");
		// set cookie age
		c.setMaxAge(3600);
		response.addCookie(c);

		if (loginService.validate(email, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", true);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}
	}

}
