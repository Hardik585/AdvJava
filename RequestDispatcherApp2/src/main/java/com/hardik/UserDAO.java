package com.hardik;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private final String RETRIVE_SQL = "SELECT * FROM user WHERE email= ? , pass = ? ";
	private final String INSERT_SQL = "INSERT INTO user (fname , lname , email , pwd , phone , gender , role )VALUES(?,?,?,?,?,?,?)";

	public boolean saveUser(UserDTO dto) throws SQLException, IOException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setString(1, dto.getfName());
		pstmt.setString(2, dto.getlName());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getPwd());
		pstmt.setLong(5, dto.getPhoneNo());
		pstmt.setString(6, String.valueOf(dto.getGender()));
		pstmt.setString(7, dto.getRole());
		int count = pstmt.executeUpdate();
		return count > 0;
	}

	public UserDTO getUser(String email, String pwd) throws SQLException, IOException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(RETRIVE_SQL);
		pstmt.setString(1, email);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();

		UserDTO dto = new UserDTO();
		dto.setfName(rs.getString("fname"));
		dto.setlName(rs.getString("lname"));
		dto.setEmail(rs.getString("email"));
		dto.setPwd(rs.getString("pwd"));
		dto.setPhoneNo(rs.getLong("phoneno"));
		dto.setGender(rs.getString("gender").charAt(0));
		dto.setRole(rs.getString("role"));

		con.close();
		return dto;
	}

}
