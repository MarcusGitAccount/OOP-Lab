public class MessageUtil {
  private String message;
  // Constructor
  public MessageUtil(String message) {
    this.message = message;
  }
  // afiseaza un mesaj
  public String printMessage() {
    System.out.println(message);
    return message;
  }
}
