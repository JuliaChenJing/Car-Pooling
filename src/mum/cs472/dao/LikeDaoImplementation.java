package mum.cs472.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import mum.cs472.model.Like;
import mum.cs472.model.Post;
import mum.cs472.util.DBUtil;

public class LikeDaoImplementation implements LikeDao {
	
	private Connection conn;
	private PreparedStatement preparedStatement;
	public LikeDaoImplementation()
	{
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void updateLike(Like like) {
		
		like.setLiked(!like.isLiked());
	}


	
	@Override
	public void addLike(Like like) {
	
		try {
			String insertQuery = "INSERT INTO likes (userId,postId,datecreated,dateupdated)"
					+ "VALUES (?,?,?,?)";
			preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery);

			preparedStatement.setInt(1, like.getUserId());
			preparedStatement.setInt(2, like.getPostId());
			preparedStatement.setDate(3, (Date)like.getDateCreated());
			preparedStatement.setDate(4, (Date)like.getDateUpdated());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Like> getAllLikes(int postId) {
		List<Like> likeList = new ArrayList<Like>();
		try {
			String query = "SELECT * FROM likes WHERE postId = ?";
			preparedStatement = (PreparedStatement) conn.prepareStatement(query);
			preparedStatement.setInt(1, postId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
        	
            while (resultSet.next()) {
                Like like = new Like();
                like.setLikeId(resultSet.getInt("likeid"));
                like.setUserId(resultSet.getInt("userid"));
                like.setPostId(resultSet.getInt("postid"));
                like.setDateCreated(resultSet.getDate("datecreated"));
                like.setDateCreated(resultSet.getDate("datecreated"));
                
                likeList.add(like);
            }
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return likeList;
	}
}
