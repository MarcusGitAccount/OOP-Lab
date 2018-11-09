import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    BigInteger total = BigInteger.valueOf(1);

    for (int i = 0; i < 64; i++) {
      total = total.multiply(BigInteger.valueOf(2));
    }

    System.out.println(total.subtract(BigInteger.ONE));
  }
}
