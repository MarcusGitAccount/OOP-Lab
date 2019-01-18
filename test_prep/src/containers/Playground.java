package containers;

import java.util.*;

public class Playground {
  public static void main(String[] args){
    HashMap<String, Integer> map = new HashMap<>();

    map.put("one", 1);
    map.put("two", 2);
    map.put("ten", 10);

    for (String key: map.keySet())
      System.out.println(map.get(key));

    Set<Map.Entry<String, Integer>> entries = map.entrySet();

    for (Map.Entry<String, Integer> entry: entries) {
      System.out.println(entry.getKey() + " " +  entry.getValue());
    }

    HashSet<Integer> set = new HashSet<Integer>() {{
      add(1);
      add(2);
      add(3);
      add(1);
    }};

    for (Integer entry: set) {
      System.out.println(entry);
    }

    for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
      System.out.println(it.next());
    }

    Integer[] table = new Integer[]{4, 3, 5, 2, 1};

    Arrays.sort(table, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.intValue() - o2.intValue();
      }
    });

    for (Integer item: table)
      System.out.print(item + " ");
  }
}
