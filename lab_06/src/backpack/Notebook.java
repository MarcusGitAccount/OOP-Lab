package backpack;

public class Notebook extends Requisite {
  public Notebook(String label) {
    super(label);
  }

  @Override
  public String getName() {
    StringBuilder builder = new StringBuilder();

    builder.append("@Notebook: ");
    builder.append(getLabel());

    return builder.toString();
  }
}
