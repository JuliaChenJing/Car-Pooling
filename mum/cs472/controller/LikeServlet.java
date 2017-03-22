package mum.cs472.controller;

import java.io.IOException;
import java.util.List;

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

		int loggedInUserId =  Integer.parseInt(request.getParameter("loggedInUserId"));
		Like like = new Like();
		int postId = Integer.parseInt(request.getParameter("postId"));
		like.setUserId(loggedInUserId);
		like.setPostId(Integer.parseInt(request.getParameter("postId")));
		

		String likeId = (String)request.getParameter("likeId");
		
		if (likeId == null || likeId.isEmpty()) {
			if(likeService.userValidToLike(like.getUserId(), like.getPostId())){
			likeService.addLike(like);
			}
			List<Like> likeList = likeService.getAllLikes(postId);
			
			StringBuilder sb = new StringBuilder();
			for(Like user: likeList){
				sb.append(user.getUsername()+", ");
			}
			
			String usernamesLikes = sb.toString();
			response.setContentType("text/plain");
			response.getWriter().write(usernamesLikes);
		}

	}

}
