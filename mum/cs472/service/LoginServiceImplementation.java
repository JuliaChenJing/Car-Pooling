package mum.cs472.service;

import mum.cs472.dao.LoginDao;
import mum.cs472.dao.LoginDaoImplementation;

public class LoginServiceImplementation implements LoginService {

	private LoginDao  loginDao;
	public LoginServiceImplementation() {
		loginDao = new LoginDaoImplementation();
	}
	@Override
	public boolean validate(String email, String password) {
		return loginDao.validate(email, password);
	}

}
