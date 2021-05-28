package co.edu.sena.HPlus2242753.model.dao;

import co.edu.sena.HPlus2242753.model.beans.Product;
import co.edu.sena.HPlus2242753.model.beans.User;
import co.edu.sena.HPlus2242753.model.connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("All")
public class ApplicationDao {
    public List<Product> searchProducts(String searchString) {
        Product product = null;
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT * FROM hplus.products where product_name like '%" + searchString + "%'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);//ejecutala consula rs tiene el resultado
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));//producto utiliza el set id para para el int
                product.setProductName(rs.getString("product_name"));
                product.setProductImgPath(rs.getString("image_path"));
                products.add(product);//elementos devueltos por la lista se devulven al servlet
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }//fin try-catch
        return products;
    } //fin searchtProduct
    public int registerUser(User user) {
        PreparedStatement ps=null;//configura los parametros completando el insert into
        int rowsAffected= 0;
        try {
            // Obtener la conexion a la base de datos
            Connection connection = DBConnection.getConnectionToDatabase();
            //escribir inset query
            String insertQuery = "insert into users values (?,AES_EMCRYPT(?,'559a0612917c8c516c7980c38b376cf2bb2387ae1b6944b3b32245ff4f2bad4d5db3811f02cff394fb62fa3feefd03e2eb83ba7bcca72a912bb87ea609c424da'),?,?,?,?)";
            //definir los parametros  (setter) PreparedStatement
            ps = connection.prepareStatement(insertQuery);//el objeto ps recibe al objeto conxion llmando al repare para
            // configurar y guardar el dato en la BD
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setInt(5, user.getAge());
            ps.setString(6, user.getActivity());
            //ejecutar el query
            rowsAffected = ps.executeUpdate();//ejecuta la instruccion
        } catch (SQLException e) {
            e.printStackTrace();
        }//fin try catch
        return rowsAffected;
    }//fin register user*/
    }