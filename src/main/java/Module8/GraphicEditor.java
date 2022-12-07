package Module8;

public class GraphicEditor {
    public static void main(String[] args) {

        Shape quad = new Quad("Quad");
        Shape circle = new Circle("Circle");
        Shape rectangle = new Rectangle("Rectangle");
        Shape line = new Line("Line");
        Shape trapezoid = new Trapezoid("Trapezoid");
        Shape triangle = new Triangle("Triangle");

        ShapeDrawer.shapeDraw(quad);
        ShapeDrawer.shapeDraw(circle);
        ShapeDrawer.shapeDraw(rectangle);
        ShapeDrawer.shapeDraw(line);
        ShapeDrawer.shapeDraw(trapezoid);
        ShapeDrawer.shapeDraw(triangle);

    }

}







