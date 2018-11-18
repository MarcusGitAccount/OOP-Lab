package utils;

public class Vector {
  public static final Vector ORIGIN = new Vector(0, 0);
  private int i, j;

  public Vector(int i, int j) {
    this.i = i;
    this.j = j;
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

  public boolean equals(Vector v) {
    return (i == v.i && j == v.j);
  }

  // Returns the vector with i, j from set {-1, 1, 0}
  public Vector unit() {
    int _i = i;
    int _j = j;

    if (i != 0)
      _i /= Math.abs(i);
    if (j != 0)
      _j /= Math.abs(j);
    return new Vector(_i, _j);
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
