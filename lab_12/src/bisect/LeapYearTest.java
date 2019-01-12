package bisect;

import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static bisect.LeapYear.IsLeapYear;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class LeapYearTest {
  @DataPoints
  public static int[] data = {203, 4, 1000, 1600, 2018, 2016};

  @Theory
  public void test(int year) {
    assertTrue(IsLeapYear(year));
  }
}
