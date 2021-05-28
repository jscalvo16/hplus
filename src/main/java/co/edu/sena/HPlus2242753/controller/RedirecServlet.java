package co.edu.sena.HPlus2242753.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirecServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest reqt, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect("https://www.linkedin.com/learning/me");
    }
}
