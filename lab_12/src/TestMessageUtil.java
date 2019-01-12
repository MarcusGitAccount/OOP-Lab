import org.junit.Test;
import static org.junit.Assert.*;

public class TestMessageUtil {
  String message = "Hello World";
  MessageUtil messageUtil = new MessageUtil(message);
  @Test
  public void testPrintMessage() {
    assertEquals(message, messageUtil.printMessage());
  }
}