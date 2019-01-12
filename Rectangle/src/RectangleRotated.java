public class RectangleRotated extends Rectangle {
  public double getAlpha() {
    return alpha;
  }

  private double alpha;

  public RectangleRotated(Point corner, int length, int width, double alpha) {
    super(corner, length, width);
    this.alpha = alpha;
  }

  public RectangleRotated() {
    super();
    this.alpha = 0;
  }

  public boolean isMagic() {
    if (!Rectangle.isValid((this)))
      return false;

    Point corner = this.getCorner();
    Point top = corner.add(new Point(this.getLength(), this.getWidth()));
    double distance = Point.distance(corner, top);

    return distance == (int)distance;
  }
}
