package backpack;

public class Backpack {
  private Requisite[] requisites;

  public Backpack() {
    this.requisites = new Requisite[0];
  }

  public void addIn(Requisite newRequisite) {
    Requisite[] container = new Requisite[this.requisites.length + 1];

    System.arraycopy(this.requisites, 0, container, 0, this.requisites.length);
    container[this.requisites.length] = newRequisite;
    this.requisites = container;
  }

  public void listItems() {
    for (Requisite requisite: requisites) {
      System.out.println(requisite.getName());
    }
  }

  public void listNotebooks() {
    for (Requisite requisite: requisites) {
      if (requisite instanceof Notebook)
        System.out.println(requisite.getName());
    }
  }

  public void listTextbooks() {
    for (Requisite requisite: requisites) {
      if (requisite instanceof Textbook)
        System.out.println(requisite.getName());
    }
  }

  public int getRequisitesCount() {
    return this.requisites.length;
  }

  public int getTextbooksCount() {
    int count = 0;

    for (Requisite requisite: requisites) {
      if (requisite instanceof Textbook)
        count++;
    }

    return count;
  }

  public int getNotebooksCount() {
    int count = 0;

    for (Requisite requisite: requisites) {
      if (requisite instanceof Notebook)
        count++;
    }

    return count;
  }
}
