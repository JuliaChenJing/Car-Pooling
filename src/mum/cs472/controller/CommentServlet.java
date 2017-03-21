package mum.cs472.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/comments")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	//the action of COMMENTS BUTTON, show the previous comments to this post
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	//the action of REPLY BUTTON, show a window to let user input their reply to the post
			//when finish, show all the comments including the newest comment created by the user
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
