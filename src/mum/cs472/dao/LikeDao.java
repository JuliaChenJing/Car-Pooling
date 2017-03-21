package mum.cs472.dao;

import java.util.List;

import mum.cs472.model.Like;

public interface LikeDao {

	void addLike(Like like);
	void updateLike(Like like);
	List<Like> getAllLikes(int postId);

}
