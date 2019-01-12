package person;

import java.awt.Color;

public class Car implements Cloneable{
  private String brand;
  private Color color;

  public Car(String brand, Color color) {
    this.brand = brand;
    this.color = color;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return (Car)super.clone();
  }

  public String getBrand() {
    return brand;
  }

  public Color getColor() {
    return color;
  }

  public void paint(Color newPaint) {
    this.color = newPaint;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder(brand);

    builder.append(" ");
    builder.append(color);
    return builder.toString();
  }
}
