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

import mum.cs472.model.User;
import mum.cs472.service.UserService;
import mum.cs472.service.UserServiceImplementation;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	public ProfileServlet() {
		userService = new UserServiceImplementation();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//cookie :Name/value pair of strings sent as message header between client and server 	
//				Cookie[] cookies = request.getCookies();
//				int cnt = 0;
//				if (cookies != null) {
//					for (Cookie cookie : cookies) {
//						if (cookie.getName().equals("cookiePermanentState"))
//							System.out.format("cookiePermanentState: %s\r\n", cookie.getValue());
//						else if (cookie.getName().equals("cookieTemporaryState"))
//							System.out.format("cookieTemporaryState: %s\r\n", cookie.getValue());
//					}
//				}
			
				
				HttpSession session = request.getSession();
				String email = (String) request.getParameter("email");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
				User user = userService.getUserByEmail(email);
				session.setAttribute("user", user);
				dispatcher.forward(request, response);
	}

}
