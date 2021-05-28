package co.edu.sena.HPlus2242753.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SuppressWarnings("ALL")
public class DBConnection {

    public static Connection getConnectionToDatabase (){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hplus","root","");
        }catch (SQLException e){
            System.out.println("Fallo la conexion, verifique la consola");
            e.printStackTrace();
        }
        if (connection != null){
            System.out.println("Conexion exitosa");
        }
        return connection;
    }
}
