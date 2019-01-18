import java.util.*;

public class Biblioteca {
  private TreeMap<String, Carte> cartiExistente;
  private TreeSet<Carte> carti;
  private HashSet<Persoana> utilizatoriCareAuImprumuturi;

  public Biblioteca() {
    this.cartiExistente = new TreeMap<>();
    this.carti = new TreeSet<>();
    this.utilizatoriCareAuImprumuturi = new HashSet<>();
  }

  public void adaugaCarte(Carte carte) {
    this.cartiExistente.put(carte.getTitlu(), carte);
    this.carti.add(carte);
  }

  public void imprumuta(String titlu, Persoana utilizator) throws CarteIndisponibilaException, ImprumutMultipluException{
    Carte carte = this.cartiExistente.get(titlu);

    if (carte.getNumarExemplare() > 0) {
      if (utilizator.getCartiImprumutate().contains(carte)) {
        String message = utilizator.getNume() + " a imprumutat deja " + carte.getTitlu() + " scrisa de " + carte.getNumeAutor();
        throw new ImprumutMultipluException(message);
      }

      carte.setNumarExemplare(carte.getNumarExemplare() - 1);
      utilizator.getCartiImprumutate().add(carte);
    }
    else {
      String messeage = "Cartea " + carte.getTitlu() + " scrisa de " + carte.getNumeAutor() + " nu este disponibila";
      throw new CarteIndisponibilaException(messeage);
    }
    this.utilizatoriCareAuImprumuturi.add(utilizator);
  }

  public void inapoiazaCarti(Persoana utilizator) {
    if (!this.utilizatoriCareAuImprumuturi.contains(utilizator))
      return;
    if (utilizator.getCartiImprumutate().size() == 0)
      return;
    utilizator.inapoiazaCarti();
    this.utilizatoriCareAuImprumuturi.remove(utilizator);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("Bibioteca:\n");
    for (Carte carte: carti) {
      builder.append(carte.toString());
      builder.append("\n");
    }
    builder.append("Utilizatori care au carti imprumutate:\n");
    for (Persoana utilizator: utilizatoriCareAuImprumuturi) {
      builder.append(utilizator.toString());
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    Biblioteca library = new Biblioteca();

    library .adaugaCarte(new Carte("Morometii", "Marin Preda", 2));
    library .adaugaCarte(new Carte("Baltagul", "Mihail Sadoveanu", 1));
    library .adaugaCarte(new Carte("Cel mai iubit dintre pamanteni", "Marin Preda", 1));
    library .adaugaCarte(new Carte("Ion", "Liviu Rebreanu", 3));

    Persoana mihai = new Persoana("Mihai");
    Persoana ana = new Persoana("Ana");

    try {
      library.imprumuta("Morometii", mihai);
      library.imprumuta("Baltagul", mihai);
      library.imprumuta("Baltagul", ana);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      library.imprumuta("Ion", ana);
      library.imprumuta("Ion", ana);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(library);
    library.inapoiazaCarti(ana);
    System.out.println(library);
  }
}
