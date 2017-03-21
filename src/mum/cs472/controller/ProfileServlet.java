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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) request.getParameter("email");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
		User user = userService.getUserByEmail(email);
		session.setAttribute("user", user);

		// if (request.getAttribute("action") != null) {
		// String action = (String)request.getAttribute("action");
		// if (action.equals("posts")) {
		List<Post> postList = postService.getAllPosts();
		request.setAttribute("postList", postList);
		// request.setAttribute("fullNameOfUser",
		// postService.getUsernameByPostId(postId));
		// }
		// }
		
		dispatcher.forward(request, response);
	}

}
