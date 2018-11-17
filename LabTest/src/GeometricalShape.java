public abstract class GeometricalShape {
  private Point center;

  public abstract boolean hasOrigin();

  public abstract double calculateArea();

  public Point getCenter() {
    return center;
  }

  public void setCenter(Point center) {
    this.center = center;
  }
}
