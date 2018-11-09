/*
* Classs to reproduce a lottery. (choosing 6 random number out of 49 possible)
*/

import com.sun.org.apache.bcel.internal.classfile.LocalVariableTypeTable;

public class Loterry {
  // 6 out of 49
  public static boolean getBit(long n, int bit) {
    long mask = (1 << bit);

    return (n & mask) != 0;
  }

  public static int randomInt(int a, int b) {
    return (int)(Math.random() * (a - b) + b);
  }

  public static int[] extractNumbers() {
    int[] result = new int[6];
    int index = 0;
    long used = 0;

    while (index < 6) {
      int rand = randomInt(0, 49);
      long mask = 1 << rand;

      if (getBit(used, rand) == false) {
        index++;
        used |= mask;
      }
    }

    index = 0;
    for (int bit = 0; bit < 49 && index < 6; bit++) {
      if (getBit(used, bit) == true) {
        result[index] = bit + 1;
        index++;
      }
    }

    return result;
  }
}