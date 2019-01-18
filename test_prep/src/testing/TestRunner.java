package testing;

import org.junit.runner.*;
import org.junit.runner.notification.*;

public class TestRunner {
  public static  void main(String[] args) {
    Result result = JUnitCore.runClasses(Tests.class);

    System.out.println(result.wasSuccessful());
  }
}
