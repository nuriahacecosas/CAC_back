package com.webapp;
import java.sql.*;

public class PruebaConexion {
    public static void main(String[] args) {
        //declaración e inicialización de variables
        String url = "jdbc:mysql://localhost:3306/mis_usuarios_24250";
        String usuario = "root";
        String pass = "123456";

        //declarar objeto connection
        Connection conexion = null;

        //establecemos conexión dentro de try-catch
        try {
            //cargamos driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establecemos la comunicación
            conexion = DriverManager.getConnection(url, usuario, pass);

            System.out.println("Conexión Exitosa a WB");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
           
        } catch(SQLException e){
            System.out.println(e);

        } finally{
            // Cerrar los recursos
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexión cerrada");
                }
            } catch (SQLException e) {
                System.out.println("Error:"+ e);
                e.printStackTrace();
            }
        }      
    }
}
