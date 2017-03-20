package mum.cs472.model;

import java.util.Date;

public class Post {

	private int postId;
	private int userId;
	private String post;
	private int postType;
	private Date dateCreated;
	private Date dateUpdated;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String post, int postType, Date dateCreated, Date dateUpdated) {
		this.post = post;
		this.postType = postType;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", post=" + post + ", postType=" + postType
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	
	
}
