package vehicle;// Test for the Vehicle class

public class TestDrive {
  public TestDrive() {}

  public void run() {
    Vehicle subject = new Vehicle();

    subject.accelerate(10);
    subject.accelerate(15);
    System.out.println(subject);
    subject.accelerate(15);
    System.out.println(subject);
    subject.decelerate(35);
    System.out.println(subject);
    subject.stop();
    System.out.println(subject);

  }
}
