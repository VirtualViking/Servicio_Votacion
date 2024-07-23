package poll.software.pollservice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  private static Stage primaryStage;

  @Override
  public void start(Stage stage) throws IOException {
    primaryStage = stage;
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("candidates.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
    stage.setTitle("Poll Service");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

  public static void switchScene(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
    Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
    primaryStage.setScene(scene);
  }
}