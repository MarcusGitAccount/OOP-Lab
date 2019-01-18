package exceptions_errors;

public class EvenNumberException extends Exception {
  public EvenNumberException() {
    super();
  }

  public EvenNumberException(String message) {
    super(message);
  }
}
