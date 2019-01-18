package interfaces;

import java.util.Arrays;

public class Shape implements Area, Cloneable {
  private Point top;
  private int length, width;

  public Shape(Point top, int length, int width) {
    this.top = top;
    this.length = length;
    this.width = width;
  }

  public Shape(Shape copy) {
    this(new Point(copy.getTop()), copy.getLength(), copy.getWidth());
  }

  public Shape() {
    this(Point.ZERO, 0, 0);
  }

  public Point getTop() {
    return top;
  }

  public void setTop(Point top) {
    this.top = top;
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
  public int area() {
    return this.length * this.width;
  }

  @Override
  public int compareTo(Object o) {
    return this.area() - ((Shape)o).area();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Shape copy =  (Shape)super.clone();

    copy.setTop((Point)this.getTop().clone());
    return copy;
  }

  @Override
  public String toString() {
    return "Shape{" +
        "top=" + top +
        ", length=" + length +
        ", width=" + width +
        '}';
  }

  public static void main(String[] args) {
    Shape rect = new Shape();
    Shape ract;

    try {
      ract = (Shape)rect.clone();
      ract.setTop(new Point(2, 3));

      System.out.println(rect);
      System.out.println(ract);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    Shape[] shapes = {
        new Shape(Point.ZERO, 1, 2),
        new Shape(Point.ZERO, 5, 1),
        new Shape(Point.ZERO, 10, 2)
    };

    Arrays.sort(shapes);

    for (Shape shape: shapes)
      System.out.println(shape);
  }
}
