import java.util.Comparator;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });

    set.add(99);
    set.add(11);
    set.add(34);

    System.out.println(set);
  }
}
