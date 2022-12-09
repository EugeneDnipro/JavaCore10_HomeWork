package Module9;

public class TestMyCollections {
    public static void main(String[] args) {
        MyArrayList<String> digits = new MyArrayList<String>();
        digits.add("One");
        digits.add("Two");
        digits.add("Three");
        digits.add("Four");
        digits.add("Five");

        digits.printAllMyArrayList();
        System.out.println("digits.size() = " + digits.size());
        System.out.println("digits.get(2) = " + digits.get(2));
        digits.remove(0);
        digits.printAllMyArrayList();
        System.out.println("digits.size() = " + digits.size());
        digits.clear();
        digits.printAllMyArrayList();
        System.out.println("digits.size() = " + digits.size());
    }
}
