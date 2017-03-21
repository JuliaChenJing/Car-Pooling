package mum.cs472.model;

import java.util.Date;

public class Like {
	private int likeId;
	private int userId;
	private int postId;
	private Date dateCreated;
	private Date dateUpdated;
	boolean isLiked;
	
	public Like() {
	}

	public Like(Date dateCreated, Date dateUpdated) {
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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
		return "Like [likeId=" + likeId + ", userId=" + userId + ", postId=" + postId + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}

	public void setlikeId(int likeID) {
		// TODO Auto-generated method stub
		this.likeId = likeID;
	}

	public boolean isLiked() {
		return isLiked;
	}

	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	
	
}
