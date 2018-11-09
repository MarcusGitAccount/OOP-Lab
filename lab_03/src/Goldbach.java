// Checking Goldbach's conjecture using a sieve for the prime numbers.

public class Goldbach {
  public static boolean[] buildSieve(int size) {
    boolean[] sieve = new boolean[size];

    sieve[0] = sieve[1] = true;

    for (int index = 2; index < size; index++) {
      int next, step;

      next = 2 * index;
      step = index;
      if (sieve[index] == true)
        continue;
      while (next < size) {
        sieve[next] = true;
        next += step;
      }
    }

    return sieve;
  }

  public static boolean Goldbach(int m, int n) {
    boolean[] sieve = buildSieve(n + 1);

    m += (m & 1); // go to the next prime

    while (m <= n) {
      boolean failed = true;

      for (int i = 0; i < (m >> 1); i++) {
        if (sieve[i] == false) {
          // is prime
          if (sieve[m - i] == false) {
            // is also prime
            failed = false;
            break;
          }
        }
      }

      if (failed == true)
        return false;
      m += 2;
    }

    return true;
  }
}
