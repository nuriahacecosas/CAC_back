package com.webapp;
import java.sql.*;

public class AltaUsuarios {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/mis_usuarios";
        String user = "root"; 
        String password = "123456"; 

        Connection connection = null;
        PreparedStatement declaracion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a la base de datos EXITOSA");

            // Creamos la sentencia para cargar datos dentro de la tabla
            String sqlUsuarios = "INSERT INTO usuarios (nombre, apellido,email,fkPais)"+
            "VALUES (?, ?, ?, ?)";

            // Cargamos los datos en la tabla
            declaracion = connection.prepareStatement(sqlUsuarios);
            declaracion.setString(1, "Nombre 1");
            declaracion.setString(2, "Apellido 1");
            declaracion.setString(3,"email@email1.com");
            declaracion.setInt(4, 1); // 1 es el código de Argentina

            // Ejecutamos la inserción
            int filasInsertadas = declaracion.executeUpdate();

            // Mediante una estructura if comunicamos de la inserción exitosa
            if(filasInsertadas>0){
                System.out.println("Inserción exitosa de datos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (declaracion != null) declaracion.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
