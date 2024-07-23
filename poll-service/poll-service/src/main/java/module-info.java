module poll.software.pollservice {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires java.desktop;

  opens poll.software.pollservice to javafx.fxml;
  exports poll.software.pollservice;

  // Add this line to open the controllers package to javafx.fxml
  opens poll.software.pollservice.infrastructure.controllers to javafx.fxml;
}