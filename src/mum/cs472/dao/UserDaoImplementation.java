package mum.cs472.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import mum.cs472.model.User;
import mum.cs472.util.DBUtil;

public class UserDaoImplementation implements UserDao {
	private Connection conn;
	private PreparedStatement preparedStatement;

	public UserDaoImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addUser(User user) {
		try {
			String insertQuery = "INSERT INTO users (fullname, gender,state,city, street, zipcode,birthyear, email, password,datecreated,dateupdated)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery);

			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setInt(2, user.getGender());
			preparedStatement.setString(3, user.getState());
			preparedStatement.setString(4, user.getCity());
			preparedStatement.setString(5, user.getStreet());
			preparedStatement.setInt(6, user.getZipcode());
			preparedStatement.setInt(7, user.getBirthyear());
			preparedStatement.setString(8, user.getEmail());
			preparedStatement.setString(9, user.getPassword());
			preparedStatement.setDate(10, (Date) user.getDateCreated());
			preparedStatement.setDate(11, (Date) user.getDateUpdated());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("-----User successfully inserted---");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFullNameByEmail(String email) {
		String fullname = "No information found for the requested user: " + email;
		try {
			String query = "SELECT * FROM users where email = ?";
			preparedStatement = (PreparedStatement) conn.prepareStatement(query);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				fullname = resultSet.getString("fullname");
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullname;
	}

}
