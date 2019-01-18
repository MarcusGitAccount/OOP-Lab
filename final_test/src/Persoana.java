import javax.swing.plaf.ButtonUI;
import java.util.ArrayList;
import java.util.HashSet;

public class Persoana {
  private String nume;
  private HashSet<Carte> cartiImprumutate;

  public Persoana(String nume) {
    this.nume = nume;
    this.cartiImprumutate = new HashSet<>();
  }

  public HashSet<Carte> getCartiImprumutate() {
    return cartiImprumutate;
  }

  public void inapoiazaCarti() {
    for (Carte carte: cartiImprumutate)
      carte.setNumarExemplare(carte.getNumarExemplare() + 1);
    this.cartiImprumutate.clear();
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  @Override
  public int hashCode() {
    return this.nume.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append(nume);
    builder.append("\nCarti imprumutate:\n");
    for (Carte carte: cartiImprumutate) {
      builder.append(carte.toString());
      builder.append("\n");
    }
    return builder.toString();
  }
}
