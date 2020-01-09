import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


public class testParseDate {

  @Rule
  public TestRule benchmarkRun = new BenchmarkRule();

  private int AMOUNT_DATE_STRINGS = 100_000;
  String[] stringDates;

  @Before
  public void setUp() {
    stringDates = new String[AMOUNT_DATE_STRINGS];

    for (int i = 0; i < stringDates.length; i++) {
      String day = String.format("%02d", (int) (Math.random() * 28) + 1);
      String month = String.format("%02d", (int) (Math.random() * 12) + 1);
      String year = String.format("%04d", (int) (Math.random() * 3000) + 1);
      String date = String.join(".", day, month, year);
      stringDates[i] = date;
    }

  }

  @Test
  @BenchmarkOptions(concurrency = 1, warmupRounds = 15, benchmarkRounds = 30)
  public void testLocalDate() {
    for (String dateStr : stringDates) {
      ParseToLocalDate.stringToDate(dateStr);
    }
  }

  @Test
  @BenchmarkOptions(concurrency = 1, warmupRounds = 15, benchmarkRounds = 30)
  public void testDate() {
    for (String dateStr : stringDates) {
      ParseToDate.stringToDate(dateStr);
    }
  }
}
