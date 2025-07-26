package com.hardik;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fName = req.getParameter("fName");
			String lName = req.getParameter("lName");
			String email = req.getParameter("email");
			String pwd = req.getParameter("pwd");
			long phone = Long.parseLong(req.getParameter("phone"));
			char gender = req.getParameter("gender").charAt(0);
			String role = req.getParameter("role");

			UserDTO dto = new UserDTO();
			dto.setfName(fName);
			dto.setlName(lName);
			dto.setEmail(email);
			dto.setPwd(pwd);
			dto.setPhoneNo(phone);
			dto.setGender(gender);
			dto.setRole(role);

			UserDAO dao = new UserDAO();
			boolean isSave = dao.saveUser(dto);

			String response;
			if (isSave) {
				response = "Rec inserted ";
			} else {
				response = "something went wrong ";
			}

			PrintWriter pw = resp.getWriter();
			pw.append("<h1>" + response + "</h1>");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
