import java.util.Scanner;

// Various string operations.

public class CharsCount {
  public CharsCount() {}

  public static String vowels = new String("aeiouAEIOU");private static boolean isVowel(char c) {
    return vowels.indexOf(c) >= 0;
  }

  public static int countVowels(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++)
      if (isVowel(str.charAt(i)) == true)
        count++;

    return count;
  }

  public static void solve() {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    int vowels = countVowels(str);
    String vow;

    System.out.println(
        "V: " + vowels + "\nC: " + (str.length() - vowels)
    );

    do {
      vow = scan.nextLine();
    } while (vow.length() == 1 && !isVowel(vow.charAt(0)));


    System.out.println(str.indexOf(vow));
  }
}
