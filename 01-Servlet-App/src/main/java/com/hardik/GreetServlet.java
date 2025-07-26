package com.hardik;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pw = res.getWriter();
		pw.append("<h1> hi from greet servlet");
	}
}
