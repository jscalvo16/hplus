package co.edu.sena.HPlus2242753.controller;

import co.edu.sena.HPlus2242753.model.beans.User;
import co.edu.sena.HPlus2242753.model.dao.ApplicationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

@SuppressWarnings("All")
@WebServlet("/register")
public class RegistationUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //Colectar informacion del formulario
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String activity = req.getParameter("activity");
        int age = Integer.parseInt(req.getParameter("age"));

        //Crear y llenar objeto userbean
        User user = new User(password, username, firstName, lastName, age, activity);

        //Llamar la capa DAO y guradar el objeto en la base de datos
        ApplicationDao dao = new ApplicationDao();
        int rows = dao.registerUser(user);
        //preparar mensaje sobre la operaión
        String infoMessage = null;//crear el mensajee
        if (rows == 0) {
            infoMessage = ("Disculpe ocurrio un error");//si no afecta a ninguna fila sale este anuncion
        } else {
            infoMessage= ("registro exito!");//si afecta alguna fila sale este otro
        }
        //Escribir el mensaje y enviarlo al navegador
        String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"),infoMessage);
        resp.getWriter().write(page);//agregar a el mensaje a html
    }//fin doPost
    public String getHTMLString(String filePath, String message) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = "";//almacena cada lectura por linea del html
        StringBuffer buffer = new StringBuffer();//acumula todas lineas del archivo
        while ((line = reader.readLine()) != null) {//asigna el readline a line hasta que sea diferente de null
            buffer = buffer.append(line);
        }
        reader.close();
        String page = buffer.toString();//buffer hae que HTML se conviuerta en una plantilla

        page = MessageFormat.format(page, message);
        return page;
    }//fin getHTMLString

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"),"");
        resp.getWriter().write(page);
    }
}//fin RegistationUserServlet
