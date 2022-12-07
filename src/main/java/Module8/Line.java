package Module8;

class Line extends Shape {
    public Line(String name) {
        className = name;
    }

    public void draw(){
        System.out.println("ShapeName = " + className);
    }

}
