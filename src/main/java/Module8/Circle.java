package Module8;

class Circle extends Shape {
    public Circle(String name) {
        className = name;
    }

    public void draw(){
        System.out.println("ShapeName = " + className);
    }

}
