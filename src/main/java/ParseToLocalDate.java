import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseToLocalDate {

  private static final String DATE_FORMAT = "dd.MM.yyyy";
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

  static LocalDate stringToDate(String strDate) {
    return LocalDate.parse(strDate, FORMATTER);
  }
}

