package poll.software.pollservice.infrastructure.controllers;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import poll.software.pollservice.application.exceptions.VoteException;
import poll.software.pollservice.application.usecases.VoteService;
import poll.software.pollservice.domain.models.Candidate;
import poll.software.pollservice.infrastructure.singleton.ServiceSingleton;

import javax.swing.JOptionPane;


public class CandidateCardController {
  private final VoteService voteService = ServiceSingleton.getInstance().getVoteService();
  private Candidate candidate;

  @FXML
  private ImageView candidateImage;

  @FXML
  private Text candidateName;

  @FXML
  private Button voteButton;

  public void setDataSource(Candidate candidate) {
    this.candidate = candidate;
    candidateName.setText(candidate.getFirstName() + " " + candidate.getLastName());
    candidateImage.setImage(new Image(candidate.getUrlImage()));
    voteButton.setOnMouseEntered(event -> voteButton.setCursor(Cursor.HAND));
    voteButton.setOnMouseExited(event -> voteButton.setCursor(Cursor.DEFAULT));
    voteButton.setOnAction(event -> vote());
  }

  @FXML
  public void vote() {
    //Send vote to database
    String studentDocument = JOptionPane.showInputDialog("Digite número de identificación");

    if(validateVote(studentDocument)){
      try{
        voteService.vote(studentDocument, candidate.getId());
        showMessage("Voto registrado exitosamente");
      }catch (VoteException e) {
        showMessage(e.getMessage());
      }
    }


  }

  private boolean validateVote(String studentDocument) {
    if (studentDocument == null || studentDocument.trim().isEmpty()) {
      showMessage("Número de identificación inválido");
      return false;
    }
    if (studentDocument.length() != 10) {
      showMessage("Número de identificación debe tener 10 dígitos");
      return false;
    }
    try {
      Long.parseLong(studentDocument);
    } catch (NumberFormatException e) {
      showMessage("Número de identificación debe ser un número válido");
      return false;
    }
    return true;
  }
  private void showMessage(String message) {
    JOptionPane.showMessageDialog(null, message);
  }
}
