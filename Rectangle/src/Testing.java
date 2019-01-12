import java.util.Scanner;

public class Testing {
  public static void main(String[] args) {
    System.out.println(Point.ORIGIN.equals(new Point(0, 0)));

    for (int i = 0; i < 100; i++) {
      Point p = new Point();
    }

    System.out.println(Point.getObjectsCreatedCount());
    System.out.println(Point.distance(new Point(3, 4), Point.ORIGIN));

    Rectangle rect1 = new Rectangle(new Point(-1, -1), 3, 3);
    Rectangle rect2 = new Rectangle(Point.ORIGIN, 3, 3);

    System.out.println(Rectangle.isValid(rect1));
    System.out.println(Rectangle.isValid(rect2));
    System.out.println(rect1.isMagic());
    System.out.println(rect2.isMagic());

    RectangleRotated special = new RectangleRotated(Point.ORIGIN, 3, 4, 0);

    System.out.println(special.isMagic());

    Scanner scan = new Scanner(System.in);
    int a, b;

    do {
      a = scan.nextInt();
      b = scan.nextInt();
    } while (a < 0 || b < 0);

    System.out.println("Final: " + a + " " + b);
  }
}
