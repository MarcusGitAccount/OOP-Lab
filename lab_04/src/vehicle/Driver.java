package vehicle;

public class Driver {
  private String firstName;
  private String lastName;
  private int age;
  private String licenseId;

  public Driver(String firstName, String lastName, int age, String licenseId) {
    this.firstName = firstName;
    this.lastName  = lastName;
    this.age       = age;
    this.licenseId = licenseId;
  }

  public Driver() {
    this("Default first_name", "Default last_name", 20, null);
  }

  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public int getAge() {
    return age;
  }
  public String getLicenseId() {
    return licenseId;
  }

  public void setLicenseId(String licenseId) {
    this.licenseId = licenseId;
  }
}
