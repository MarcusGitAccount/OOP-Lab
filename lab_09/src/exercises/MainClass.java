package exercises;

public class MainClass {
  public static void main(String[] args) {
    try {
      Integer r = null;
      int[] arr = new int[10];

      System.out.println(r.equals(2));
      System.out.println(arr[10]);
    }
    catch(NullPointerException e) {
      System.out.println(e.getMessage());
    }
    catch(ArrayIndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }
}
