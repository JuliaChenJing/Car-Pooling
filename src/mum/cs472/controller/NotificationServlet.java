package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.service.PostService;
import mum.cs472.service.PostServiceImplementation;

@WebServlet("/")
public class NotificationServlet extends HttpServlet {
	/**
	 * 
	 */
	PostService postService;
	
	public NotificationServlet() {
	postService = new PostServiceImplementation();
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer sessionPostCount=(Integer)session.getAttribute("postCount");
		int ret=0;
		if(sessionPostCount!=null)
			ret=PostServlet.getPostCount()-sessionPostCount;
		response.setContentType("application/text");
		response.getWriter().print(ret);;
	}
	
}
