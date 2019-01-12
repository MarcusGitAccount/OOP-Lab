package files_sort;
import java.io.*;

public class NameLengthComparator {
  // Interfata Comparator necesita definirea metodei compare.
  public int compare(File filea, File fileb) {
    int comp = fileb.getName().length() - filea.getName().length();
    if (comp != 0) {
      //... daca lungimile sunt diferite, am terminat.
      return comp;
    } else {
      //... daca lungimile sunt egale, sorteaza alfabetic.
      return filea.getName().compareToIgnoreCase(fileb.getName());
    }
  }
}
