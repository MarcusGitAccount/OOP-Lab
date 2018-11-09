package vehicle;

public class FuelTank {
  public enum FUEL_TYPE {
    PETROL, DIESEL
  };

  private int capacity;
  private int quantity;
  private FuelTank.FUEL_TYPE fuelType;

  public FuelTank(int capacity, FuelTank.FUEL_TYPE fuelType) {
    this.capacity = capacity;
    this.fuelType = fuelType;
    this.quantity = 0;
  }

  public FuelTank() {
    this(0, FUEL_TYPE.PETROL);
  }

  public int getQuantity() {
    return quantity;
  }

  private void setQuantity(int quantity) {
    if (quantity <= this.capacity && quantity >= 0)
      this.quantity = quantity;
  }

  public void fill(int quantity) {
    this.setQuantity(this.quantity + quantity);
  }
}
