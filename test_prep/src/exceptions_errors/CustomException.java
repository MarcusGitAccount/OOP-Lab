package exceptions_errors;

public class CustomException extends RuntimeException {
  public CustomException() {
    super("Custom exception");
  }

  public CustomException(String message) {
    super(message);
  }
}
