import org.jetbrains.annotations.Contract;

public class Point {
  public static final Point ORIGIN = new Point(0, 0);
  private static int objectsCreated = 0;

  public static int getObjectsCreatedCount() {
    return objectsCreated;
  }

  public static double distance(Point a, Point b) {
    if (a == null || b == null)
      return 0;

    int x = a.x - b.x;
    int y = a.y - b.y;

    return Math.sqrt(x * x + y * y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
    objectsCreated += 1;
  }

  public Point() {
    this(0, 0);
  }

  boolean equals(Point p) {
    return p.x == this.x && p.y == this.y;
  }

  public Point add(Point p) {
    return new Point(this.x + p.x, this.y + p.y);
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("Point: ");
    builder.append(this.x + ", ");
    builder.append(this.y);

    return builder.toString();
  }
}
