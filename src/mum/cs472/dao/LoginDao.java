package mum.cs472.dao;

public interface LoginDao {
	public boolean validate(String email, String password);
}
