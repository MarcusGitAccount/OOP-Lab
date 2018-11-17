public class Circle extends GeometricalShape {
  private int radius;

  public Circle(Point center, int radius) {
    this.setCenter(center);
    this.radius = radius;
  }

  public Circle() {
    this(Point.ORIGIN, 1);
  }

  @Override
  public boolean hasOrigin() {
    // Check whether distance from center to origin is less than
    // the circle's radius

    double distance = Point.ORIGIN.distance(this.getCenter());

    if (distance < this.radius)
      return true;
    return false;
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  public int getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("@Circle: ");
    builder.append(this.getCenter());
    builder.append(" ");
    builder.append(this.radius);
    return builder.toString();
  }
}
