package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.cs472.service.PostService;
import mum.cs472.service.PostServiceImplementation;

@WebServlet("/notification")
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
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
}
