package poll.software.pollservice.infrastructure.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import poll.software.pollservice.Main;
import poll.software.pollservice.application.usecases.CandidateService;
import poll.software.pollservice.domain.models.Candidate;
import poll.software.pollservice.Util;
import poll.software.pollservice.infrastructure.singleton.ServiceSingleton;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CandidateController {
  @FXML
  public Text title;
  @FXML
  public Text shift;
  @FXML
  public Button viewStatisticsButton;
  @FXML
  private HBox candidatesContainer;

  private final CandidateService candidateService = ServiceSingleton.getInstance().getCandidateService();

  @FXML
  public void initialize() {
    setTitle();
    startClock();
    viewStatisticsButton.setOnAction(e -> {
      try {
        Main.switchScene("statistics.fxml");
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    });
    List<Candidate> candidates = candidateService.getCandidates();

    for (Candidate candidate : candidates) {
      System.out.println(candidate.getFirstName());
      printCandidateCard(candidate);
    }
  }

  private void printCandidateCard(Candidate candidate) {
    try{
      FXMLLoader fxmlLoader = Util.getLoader("candidate-card.fxml");
      Parent candidateView = fxmlLoader.load();
      CandidateCardController controller = fxmlLoader.getController();
      controller.setDataSource(candidate);
      candidatesContainer.getChildren().add(candidateView);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void setTitle() {
    title.setText("Candidatos " + " - Jornada de " + Util.getShiftTime().getName());
  }

  private void startClock() {
    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
            shift.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))),
            new KeyFrame(Duration.seconds(1))
    );
    clock.setCycleCount(Timeline.INDEFINITE);
    clock.play();
  }

}
