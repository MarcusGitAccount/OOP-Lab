package interfaces;

public interface Area extends Comparable {
  default void hello() {
    System.out.println("Hei");
  }

  int area();
}
