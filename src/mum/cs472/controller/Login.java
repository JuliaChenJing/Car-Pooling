package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.model.User;

@WebServlet("/loginServlet")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userId");
		String password = request.getParameter("passId");
		
		HttpSession session = request.getSession();
		// set default user and password
		User user = new User("test", "123");
		System.out.println(user.getUsername()+" === "+username);
		System.out.println(user.getPassword()+" === "+password);
//		System.exit(0);
		if(user.getUsername().equals(username) && user.getPassword().equals(password)){
			session.setAttribute("username", username);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
			dispatcher.forward(request, response);
		}else{
		request.setAttribute("error", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
		}
	}

}
