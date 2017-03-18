package mum.cs472.model;

public class User {
	private String username;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}

}
