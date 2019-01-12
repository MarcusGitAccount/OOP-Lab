package employee_activity;

public class Employee {
  private String firstName;
  private String lastName;
  private WorkingCalendar calendar;

  public Employee(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.calendar = new WorkingCalendar();
  }

  public boolean isWorking(String dayName) throws NonExistingDayException {
    for (WorkingDay day: calendar.getWorkingDays()) {
      if (day.getName() == dayName)
        return day.isWorkinDay();
    }

    throw new NonExistingDayException();
  }

  public static void main(String[] args) throws NonExistingDayException {
    Employee worker = new Employee("Jack", "John");

    try {
      System.out.println(worker.isWorking("January"));
    } catch (NonExistingDayException e) {
      System.out.println(e.getMessage());
    }
  }
}
