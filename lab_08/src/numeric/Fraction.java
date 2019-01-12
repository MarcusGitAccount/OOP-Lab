package numeric;

public class Fraction implements Numeric{
  private int nominator;
  private int denominator;

  public Fraction(int nominator, int denominator) {
    this.nominator = nominator;
    this.denominator = denominator;
  }

  public int euler(int a, int b) {
    return 0;
  }

  public void toIrreducible() {

  }

  @Override
  public Numeric add(Numeric operand) {
    return null;
  }

  @Override
  public Numeric sub(Numeric operand) {
    return null;
  }

  @Override
  public Numeric mul(Numeric operand) {
    return null;
  }

  public int getNominator() {
    return nominator;
  }

  public void setNominator(int nominator) {
    this.nominator = nominator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }

  @Override
  public String toString() {
    return "";
  }
}
