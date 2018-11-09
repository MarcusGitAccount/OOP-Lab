package ComplexSet;

public class ComplexNumber {
  private double imag;
  private double real;

  public ComplexNumber(double real, double imag) {
    this.real = real;
    this.imag = imag;
  }

  public ComplexNumber() {
    this(0, 0);
  }

  public ComplexNumber add(ComplexNumber a) {
    return new ComplexNumber(this.real + a.real, this.imag + a.imag);
  }

  public ComplexNumber subtract(ComplexNumber a) {
    return new ComplexNumber(this.real - a.real, this.imag - a.imag);
  }

  public ComplexNumber multiply(ComplexNumber a) {
    double real = this.real * a.real - this.imag * a.imag;
    double imag = this.real * a.imag + this.imag * a.real;

    return new ComplexNumber(real, imag);
  }

  public ComplexNumber multiply(double scalar) {
    return new ComplexNumber(this.real * scalar, this.imag * scalar);
  }

  public double abs() {
    return Math.sqrt(this.real * this.real + this.imag * this.imag);
  }

  public boolean equals(ComplexNumber a) {
    if (this.real != a.real)
      return false;
    if (this.imag != a.imag)
      return false;
    return true;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append('(');
    builder.append(this.real);
    builder.append(", ");
    builder.append(this.imag);
    builder.append(')');

    return builder.toString();
  }
}
