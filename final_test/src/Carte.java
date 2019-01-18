public class Carte implements Comparable{
  private String titlu;
  private String numeAutor;
  private int numarExemplare;

  public Carte(String titlu, String numeAutor, int numarExemplare) {
    this.titlu = titlu;
    this.numeAutor = numeAutor;
    this.numarExemplare = numarExemplare;
  }

  @Override
  public int compareTo(Object o) {
    Carte carte = (Carte)o;
    int cmp = this.numeAutor.compareTo(carte.getNumeAutor());

    if (cmp == 0)
      return this.titlu.compareTo(carte.getTitlu());
    return cmp;
  }

  @Override
  public int hashCode() {
    return this.titlu.hashCode();
  }

  public String getTitlu() {
    return titlu;
  }

  public void setTitlu(String titlu) {
    this.titlu = titlu;
  }

  public String getNumeAutor() {
    return numeAutor;
  }

  public void setNumeAutor(String numeAutor) {
    this.numeAutor = numeAutor;
  }

  public int getNumarExemplare() {
    return numarExemplare;
  }

  public void setNumarExemplare(int numarExemplare) {
    this.numarExemplare = numarExemplare;
  }

  @Override
  public String toString() {
    return "Carte{" +
        "titlu='" + titlu + '\'' +
        ", numeAutor='" + numeAutor + '\'' +
        ", numarExemplare=" + numarExemplare +
        '}';
  }
}

