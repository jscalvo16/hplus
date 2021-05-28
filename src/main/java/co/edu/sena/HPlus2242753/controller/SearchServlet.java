package co.edu.sena.HPlus2242753.controller;

import co.edu.sena.HPlus2242753.model.beans.Product;
import co.edu.sena.HPlus2242753.model.dao.ApplicationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")//referencia desde el action
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        //colectar string de busquda del search html
        String searchString = req.getParameter("search");

        //Llamar Dao para tener los satos de la bsuqeda
        ApplicationDao dao = new ApplicationDao();
        List<Product> products = dao.searchProducts(searchString);
        //ESCRIBIR LOS PROCUTOS EN LA PAGINA
        String page = getHTMLString(req.getServletContext().getRealPath("/html/searchResults.html"),products);
        res.getWriter().write(page);
    }//fin doget
    public String getHTMLString(String filepath, List<Product> products)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line ="";//lee cada linea del html
        StringBuffer buffer = new StringBuffer(); //agrega todas las lineas para hacer un string
        while ((line=reader.readLine()) !=null){//asigna el reader line
                buffer.append(line);
        }//fin while
        reader.close();
        String page = buffer.toString();

        page = MessageFormat.format(page, products.get(0).getProductImgPath(),
                products.get(1).getProductImgPath(),//remplaza los {} del html
                products.get(2).getProductImgPath(),
                products.get(0).getProductName(),
                products.get(1).getProductName(),
                products.get(2).getProductName(), 0);

        return page;

    }//fin getHTML

}
