package testing;

import interfaces.Point;
import junit.framework.*;
import interfaces.*;

public class Tests extends TestCase {
  private Shape testObject;

  @Override
  protected void setUp() throws Exception {
    testObject = new Shape(new Point(2, 3), 3, 3);
  }

  public void testCloning() {
    try {
      Shape rect = new Shape(testObject);
      rect.getTop().setX(20);

      Assert.assertNotSame(testObject.getTop().getX(), 20);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  protected void tearDown() throws Exception {
    testObject = null;
    System.out.println("Mr G. tear down this wall!");
  }
}
