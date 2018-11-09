import ComplexSet.*;

public class Main {
  public static void main(String[] args) {
    ComplexNumber nbr = new ComplexNumber(8, -6);
    ComplexMatrix matrix = new ComplexMatrix(2, 2, new ComplexNumber[] {
        new ComplexNumber(1, 1),
        new ComplexNumber(2, 2),
        new ComplexNumber(3, 3),
        new ComplexNumber(4, 4),
    });

    System.out.println(nbr.equals(new ComplexNumber(8, -6)));
    System.out.println(nbr.abs());
    System.out.println(nbr.multiply(10).add(nbr));
    System.out.println(matrix);

    System.out.println(matrix.add(matrix));
    System.out.println(matrix.subtract(matrix));
    System.out.println(matrix.multiply(matrix));
    System.out.println(matrix.multiply(10));

  }
}
