package files_sort;
import java.io.File;

public class DirAlphaComparator {
  public int compare(File filea, File fileb) {
    //... Sorteaza directoarele inaintea fisierelor,
    // altfel alfabetic fara a tine seama de majuscule/minuscule.
    if (filea.isDirectory() && !fileb.isDirectory()) {
      return -1;
    } else if (!filea.isDirectory() && fileb.isDirectory()) {
      return 1;
    } else {
      return filea.getName().compareToIgnoreCase(fileb.getName());
    }
  }
}
