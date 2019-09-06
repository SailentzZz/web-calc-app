package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

public class DBModel {
	
	Logger logger = Logger.getLogger(DBModel.class);
	static String username = "gsbnwtwyresjgv";
	static String pass = "0a7151663758355cdd7e8672227a4e70c4898edce40251b14801536dd3d19103";
	static String host = "ec2-46-137-187-23.eu-west-1.compute.amazonaws.com";
	static String db = "d2ftsrjei473tl";
	static String ssl = "?sslmode=require";
	
	
	public User getUserValidation(String loging, String password) {		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-187-23.eu-west-1.compute.amazonaws.com:5432/d2ftsrjei473tl?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", username, pass);
			logger.info("Connection");
			
			PreparedStatement statement = connection.prepareStatement("SELECT id, Name, logging, password, email\r\n" + 
					"  FROM UserInfo where logging = ? and password = ?;");
			statement.setString(1, loging);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next() == true) { 	
				User user = new User(resultSet.getInt("id"), 
						resultSet.getString("Name"), 
						resultSet.getString("logging"), 
						resultSet.getString("password"), 
						resultSet.getString("email"));
				logger.info("Current user: " + user.toString());
				return user;			
			} else {
				logger.error("User not exist");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
	}
	
	public boolean putUserDB(String name, String login, String password, String email) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-187-23.eu-west-1.compute.amazonaws.com:5432/d2ftsrjei473tl?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", username, pass);
			logger.info("Connection");
			
			PreparedStatement statement1 = connection.prepareStatement("SELECT id, Name, logging, password, email\r\n" + 
					"  FROM UserInfo WHERE Name = ? and logging = ? and email = ?;");
			statement1.setString(2, login);
			statement1.setString(1, name);
			statement1.setString(3, email);
			ResultSet row1 = statement1.executeQuery();
			
			if (row1.next() == false) {			
				PreparedStatement statement = connection.prepareStatement("INSERT INTO UserInfo(\r\n" + 
						"            id, Name, logging, password, email)\r\n" + 
						"    VALUES ((SELECT COUNT(id) from UserInfo) + 1, ?, ?, ?, ?);");
				statement.setString(1, name);
				statement.setString(2, login);
				statement.setString(3, password);
				statement.setString(4, email);
				
				int row = statement.executeUpdate();
				logger.info(row);
				if (row == 1) return true;
				else return false;
				
			} else {
				logger.error("This login/username or email is already taken");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean putOperation(User user, String operation, Date date) {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-187-23.eu-west-1.compute.amazonaws.com:5432/d2ftsrjei473tl?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", username, pass);
			logger.info("Connection");
			
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO OperationHistory(\r\n" + 
					"            id, operation, date, id_var_user)\r\n" + 
					"    VALUES ((SELECT COUNT(id) from OperationHistory) + 1, ?, ?, ?);");
			statement.setString(1, operation);
			statement.setDate(2, sqlDate);
			statement.setInt(3, user.getId());
			
			int row = statement.executeUpdate();
			if(row == 1) {
				logger.info("Operation added");
				return true;
			} else {
				logger.error("Operation rejected");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Operation> getOperations(User User) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-187-23.eu-west-1.compute.amazonaws.com:5432/d2ftsrjei473tl?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", username, pass);
			logger.info("Connection");
			
			PreparedStatement statement = connection.prepareStatement("SELECT logging, password, operation, date\r\n" + 
					"  FROM OperationHistory JOIN UserInfo ON OperationHistory.id_var_user = UserInfo.id WHERE logging = ? AND password = ?;");
			statement.setString(1, User.getLogging());
			statement.setString(2, User.getPassword());
			
			ArrayList<Operation> answer = new ArrayList<Operation>();
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Operation operation = new Operation(resultSet.getString("operation"), resultSet.getString("date"));
				answer.add(operation);
			}
			
			return answer;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String[] emailVerification(String Email) {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-187-23.eu-west-1.compute.amazonaws.com:5432/d2ftsrjei473tl?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", username, pass);
			logger.info("Connection");
			
			PreparedStatement statement = connection.prepareStatement("SELECT logging, password\r\n" + 
					"  FROM UserInfo WHERE email = ?;");
			statement.setString(1, Email);
			
			String[] answer = new String[2];
			ResultSet row = statement.executeQuery();
			if (row.next() == false) {
				logger.error("Email not found");
				return null;
			} else {
				logger.info("Email found");
				answer[0] = row.getString("logging");
				answer[1] = row.getString("password");
				return answer;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
