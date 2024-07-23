package poll.software.pollservice.infrastructure.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import poll.software.pollservice.Main;
import poll.software.pollservice.application.usecases.VoteService;
import poll.software.pollservice.domain.models.Candidate;
import poll.software.pollservice.infrastructure.singleton.ServiceSingleton;

import java.util.Map;

public class StatisticsController {
  @FXML
  private VBox statisticsContainer;

  private BarChart<String, Number> barChart;
  private VoteService voteService = ServiceSingleton.getInstance().getVoteService();
  @FXML
  private Button backButton;

  @FXML
  public void initialize() {
    backButton.setOnAction(e -> {
      try {
        Main.switchScene("candidates.fxml");
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    });
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    yAxis.setLabel("Número de Votos");
    xAxis.setLabel("Candidato");
    barChart = new BarChart<>(xAxis, yAxis);
    barChart.setTitle("Estatísticas de Votos");
    barChart.setLegendVisible(false);
    barChart.setBarGap(0.2);
    statisticsContainer.getChildren().add(barChart); // Add the bar chart to the container

    displayStatistics();
  }

  private void displayStatistics() {
    Map<Candidate, Integer> statistics = voteService.getVoteStatistics();

    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Número de Votos");

    for (Map.Entry<Candidate, Integer> entry : statistics.entrySet()) {
      Candidate candidate = entry.getKey();
      Integer voteCount = entry.getValue();
      series.getData().add(new XYChart.Data<>(candidate.getFirstName() + " " + candidate.getLastName(), voteCount));
    }

    barChart.getData().add(series);
  }
}