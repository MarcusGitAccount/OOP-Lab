package employee_activity;

public class WorkingDay {
  private String name;
  private boolean isWorkingDay;

  public WorkingDay(String name, boolean isWorkinDay) {
    this.name = name;
    this.isWorkingDay = isWorkinDay;
  }

  public String getName() {
    return name;
  }

  public boolean isWorkinDay() {
    return isWorkingDay;
  }
}
