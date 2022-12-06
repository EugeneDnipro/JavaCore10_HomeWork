package Module8;

public class GraphicEditor {
    public static void main(String[] args) {

        Quad quad = new Quad();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Line line = new Line();
        Trapezoid trapezoid = new Trapezoid();
        Triangle triangle = new Triangle();

        ShapeNamePrinter.shapeNamePrint(quad);
        ShapeNamePrinter.shapeNamePrint(circle);
        ShapeNamePrinter.shapeNamePrint(rectangle);
        ShapeNamePrinter.shapeNamePrint(line);
        ShapeNamePrinter.shapeNamePrint(trapezoid);
        ShapeNamePrinter.shapeNamePrint(triangle);

        ShapeDrawer.shapeDraw(quad);
        ShapeDrawer.shapeDraw(circle);
        ShapeDrawer.shapeDraw(rectangle);
        ShapeDrawer.shapeDraw(line);
        ShapeDrawer.shapeDraw(trapezoid);
        ShapeDrawer.shapeDraw(triangle);

    }

}







