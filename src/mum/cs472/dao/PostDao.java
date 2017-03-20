package mum.cs472.dao;

import java.util.List;

import mum.cs472.model.Post;
import mum.cs472.model.User;

public interface PostDao {

	void addPost(Post post);

	boolean updatePost(Post post);

	List<Post> getAllPosts();

	String getUsernameByPostId(int postId);

}
