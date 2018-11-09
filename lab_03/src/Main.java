public class Main {
  public static void main(String[] args) {
    //CharsCount.solve();

    int[] numbers = Loterry.extractNumbers();

    for (int i = 0; i < 6; i++)
      System.out.println(numbers[i]);
  }
}
