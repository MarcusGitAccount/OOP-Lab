package employee_activity;

public class WorkingCalendar {
  private WorkingDay[] workingDays;

  public WorkingCalendar() {
    workingDays = new WorkingDay[]{
        new WorkingDay("Monday", true),
        new WorkingDay("Tuesday", true),
        new WorkingDay("Wednesday", true),
        new WorkingDay("Thursday", true),
        new WorkingDay("Friday", true),
        new WorkingDay("Saturday", false),
        new WorkingDay("Sunday", false)
    };
  }

  public WorkingDay[] getWorkingDays() {
    return workingDays;
  }
}
