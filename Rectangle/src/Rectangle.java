public class Rectangle {
  public Point getCorner() {
    return corner;
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  private Point corner;
  private int length;
  private int width;
  public static final int DIM = 200;

  public static boolean isValid(Rectangle rect) {
    return rect.length > 0 && rect.width > 0;
  }

  public boolean isMagic() {
    // origin is inside the given rectangle's surface
    if (!isValid(this))
      return false;

    int x = this.corner.getX();
    int y = this.corner.getY();

    if (!(x < 0 && x + this.length > 0))
      return false;
    if (!(y < 0 && y + this.width > 0))
      return false;
    return true;
  }

  public Rectangle(Point corner, int length, int width) {
    this.corner = corner;
    this.length = length;
    this.width = width;
  }

  public Rectangle() {
    this(Point.ORIGIN, 1, 1);
  }
}
