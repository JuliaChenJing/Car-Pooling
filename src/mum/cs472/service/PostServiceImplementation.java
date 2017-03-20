package mum.cs472.service;

import java.util.List;

import mum.cs472.dao.PostDao;
import mum.cs472.dao.PostDaoImplementation;
import mum.cs472.model.Post;
import mum.cs472.model.User;

public class PostServiceImplementation implements PostService {

	PostDao postDao;
	public PostServiceImplementation() {
		postDao = new PostDaoImplementation();
	}
	@Override
	public void addPost(Post post) {
		postDao.addPost(post);
		
	}
	@Override
	public boolean updatePost(Post post) {
	
		return postDao.updatePost(post);
	}
	@Override
	public List<Post> getAllPosts() {
		return postDao.getAllPosts();
	}
	@Override
	public String getUsernameByPostId(int postId) {
		return postDao.getUsernameByPostId(postId);
	}

}
