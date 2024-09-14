package org.pre.parcial.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {
  private static final Dotenv dotenv =Dotenv.load();
  // Parámetros para la conexión
  private static final String URL = "jdbc:mysql://localhost:3306/dbpreparcial";  // Cambia 'db_telebot' por el nombre de tu base de datos si es necesario
  private static final String USER = "root"; // Cambia 'root' por tu usuario de MySQL
  private static final String PASSWORD = dotenv.get("DATABASE_PASSWORD"); // Cambia 'password' por tu contraseña de mysql en un archivo .env

  private static Connection connection;

  // Método para obtener la conexión
  public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      try {
        // Registrar el controlador de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establecer la conexión
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new SQLException("No se pudo cargar el driver JDBC de MySQL");
      }
    }
    return connection;
  }

  // Método para cerrar la conexión
  public static void closeConnection() throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
  }
}
