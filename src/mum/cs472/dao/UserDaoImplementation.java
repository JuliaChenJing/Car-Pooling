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
		 try {
			 
	          
	            String query = "update user set fullname=?, gender=?, state=?, city=?, street=?,  zipcode=?, birthyear=?,  email=?,  password=?, datecreated=?, dateupdated =? where userId=?";
	            preparedStatement =(PreparedStatement)  conn.prepareStatement( query );
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
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	}
	
	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public User getUserById(int userId) {
        User user = new User();
        try {
            String query = "select * from user where userId=?";
            preparedStatement = (PreparedStatement) conn.prepareStatement( query );
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                user.setFullname( resultSet.getString( "fullname" ) );
                user.setGender(resultSet.getInt( "gender" ) );
                user.setState(resultSet.getString( "state" ) );
                user.setCity(resultSet.getString( "city" ) );
                user.setStreet(resultSet.getString( "street" ) );
                user.setZipcode(resultSet.getInt( "zipcode" ) );
                user.setBirthyear(resultSet.getInt( "birthyear" ) );
                user.setEmail(resultSet.getString( "email" ) );
                user.setPassword(resultSet.getString( "password" ) );
                user.setDateCreated(resultSet.getDate( "dateCreated" ) );
                user.setDateUpdated(resultSet.getDate( "dateupdated" ) );
     
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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

	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		try {
			String query = "SELECT * FROM users where email = ?";
			preparedStatement = (PreparedStatement) conn.prepareStatement(query);
			preparedStatement.setString(1, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
                user.setUserId(resultSet.getInt("userid"));
                user.setFullname(resultSet.getString("fullname"));
                user.setGender(resultSet.getInt("gender"));
                user.setState(resultSet.getString("state"));
                user.setCity(resultSet.getString("city"));
                user.setStreet(resultSet.getString("street"));
                user.setZipcode(resultSet.getInt("zipcode"));
                user.setBirthyear(resultSet.getInt("birthyear"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setDateCreated(resultSet.getDate("datecreated"));
                user.setDateUpdated(resultSet.getDate("dateupdated"));
         
            }
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
