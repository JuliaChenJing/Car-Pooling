package mum.cs472.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.model.Post;
import mum.cs472.service.PostService;
import mum.cs472.service.PostServiceImplementation;

@WebServlet("/post")
public class PostServlet extends HttpServlet{

	PostService postService;
	public PostServlet() {
		postService = new PostServiceImplementation();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		post.setUserId(Integer.parseInt(request.getParameter("userIdHidden")));
		post.setPost(request.getParameter("post"));
		post.setPostType(Integer.parseInt(request.getParameter("postType")));
		post.setCityFrom(request.getParameter("cityFrom")+","+request.getParameter("stateFrom"));
		post.setCityTo(request.getParameter("cityTo")+","+request.getParameter("stateTo"));
		
		String postId = (String)request.getParameter("postId");

		if (postId == null || postId.isEmpty()) {
			HttpSession session = request.getSession();
			postService.addPost(post);
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
			session.setAttribute("email", request.getParameter("email"));
			request.setAttribute("postId", postId);
			request.setAttribute("action", "posts");
			dispatcher.forward(request, response);
		} else {
			post.setPostId(Integer.parseInt(postId));
			postService.updatePost(post);
		}
		
	}
}
