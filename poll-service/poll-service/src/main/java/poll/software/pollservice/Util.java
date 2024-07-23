package poll.software.pollservice;

import javafx.fxml.FXMLLoader;
import poll.software.pollservice.domain.enums.ShiftTime;

import java.time.LocalDateTime;

public class Util {
  public static ShiftTime getShiftTime(){
    LocalDateTime now = LocalDateTime.now();
    int hour = now.getHour();
    if(hour >= 6 && hour < 14){
      return ShiftTime.DAY;
    }else if(hour >= 14 && hour < 22){
      return ShiftTime.AFTERNOON;
    }else{
      return ShiftTime.NIGHT;
    }
  }

  public static FXMLLoader getLoader(String fxml){
    return new FXMLLoader(Util.class.getResource(fxml));
  }
}
