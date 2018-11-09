package backpack;

public abstract class Requisite {
  private String label;

  public String getLabel() {
    return label;
  }

  public Requisite(String label) {
    this.label = label;
  }

  public abstract String getName();
}
