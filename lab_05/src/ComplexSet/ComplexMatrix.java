package ComplexSet;

public class ComplexMatrix {
  private ComplexNumber[][] container;

  public ComplexMatrix(int rows, int cols) {
    this.container = new ComplexNumber[rows][cols];
  }

  public ComplexMatrix(int rows, int cols, ComplexNumber[] numbers) {
    this(rows, cols);

    if (rows * cols != numbers.length)
      throw new Error("Number of columns and rows doesn't match the length of the given array");

    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        this.container[i][j] = numbers[i * rows + j];
  }

  public ComplexMatrix(ComplexNumber[][] container) {
    this.container = container;
  }

  public ComplexMatrix() {
    this(0, 0);
  }

  public ComplexMatrix add(ComplexMatrix a) {
    if (this.getRowsCount() != a.getRowsCount())
      return null;
    if (this.getColsCount() != a.getColsCount())
      return null;

    ComplexMatrix result = new ComplexMatrix(a.getRowsCount(), a.getColsCount());

    for (int i = 0; i < this.getRowsCount(); i++)
      for (int j = 0; j < this.getColsCount(); j++)
        result.setElement(i, j, this.getElement(i, j).add(a.getElement(i, j)));
    return result;
  }

  public ComplexMatrix subtract(ComplexMatrix a) {
    if (this.getRowsCount() != a.getRowsCount())
      return null;
    if (this.getColsCount() != a.getColsCount())
      return null;

    ComplexMatrix result = new ComplexMatrix(a.getRowsCount(), a.getColsCount());

    for (int i = 0; i < this.getRowsCount(); i++)
      for (int j = 0; j < this.getColsCount(); j++)
        result.setElement(i, j, this.getElement(i, j).subtract(a.getElement(i, j)));
    return result;
  }

  public ComplexMatrix multiply(ComplexMatrix a) {
    if (this.getColsCount() != a.getRowsCount())
      throw new Error("Matrices cannot be multiplied");

    ComplexMatrix result = new ComplexMatrix(this.getRowsCount(), a.getColsCount());

    for (int i = 0; i < result.getRowsCount(); i++) {
      for (int j = 0; j < result.getColsCount(); j++) {
        ComplexNumber partial = new ComplexNumber(0, 0);

        for (int k = 0; k < this.getColsCount(); k++)
          partial = partial.add(this.getElement(i, k).multiply(a.getElement(k, j)));
        result.setElement(i, j, partial);
      }
    }

    return result;
  }

  public ComplexMatrix multiply(double scalar) {
    ComplexMatrix result = new ComplexMatrix(this.getRowsCount(), this.getColsCount());

    for (int i = 0; i < this.getRowsCount(); i++)
      for (int j = 0; j < this.getColsCount(); j++)
        result.setElement(i, j, this.getElement(i, j).multiply(scalar));

    return result;
  }

  public ComplexNumber getElement(int i, int j) {
    if (i < 0 || j < 0
        || i >= this.getRowsCount() || j > this.getColsCount())
      throw new ArrayIndexOutOfBoundsException();

    return this.container[i][j];
  }

  public void setElement(int i, int j, ComplexNumber nbr) {
    if (i < 0 || j < 0
        || i >= this.getRowsCount() || j > this.getColsCount())
      throw new ArrayIndexOutOfBoundsException();

    this.container[i][j] = nbr;
  }

  public int getRowsCount() {
    if (this.container == null)
      return 0;
    return this.container.length;
  }

  public int getColsCount() {
    if (this.getRowsCount() == 0)
      return 0;
    return this.container[0].length;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("@ComplexMatrix with size ");
    builder.append(this.getRowsCount());
    builder.append(" x ");
    builder.append(this.getColsCount());
    builder.append('\n');

    for (int i = 0; i < this.getRowsCount(); i++) {
      for (int j = 0; j < this.getColsCount(); j++) {
        builder.append(this.getElement(i, j));
        builder.append(' ');
      }
      builder.append('\n');
    }
    return builder.toString();
  }
}
