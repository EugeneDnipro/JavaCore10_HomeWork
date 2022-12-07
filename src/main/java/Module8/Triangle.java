package Module8;

class Triangle extends Shape {
    public Triangle(String name) {
        className = name;
    }

    public void draw(){
        System.out.println("ShapeName = " + className);
    }

}
