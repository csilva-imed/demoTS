package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseUtils {
    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = DatabaseUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new IOException("No se encontró el archivo db.properties");
            }
            properties.load(input);
        }
        return properties;
    }

    public static Connection getConnection() throws SQLException, IOException {
        Properties properties = loadProperties();
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void disconnect(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // Método para ejecutar una consulta SQL
    public static ResultSet executeQuery(String query) throws SQLException, IOException {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta");
            e.printStackTrace();
        } finally {
            // Cerramos el Statement y Connection al final del procesamiento
            if (statement != null) {
                statement.close();
            }
            disconnect(connection); // Llamamos a disconnect para cerrar la conexión
        }
        return resultSet;
    }
}
