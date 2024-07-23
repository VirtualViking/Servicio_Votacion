package poll.software.pollservice.domain.enums;

public enum ShiftTime {
  DAY("Día"), AFTERNOON("Tarde"), NIGHT("Noche");
  private final String name;

  ShiftTime(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
}
