package exceptions_errors;

public class Operations {
  private int left, right;

  public int getLeft() {
    return left;
  }

  public void setLeft(int left) {
    this.left = left;
  }

  public int getRight() {
    return right;
  }

  public void setRight(int right) {
    this.right = right;
  }

  public Operations(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int div() {
    if (right == 0)
      throw new ArithmeticException();
    if (left == 0)
      throw new CustomException("Both zero, ew");
    return left / right;
  }

  public int add() throws EqualNumbersException, EvenNumberException {
    if (left == right)
      throw new EqualNumbersException();

    try {
      this.div();
    } catch (Exception e) {
      throw e;
    }

    if (right % 2 == 1)
      throw new EvenNumberException();

    return left + right;
  }

  @Override
  public String toString() {
    return "Operations{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}
