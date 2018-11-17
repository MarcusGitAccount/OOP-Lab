public class Point {
  public static final Point ORIGIN = new Point(0, 0);

  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
    this(0, 0);
  }

  public Point add(Point p) {
    return new Point(this.x + p.x, this.y + p.y);
  }

  // Multiply point by scalar
  public Point multiply(int scalar) {
    return new Point(this.x * scalar, this.y * scalar);
  }

  // Calculate distance to a given point
  public double distance(Point p) {
    int x = this.x - p.x;
    int y = this.y - p.y;

    return Math.sqrt(x * x + y * y);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
