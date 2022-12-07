package Module8;

class Rectangle extends Shape {
    public Rectangle(String name) {
        className = name;
    }

    public void draw(){
        System.out.println("ShapeName = " + className);
    }

}
