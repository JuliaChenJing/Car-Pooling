package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.service.LikeService;
import mum.cs472.service.LikeServiceImplementation;
import mum.cs472.model.Like;


@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	LikeService likeService;
	public LikeServlet() {
		likeService = new LikeServiceImplementation();
	}
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------inside like GET---");
		
		System.out.println((Integer.parseInt(request.getParameter("postId"))));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Like like = new Like();
		int postId = Integer.parseInt(request.getParameter("postId"));
		like.setUserId(Integer.parseInt(request.getParameter("userId")));
		like.setPostId(Integer.parseInt(request.getParameter("postId")));
		
		String likeId = (String)request.getParameter("likeId");

		if (likeId == null || likeId.isEmpty()) {
			HttpSession session = request.getSession();
			likeService.addLike(like);
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
			request.setAttribute("postId", postId);
			dispatcher.include(request, response);
		} else {
			like.setlikeId(Integer.parseInt(likeId));
	//			likeService.updateLike(like);
			}

	}

}
