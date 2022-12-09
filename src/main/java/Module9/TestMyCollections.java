package Module9;

public class TestMyCollections {
    public static void main(String[] args) {
//        MyArrayList<String> digits = new MyArrayList<String>();
//        digits.add("One");
//        digits.add("Two");
//        digits.add("Three");
//        digits.add("Four");
//        digits.add("Five");
//
//        digits.printAllMyArrayList();
//        System.out.println("digits.size() = " + digits.size());
//        System.out.println("digits.get(2) = " + digits.get(2));
//        digits.remove(0);
//        digits.printAllMyArrayList();
//        System.out.println("digits.size() = " + digits.size());
//        digits.clear();
//        digits.printAllMyArrayList();
//        System.out.println("digits.size() = " + digits.size());

        MyLinkedList<String> digitsMLL = new MyLinkedList<String>();
        digitsMLL.add("One");
        digitsMLL.add("Two");
        digitsMLL.add("Three");
        digitsMLL.add("Four");
        digitsMLL.add("Five");

        digitsMLL.printAllMyLinkedList();
        System.out.println("digitsMLL.size() = " + digitsMLL.size());
        System.out.println("digitsMLL.get(0) = " + digitsMLL.get(0));
        digitsMLL.remove(0);
        digitsMLL.printAllMyLinkedList();
        System.out.println("digitsMLL.size() = " + digitsMLL.size());
        digitsMLL.clear();
        digitsMLL.printAllMyLinkedList();
        System.out.println("digitsMLL.size() = " + digitsMLL.size());
    }
}
