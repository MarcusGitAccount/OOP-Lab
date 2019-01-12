package files_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class Filelistsort {
  //======================================================= main
  public static void main(String[] args) {
    Comparator<File> byDirThenAlpha = new DirAlphaComparator();
    Comparator<File> byNameLength = new NameLengthComparator();

    File dir = new File(System.getProperty("user.home"));
    File[] children = dir.listFiles();
    System.out.println("Fisierele dupa director, apoi alfabetic ");
    Arrays.sort(children, byDirThenAlpha);
    printFileNames(children);

    System.out.println("Fisierele dupa lungimea numelui lor (cel mai lung primul)");
    Arrays.sort(children, byNameLength);
    printFileNames(children);
  }

  //============================================= printFileNames
  private static void printFileNames(File[] fa){
    for (File oneEntry : fa) {
      System.out.println(" " + oneEntry.getName());
    }
  }
}