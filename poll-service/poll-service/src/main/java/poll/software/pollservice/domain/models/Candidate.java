package poll.software.pollservice.domain.models;

import poll.software.pollservice.domain.enums.ShiftTime;

public class Candidate {
  private Long id;
  private String firstName;
  private String lastName;
  private String urlImage;
  private ShiftTime shiftTime;

  public Candidate(Long id, String firstName, String lastName, String urlImage,ShiftTime shiftTime) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.urlImage = urlImage;
    this.shiftTime = shiftTime;
  }

  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public String getUrlImage() {
    return urlImage;
  }
  public ShiftTime getShiftTime() {
    return shiftTime;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setUrlImage(String urlImage) {
    this.urlImage = urlImage;
  }
  public void setShiftTime(ShiftTime shiftTime) {
    this.shiftTime = shiftTime;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

}
