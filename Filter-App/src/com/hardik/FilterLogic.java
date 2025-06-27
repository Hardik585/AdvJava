package com.hardik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FilterLogic {

	public ArrayList<Employ> employData(String location, String department, String gen) throws Exception {

		ArrayList<Employ> list = new ArrayList<Employ>();
		boolean work_loc = location != null && !location.isEmpty();
		boolean dept = department != null && !department.isEmpty();
		boolean gender = gen != null && !gen.isEmpty();

		StringBuilder sql = new StringBuilder("Select * from employ WHERE 1=1 ");

		if (work_loc)
			sql.append("AND work_location = ? ");
		if (dept)
			sql.append("AND dept = ? ");
		if (gender)
			sql.append("AND gender = ? ");

		int index = 1;
		try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql.toString());) {
			if (work_loc)
				pstmt.setString(index++, location);
			if (dept)
				pstmt.setString(index++, department.trim());
			if (gender)
				pstmt.setString(index++, gen);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String work_location = rs.getString("work_location");
				String depart = rs.getString("dept");
				String gen1 = rs.getString("gender");
				Employ em = new Employ(name, work_location, depart, gen1);
				list.add(em);
			}
		}
		return list;

	}
}
