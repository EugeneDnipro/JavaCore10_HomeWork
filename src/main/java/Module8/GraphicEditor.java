package Module8;

public class GraphicEditor {
    public static void main(String[] args) {

        Quad quad = new Quad();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Line line = new Line();
        Trapezoid trapezoid = new Trapezoid();
        Triangle triangle = new Triangle();

        ShapeNamePrinter shapeNamePrinter = new ShapeNamePrinter();
        shapeNamePrinter.ShapeNamePrint(quad);
        shapeNamePrinter.ShapeNamePrint(circle);
        shapeNamePrinter.ShapeNamePrint(rectangle);
        shapeNamePrinter.ShapeNamePrint(line);
        shapeNamePrinter.ShapeNamePrint(trapezoid);
        shapeNamePrinter.ShapeNamePrint(triangle);

        ShapeDrawer shapePrinter = new ShapeDrawer();
        shapePrinter.ShapeDraw(quad);
        shapePrinter.ShapeDraw(circle);
        shapePrinter.ShapeDraw(rectangle);
        shapePrinter.ShapeDraw(line);
        shapePrinter.ShapeDraw(trapezoid);
        shapePrinter.ShapeDraw(triangle);

    }

}

interface Drawable {
    default void draw(){
        System.out.println(this.getClass().getSimpleName() + " is drawn!");
    }
}

abstract class Shape implements Drawable{
    public String getName() {
        return "Shape";
    }
}

class Circle extends Shape {
    public String getName() {
        return "Circle";
    }
}

class Quad extends Shape {
    public String getName() {
        return "Quad";
    }
}

class Rectangle extends Shape {
    public String getName() {
        return "Rectangle";
    }
}

class Line extends Shape {
    public String getName() {
        return "Line";
    }
}

class Trapezoid extends Shape {
    public String getName() {
        return "Trapezoid";
    }
}

class Triangle extends Shape {
    public String getName() {
        return "Triangle";
    }
}

class ShapeNamePrinter {
    public void ShapeNamePrint(Shape shape) {
        System.out.println(shape.getName());
    }
}

class ShapeDrawer {
    public void ShapeDraw(Shape shape) {
        shape.draw();
    }
}




