package Module8;

interface Drawable {
    default void draw(){
        System.out.println(this.getClass().getSimpleName() + " is drawn!");
    }
}
