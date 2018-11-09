package backpack;

public class TestBackpack {
  public static void main(String[] args) {
    Backpack backpack = new Backpack();

    backpack.addIn(new Notebook("note-1"));
    backpack.addIn(new Notebook("note-2"));
    backpack.addIn(new Notebook("note-3"));

    backpack.addIn(new Textbook("textbook-1"));
    backpack.addIn(new Textbook("textbook-2"));
    backpack.addIn(new Textbook("textbook-3"));

    backpack.listItems();
    backpack.listNotebooks();
    backpack.listTextbooks();

    System.out.println(backpack.getNotebooksCount());
    System.out.println(backpack.getTextbooksCount());
    System.out.println(backpack.getRequisitesCount());
  }
}
