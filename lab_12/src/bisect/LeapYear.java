package bisect;

public class LeapYear {
  public static boolean IsLeapYear(int year) {
    return (year % 4 == 0 && year % 100 == 0) || year % 400 == 0;
  }
}
