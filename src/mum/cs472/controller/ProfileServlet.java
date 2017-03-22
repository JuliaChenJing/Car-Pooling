package mum.cs472.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.model.Like;
import mum.cs472.model.Post;
import mum.cs472.model.User;
import mum.cs472.service.LikeService;
import mum.cs472.service.LikeServiceImplementation;
import mum.cs472.service.PostService;
import mum.cs472.service.PostServiceImplementation;
import mum.cs472.service.UserService;
import mum.cs472.service.UserServiceImplementation;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private PostService postService;
	private LikeService likeService;

	public ProfileServlet() {
		userService = new UserServiceImplementation();
		postService = new PostServiceImplementation();
		likeService = new LikeServiceImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	//shows all post in profile.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) request.getParameter("email");
		//update postCount for session
		session.setAttribute("postCount", new Integer(PostServlet.getPostCount()));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
		User user = userService.getUserByEmail(email);
		session.setAttribute("user", user);
		List<Post> postList = postService.getAllPosts();
		request.setAttribute("postList", postList);
		dispatcher.forward(request, response);
	}

}
