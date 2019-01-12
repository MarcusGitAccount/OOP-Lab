import junit.framework.*;

public class TestFixture extends TestCase {
  public int n1, n2;

  // setarea valorilor n1, n2
  public void setUp(){
    n1=2;
    n2=3;
    System.out.println("setUp: n1: " + n1 + ", n2: " + n2);
  }
  // operatii cu cele doua valori
  public void testAdd(){
    double result= n1 + n2;
    assertTrue(result == 5);
  }

  public void testSub(){
    double result= n1 - n2;
    assertTrue(result < 0);
  }

  public void testMult(){
    double result= n1 * n2;
    assertTrue(result > 5);
  }

  public void testDiv(){
    double result= n1 / n2;
    assertTrue(result > 0);
  }

  //metoda rulata dupa executarea testelor
  public void tearDown(){
    n1 = 0;
    n2 = 0;
    System.out.println("tearDown: n1: " + n1 + ", n2: " + n2);
  }
}