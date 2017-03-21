package mum.cs472.service;

import java.util.List;
import mum.cs472.model.Post;

public interface PostService {

	void addPost(Post post);

	boolean updatePost(Post post);

	List<Post> getAllPosts();

	String getUsernameByPostId(int postId);

}
