package mum.cs472.service;

import java.util.List;

import mum.cs472.dao.UserDao;
import mum.cs472.dao.UserDaoImplementation;
import mum.cs472.model.User;

public class UserServiceImplementation implements UserService{

	private UserDao userDao;
	
	public UserServiceImplementation() {
		userDao = new UserDaoImplementation();
	}
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(int userId) {
	
		return userDao.getUserById(userId);
	}

	@Override
	public String findFullNameByEmail(String email) {
		return userDao.findFullNameByEmail(email);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

}
