package com.hardik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private static final String INSERT_SQL = "INSERT INTO `user` (Username , course , address , num , gmail , pass) VALUES (? , ? , ? , ? , ? , ? )";

	private static final String RETRIVE_SQL = "SELECT *  FROM User WHERE gmail = ?";

	public User checkIsRegister(String gmail) throws Exception {
		try(Connection con = DBUtils.getConnection();
			PreparedStatement pr = con.prepareStatement(RETRIVE_SQL);) {
			pr.setString(1, gmail);
			ResultSet rs = pr.executeQuery();
			if(rs.next()) {
				 return new User(
			                rs.getString("name"),
			                rs.getString("course"),
			                rs.getString("address"),
			                rs.getLong("num"),
			                rs.getString("gmail"),
			                rs.getString("pass")  // still hashed
			            );
			}
			return null;
		} 
	}

	public int registerUser(User user) throws Exception {
		try (Connection con = DBUtils.getConnection(); PreparedStatement pr = con.prepareStatement(INSERT_SQL);) {
			pr.setString(1, user.getName());
			pr.setString(2, user.getCourse());
			pr.setString(3, user.getAddress());
			pr.setLong(4, user.getNumber());
			pr.setString(5, user.getGmail());
			pr.setString(6, user.getPass());
			int count = pr.executeUpdate();
			return count;

		}
	}
}
