package mum.cs472.service;

import java.util.List;

import mum.cs472.model.Like;

public interface LikeService {

	void addLike(Like like);

	boolean updateLike(Like like);

	List<Like> getAllLikes(int postId);

	boolean userValidToLike(int userId, int postId);
}
