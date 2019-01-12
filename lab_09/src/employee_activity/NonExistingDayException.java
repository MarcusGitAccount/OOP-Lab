package employee_activity;

public class NonExistingDayException extends Exception {
  public NonExistingDayException() {
    super("This day does not exist.");
  }

  public NonExistingDayException(String message) {
    super(message);
  }
}
