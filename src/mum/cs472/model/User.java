package mum.cs472.model;

import java.util.Date;

public class User {
	private int userId;
	private String fullname;
	private int gender;
	private String state;
	private String city;
	private String street;
	private int zipcode;
	private int birthyear;
	private String email;
	private String password;
	private Date dateCreated;
	private Date dateUpdated;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String fullname, int gender, String state, String city, String street, int zipcode, int birthyear,
			String email, String password, Date dateCreated, Date dateUpdated) {
		this.fullname = fullname;
		this.gender = gender;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.birthyear = birthyear;
		this.email = email;
		this.password = password;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "User [userId=" + userId + ", fullname=" + fullname + ", gender=" + gender + ", state=" + state
				+ ", city=" + city + ", street=" + street + ", zipcode=" + zipcode + ", birthyear=" + birthyear
				+ ", email=" + email + ", password=" + password + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + "]";
	}
	
	
}
