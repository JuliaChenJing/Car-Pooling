package mum.cs472.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import mum.cs472.util.DBUtil;

public class LoginDaoImplementation implements LoginDao {
	private Connection conn;
	private PreparedStatement preparedStatement;

	public LoginDaoImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public boolean validate(String email, String password) {
		boolean status = false;
		try {
			String query = "SELECT * FROM users where email = ? and password= ?";
			preparedStatement = (PreparedStatement) conn.prepareStatement(query);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			status = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
