package com.hardik;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {

	public boolean insertBook(BookDTO dto) throws SQLException, IOException {
			String InsertSql = "INSERT INTO book VALUES (? , ? , ? , ? )";

			Connection con = ConnectionFactory.getConncetion();

			PreparedStatement pstmt = con.prepareStatement(InsertSql);
			pstmt.setInt(1, dto.getBookId());
			pstmt.setString(2, dto.getBookName());
			pstmt.setString(3, dto.getBookAuthor());
			pstmt.setFloat(4, dto.getBookPrice());
			int count = pstmt.executeUpdate();

			return count > 0;
	}
}
