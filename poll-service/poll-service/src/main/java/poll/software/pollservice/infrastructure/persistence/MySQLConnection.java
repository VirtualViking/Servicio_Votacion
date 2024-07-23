package poll.software.pollservice.infrastructure.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
  private final String url = "jdbc:mysql://localhost:3306/poll_service";
  private final String username = "root";
  private final String password = "admin123";

  public Connection getConnection() {
    try{
      return DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to the database", e);
    }
  }
}
