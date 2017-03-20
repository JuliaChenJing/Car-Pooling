package mum.cs472.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static DBUtil instance = null;
	private Connection connection;

	private DBUtil() {
		try {
			Properties properties = new Properties();
			Class.forName("com.mysql.jdbc.Driver");
			// connect way #1
			String url = "jdbc:mysql://localhost:3306/carpool?useSSL=false";
			String user = "root";
			String password = "";

			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connected to the database test");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}

	}

	public synchronized static Connection getConnection() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance.connection;
	}

	public static void closeConnection(Connection toBeClosed) {
		if (toBeClosed == null)
			return;
		try {
			toBeClosed.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
