import java.time.LocalDate;
import java.util.Date;

public class ParseToDate {

  static Date stringToDate(String strDate) {
    Date date = new Date();
    date.setDate(Integer.parseInt(strDate.substring(0, 2)));
    date.setMonth(Integer.parseInt(strDate.substring(3, 5)) - 1);
    date.setYear(Integer.parseInt(strDate.substring(6, 10)));
    return date;
  }
}
