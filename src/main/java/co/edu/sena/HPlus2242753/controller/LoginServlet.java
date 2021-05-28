package co.edu.sena.HPlus2242753.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String html = "<html><h1>Pelase<h1><html>";

		RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
	dispatcher.include(req, res);
	}

}
