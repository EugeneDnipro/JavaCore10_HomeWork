package Module8;

class Quad extends Shape {
    public Quad(String name) {
        className = name;
    }

    public void draw(){
        System.out.println("ShapeName = " + className);
    }

}
