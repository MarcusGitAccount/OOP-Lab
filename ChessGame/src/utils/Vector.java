package utils;

public class Vector {
  public static final Vector ORIGIN = new Vector(0, 0);
  private int i, j;

  public Vector(int i, int j) {
    this.i = i;
    this.j =  j;
  }

  public Vector() {
    this(0, 0);
  }

  public Vector add(Vector v) {
    return new Vector(this.i + v.i, this.j + v.j);
  }

  public Vector multiply(int scalar) {
    return new Vector(this.i * scalar, this.j * scalar);
  }

  public double magnitude(Vector v) {
    return Math.sqrt(i * i + j * j);
  }

  public Vector absComponents() {
    return new Vector(Math.abs(i), Math.abs(j));
  }

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public int getJ() {
    return j;
  }

  public void setJ(int j) {
    this.j = j;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("(");
    builder.append(i);
    builder.append(", ");
    builder.append(j);
    builder.append(")");
    return builder.toString();
  }
}
