package vehicle;
import java.awt.Color;

// Basic class for a vehicle class
public class Vehicle {
  public static final int SPEED_PER_GEAR = 30;

  private int gear;
  private int speed;
  private int maxSpeed;
  private int gearsNumber;

  private String manufacturer;
  private Color color;

  private boolean isStarted = false;
  private Driver driver;
  private FuelTank fuelTank;

  public int getSpeed()       { return this.speed; }
  public int getGear()        { return this.gear; }
  public int getMaxSpeed()    { return  this.maxSpeed; }
  public int getGearsNumber() { return this.gearsNumber; }

  public Color getColor() { return this.color; }
  public String getManufacturer() { return this.manufacturer; }


  public Vehicle(int maxSpeed, int gearsNumber, String manufacturer,
                 Color color, FuelTank.FUEL_TYPE fuelType, int fuelTankCapacity) {
    this.maxSpeed = maxSpeed;
    this.gearsNumber = gearsNumber;
    this.manufacturer = manufacturer;
    this.color = color;

    this.fuelTank = new FuelTank(fuelTankCapacity, fuelType);
    this.driver   = null;
    this.speed = 0;
    this.gear  = 0; // 0 <=> neutral
  }

  public Vehicle() {
    this(60, 6, null, Color.BLACK, FuelTank.FUEL_TYPE.PETROL, 20);
  }

  public void accelerate(int speed) {
    if (!this.isStarted)
      return;

    int newSpeed = Math.min(this.speed + speed, this.maxSpeed);
    int gear = newSpeed / SPEED_PER_GEAR + 1;

    if (gear != this.gear)
      this.changeGear(gear);
    this.speed = speed;
  }

  public void decelerate(int speed) {
    if (!this.isStarted)
      return;

    int newSpeed = Math.max(this.speed - speed, 0);
    int gear = newSpeed / SPEED_PER_GEAR + 1;

    if (newSpeed == 0)
      this.changeGear(0);
    else if (gear != this.gear)
      this.changeGear(gear);
    this.speed = speed;
  }

  public void changeGear(int gear) {
    if (gear != this.gear &&
        (gear >= 0 && gear <= this.gearsNumber)) {
      this.gear = gear;
    }
  }

  public void changeDriver(Driver driver) {
    this.driver = driver;
  }

  public void start() {
    if (this.driver == null)
      throw new RuntimeException("No driver when trying to start the car.");
    this.isStarted = true;
  }

  public void stop() {
    this.decelerate(this.speed);
    this.changeGear(0);
    this.isStarted = false;
  }

  public void refuel(int fuelQuantity) {
    if (this.isStarted)
      throw new RuntimeException("Cannot refuel while car is opened.");
    this.fuelTank.fill(fuelQuantity);
  }

  public String toString() {
    StringBuilder result = new StringBuilder();

    result.append("\n@Vehicle:");
    result.append("\nSpeed: " + this.speed);
    result.append("\nGear: "  + this.gear);
    result.append("\nColor: " + this.color);
    result.append("\nManufacturer: " + this.manufacturer);
    result.append("\nGearsNumber: "  + this.gearsNumber);

    return result.toString();
  }

}
