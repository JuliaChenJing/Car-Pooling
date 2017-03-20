package mum.cs472.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import mum.cs472.model.Post;
import mum.cs472.model.User;
import mum.cs472.util.DBUtil;

public class PostDaoImplementation implements PostDao {
	private Connection conn;
	private PreparedStatement preparedStatement;

	public PostDaoImplementation() {
		conn = DBUtil.getConnection();
	}


	@Override
	public void addPost(Post post) {
	
		try {
			String insertQuery = "INSERT INTO posts (userid,post,posttype,datecreated,dateupdated,cityfrom, cityto)"
					+ "VALUES (?,?,?,?,?,?,?)";
			preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery);

			preparedStatement.setInt(1, post.getUserId());
			preparedStatement.setString(2, post.getPost());
			preparedStatement.setInt(3, post.getPostType());
			preparedStatement.setDate(4, (Date)post.getDateCreated());
			preparedStatement.setDate(5, (Date)post.getDateUpdated());
			preparedStatement.setString(6, post.getCityFrom());
			preparedStatement.setString(7, post.getCityTo());
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean updatePost(Post post) {
		
		return false;
	}


	@Override
	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<Post>();
        try {
        	String Query = "SELECT posts.*,users.fullname FROM posts RIGHT JOIN users ON posts.userid = users.userid;";
        	preparedStatement = (PreparedStatement) conn.prepareStatement(Query);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostId(resultSet.getInt("postid"));
                post.setUserId(resultSet.getInt("userid"));
                post.setPost(resultSet.getString("post"));
                post.setPostType(resultSet.getInt("posttype"));
                post.setDateCreated(resultSet.getDate("datecreated"));
                post.setDateUpdated(resultSet.getDate("dateupdated"));
                post.setCityFrom(resultSet.getString("cityfrom"));
                post.setCityTo(resultSet.getString("cityto"));
                post.setUsername(resultSet.getString("fullname"));
          
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
	}


	@Override
	public String getUsernameByPostId(int postId) {
		String username = "Not found for---"+postId;
		int userId = 0;
		 try {
	        	String Query = "select * from  posts where postid = ?";
	        	preparedStatement = (PreparedStatement) conn.prepareStatement(Query);
	        	preparedStatement.setInt(1, postId);
	        	
	        	ResultSet resultSet = preparedStatement.executeQuery();
	        	 while (resultSet.next()) {
	        		 userId = resultSet.getInt("userid");
	        	 }
	        	 String Query2 = "select * from  user where userid = ?";
		        	preparedStatement = (PreparedStatement) conn.prepareStatement(Query2);
		        	preparedStatement.setInt(1, userId);
		        	ResultSet resultSet2 = preparedStatement.executeQuery();
		        	 while (resultSet2.next()) {
		        		 username = resultSet.getString("fullname");
		        	 }
		        	
		 }catch (SQLException e) {
	            e.printStackTrace();
	        }
		return username;
	}

}
