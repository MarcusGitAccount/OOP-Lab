package lottery;

public class Utils {
  public static boolean getBit(long n, int bit) {
    long mask = (1 << bit);

    return (n & mask) != 0;
  }

  public static int randomInt(int a, int b) {
    return (int)(Math.random() * (a - b) + b);
  }
}
