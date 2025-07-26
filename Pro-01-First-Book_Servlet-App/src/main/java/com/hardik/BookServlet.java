package com.hardik;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/insertbook")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)  {

		int id = Integer.parseInt(req.getParameter("bookId"));
		String name = req.getParameter("bookName");
		String author = req.getParameter("bookAuthor");
		Float price = Float.parseFloat(req.getParameter("bookPrice"));

		BookDTO dto = new BookDTO();
		dto.setBookId(id);
		dto.setBookName(name);
		dto.setBookAuthor(author);
		dto.setBookPrice(price);

		BookDAO dao =new BookDAO();
		try {
			boolean isInsert =dao.insertBook(dto);
			String response ;
			if(isInsert) {
				response = "Record Inserted Successfully ";
			}else {
				response = "Not able to insert the record";
			}

			PrintWriter pw =res.getWriter();
			pw.append(response);

		} catch (Exception e) {
		   e.printStackTrace();
		}

	}

}
