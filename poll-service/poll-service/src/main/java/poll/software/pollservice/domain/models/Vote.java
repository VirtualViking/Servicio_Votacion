package poll.software.pollservice.domain.models;

public class Vote {
  private Long id;
  private String studentDocument;
  private Candidate candidate;

  public Vote(Long id, String studentDocument, Candidate candidate) {
    this.id = id;
    this.studentDocument = studentDocument;
    this.candidate = candidate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStudentDocument() {
    return studentDocument;
  }

  public void setStudentDocument(String studentDocument) {
    this.studentDocument = studentDocument;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }
}
