package person;

import java.util.Arrays;

public class Person implements Comparable{
  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public static void main(String[] args) {
    Person[] people = new Person[] {
        new Person("A1", "A2", 12),
        new Person("B1", "B2", 30),
        new Person("C1", "C2", 23),
    };

    Arrays.sort(people);
    // Arrays.sort(people, (Person a, Person b) -> a.firstName.compareTo(b.firstName));

    for (Person person: people)
      System.out.println(person);
  }

  @Override
  public int compareTo(Object o) {
    return this.age - ((Person)o).age;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append(this.firstName);
    builder.append(" ");
    builder.append(this.lastName);
    builder.append(" of age ");
    builder.append(this.age);
    return builder.toString();
  }
}
