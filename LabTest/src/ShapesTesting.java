public class ShapesTesting {
  private GeometricalShape[] shapes;

  public ShapesTesting() {
    this.shapes = new GeometricalShape[0];
  }

  public void addShape(GeometricalShape shape) {
    GeometricalShape[] newShapesContainer = new GeometricalShape[this.shapes.length + 1];

    // copy old elements into the new container
    for (int i = 0; i < this.shapes.length; i++)
      newShapesContainer[i] = this.shapes[i];
    // add the new shape
    newShapesContainer[this.shapes.length] = shape;
    this.shapes = newShapesContainer;
  }

  public void calculateAreas() {
    for (GeometricalShape shape: this.shapes) {
      if (shape == null || !shape.hasOrigin())
        continue;
      System.out.println(shape);
      System.out.print("Area: ");
      System.out.println(shape.calculateArea());
    }
    System.out.println();
  }

  public void calculateRectanglesAreas() {
    for (GeometricalShape shape: this.shapes) {
      if (shape == null || !(shape instanceof Rectangle))
        continue;
      System.out.println(shape);
      System.out.print("Area: ");
      System.out.println(shape.calculateArea());
    }
    System.out.println();
  }

  public void calculateCirclesAreas() {
    for (GeometricalShape shape: this.shapes) {
      if (shape == null || !(shape instanceof Circle))
        continue;
      System.out.println(shape);
      System.out.print("Area: ");
      System.out.println(shape.calculateArea());
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ShapesTesting test = new ShapesTesting();

    test.addShape(new Rectangle(new Point(2, 3), 5, 4));
    test.addShape(new Circle(Point.ORIGIN, 3));
    test.addShape(new Rectangle(new Point(-1, -1), 2, 3));
    test.addShape(new Circle(new Point(5, 5), 2));
    test.addShape(new Circle(new Point(1, 3), 7));

    test.calculateAreas();
    test.calculateCirclesAreas();
    test.calculateRectanglesAreas();
  }
}
