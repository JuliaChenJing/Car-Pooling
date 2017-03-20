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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---Inside logout---");
		HttpSession session = request.getSession();
		request.setAttribute("logout", true);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		session.invalidate();
		dispatcher.include(request, response);
		
		Cookie c = new Cookie("cookiePermanentState", "cookiePermanentState");
		// set cookie age
		c.setMaxAge(0);
		response.addCookie(c);
		
	}
	
}

