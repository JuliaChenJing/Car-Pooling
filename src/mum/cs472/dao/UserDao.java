package mum.cs472.dao;

import java.util.List;

import mum.cs472.model.User;

public interface UserDao {
	public void addUser(User user);

	public void deleteUser(int userId);

	public void updateUser(User user);

	public List<User> getAllUsers();

	public User getUserById(int userId);

	public String findFullNameByEmail(String email);
}
