package numeric;

public class Complex implements Numeric{
  private float real;
  private float imag;

  public Complex(float real, float imag) {
    this.real = real;
    this.imag = imag;
  }

  @Override
  public Complex add(Numeric operand) {
    Complex op = (Complex)operand;

    return new Complex(real + op.real, imag + op.imag);
  }

  @Override
  public Complex sub(Numeric operand) {
    Complex op = (Complex)operand;

    return new Complex(real - op.real, imag - op.imag);
  }

  @Override
  public Complex mul(Numeric operand) {
    // (a, b) * (x, y) = ax + jay + jbx - by = (ax - by, ay + bx)
    // where j^ 2 = -1

    Complex op = (Complex)operand;

    return new Complex(real * op.real - imag * op.imag, real * op.imag + imag * op.real);
  }

  public Complex mul(int scalar) {
    return new Complex(real * scalar, imag * scalar);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append(real);
    builder.append(" ");
    builder.append(imag);
    return builder.toString();
  }
}
