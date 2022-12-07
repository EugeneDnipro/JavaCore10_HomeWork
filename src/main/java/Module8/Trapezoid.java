package Module8;

class Trapezoid extends Shape {
    public Trapezoid(String name) {
        className = name;
    }

    public void draw(){
        System.out.println("ShapeName = " + className);
    }

}
