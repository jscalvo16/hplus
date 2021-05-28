package co.edu.sena.HPlus2242753.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("All")
@WebServlet(name = "GetServlet", value = "/getservlet")
public class GetServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {


    }
}