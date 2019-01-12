package person;

import java.awt.*;

// TODO: look into Copy Constructors for deep cloning
public class Student extends Person implements Cloneable {
  private Car car;

  public Student(String firstName, String lastName, int age, Car car) {
    super(firstName, lastName, age);
    this.car = car;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Student copy = (Student)super.clone();

    copy.car = (Car)this.car.clone();
    return copy;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());

    builder.append(" ");
    builder.append(car);
    return builder.toString();
  }

  public static void main(String[] args) {
    Student student = new Student("Name", "Last", 30, new Car("Porsche", Color.WHITE));
    Student copy;

    try {
      copy = (Student)student.clone();
      student.car.paint(Color.black);

      System.out.println(student);
      System.out.println(copy);
    } catch (Exception ex) {
      System.out.println(ex.getStackTrace());
    }


  }
}
