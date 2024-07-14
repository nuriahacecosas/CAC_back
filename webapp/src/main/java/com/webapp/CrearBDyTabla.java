package com.webapp;
import java.sql.*;
public class CrearBDyTabla {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String user = "root";
        String password = "123456";

        // Declaramos objetos que nos ayudan con la conexion y sentencias SQL
        Connection connection = null;
        Statement statement = null;

        try {
            // bloque que contiene lo que queremos hacer
            // carga de controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nos conectamos al server 
            connection = DriverManager.getConnection(url,user,password);
            // Inicializamos el objeto statement
            statement = connection.createStatement(); // statement nos ayuda con las "declaraciones" SQL

            //se crea la bd si no existe
            String sql = "CREATE DATABASE IF NOT EXISTS mis_usuarios";
            // Ejecutamos la sentencia
            statement.executeUpdate(sql);
            System.out.println("La base de datos mis_usuarios fue creada o ya existe");

            // nos conectamos a la bd mis_usuarios
            connection = DriverManager.getConnection(url+"mis_usuarios",user,password);
            statement = connection.createStatement();

            // Creamos la tabla paises, si NO existe
            // Clausula SQL
            String crearTablaSQL = "CREATE TABLE IF NOT EXISTS paises ("
                    + "idPais INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombrePais VARCHAR(150) NOT NULL"
                    + ")";

            //Ejecutamos la clausula SQL
            statement.executeUpdate(crearTablaSQL);
            //Aviso de tabla creada
            System.out.println("Tabla creada o ya existente");

            // Creamos la segunda tabla usuarios (SI NO EXISTE) si existe la deja como está
            // Clausula SQL
            String crearTablaSQL2 = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "idUsuario INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "apellido VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(100) NOT NULL, "
                    + "fkPais INT, "
                    + "FOREIGN KEY (fkPais) REFERENCES paises(idPais)"
                    + ")";
            
            //Ejecutamos la sentencia SQL
            statement.executeUpdate(crearTablaSQL2);
            //Aviso de todo ok
            System.out.println("Tabla usuarios creada o ya existente");          
            
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            // Cerrar los recursos
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
