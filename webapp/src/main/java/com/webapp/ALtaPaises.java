package com.webapp;
import java.sql.*;

public class ALtaPaises {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/mis_usuarios";
        String user = "root";
        String password = "123456"; 

        Connection connection = null;
        Statement statement = null;
        

        try {
            // controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión Exitosa");
            
            String insertarPaisesSQL = "INSERT INTO paises (nombrePais) VALUES " 
            + "('Argentina'), "
            + "('Uruguay'), "
            + "('Chile'), "
            + "('Perú'), "
            + "('Bolivia'), "
            + "('Paraguay')";
            // Ejecutamos las clausulas SQL
            statement = connection.createStatement();
            statement.executeUpdate(insertarPaisesSQL);
            System.out.println("Datos cargados correctamente");

        } catch (Exception e) {
            System.out.println(e);
        }  finally {
            // Cerrar los recursos
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    }

}
