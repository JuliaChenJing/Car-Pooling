package mum.cs472.service;


import java.util.List;

import mum.cs472.dao.LikeDao;
import mum.cs472.dao.LikeDaoImplementation;
import mum.cs472.model.Like;


public class LikeServiceImplementation implements LikeService {

	
	LikeDao likeDao;
	public LikeServiceImplementation() {
		likeDao = new LikeDaoImplementation();
	}
	
	@Override
	public void addLike(Like like) {
		likeDao.addLike(like);
		
	}
	
	@Override
	public boolean updateLike(Like like) {
		
		return false;
	}

	@Override
	public List<Like> getAllLikes(int postId) {
		return likeDao.getAllLikes(postId);
	}
}
