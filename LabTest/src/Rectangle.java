public class Rectangle extends GeometricalShape {
  // represents the top-left corner of the rectangle
  private int length;
  private int width;

  public Rectangle(Point center, int length, int width) {
    this.setCenter(center);
    this.length = length;
    this.width  = width;
  }

  public Rectangle() {
    this(Point.ORIGIN, 1, 1);
  }

  @Override
  public boolean hasOrigin() {
    Point bottom = this.getCenter().add(new Point(length, width).multiply(-1));

    if (!(this.getCenter().getX() < 0 && this.getCenter().getY() > 0))
      return false;
    if (!(bottom.getX() > 0 && bottom.getY() < 0))
      return false;
    return true;
  }

  @Override
  public double calculateArea() {
    return this.length * this.width;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("@Rectangle: ");
    builder.append(this.getCenter());
    builder.append(" ");
    builder.append(this.length);
    builder.append(" ");
    builder.append(this.width);

    return builder.toString();
  }
}
