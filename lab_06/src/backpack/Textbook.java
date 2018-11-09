package backpack;

public class Textbook extends Requisite {
  public Textbook(String label) {
    super(label);
  }

  @Override
  public String getName() {
    StringBuilder builder = new StringBuilder();

    builder.append("@Textbook: ");
    builder.append(getLabel());

    return builder.toString();
  }
}
