package Module9;

public class TestMyCollections {
    public static void main(String[] args) {
//        MyArrayList<String> digits = new MyArrayList<String>();
//
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

//        MyLinkedList<String> digitsMLL = new MyLinkedList<String>();
//
//        digitsMLL.add("One");
//        digitsMLL.add("Two");
//        digitsMLL.add("Three");
//        digitsMLL.add("Four");
//        digitsMLL.add("Five");
//
//        digitsMLL.printAllMyLinkedList();
//        System.out.println("digitsMLL.size() = " + digitsMLL.size());
//        System.out.println("digitsMLL.get(0) = " + digitsMLL.get(0));
//        digitsMLL.remove(0);
//        digitsMLL.printAllMyLinkedList();
//        System.out.println("digitsMLL.size() = " + digitsMLL.size());
//        digitsMLL.clear();
//        digitsMLL.printAllMyLinkedList();
//        System.out.println("digitsMLL.size() = " + digitsMLL.size());

//        MyQueue<String> digitsMQ = new MyQueue<String>();
//
//        digitsMQ.add("One");
//        digitsMQ.add("Two");
//        digitsMQ.add("Three");
//        digitsMQ.add("Four");
//        digitsMQ.add("Five");
//
//        System.out.println("digitsMQ.size() = " + digitsMQ.size());
//        digitsMQ.printAllMyQueue();
//        System.out.println("digitsMQ.peek() = " + digitsMQ.peek());
//        System.out.println("digitsMQ.poll() = " + digitsMQ.poll());
//        System.out.println("digitsMQ.size() = " + digitsMQ.size());
//        digitsMQ.printAllMyQueue();
//        System.out.println("digitsMQ.poll() = " + digitsMQ.poll());
//        System.out.println("digitsMQ.size() = " + digitsMQ.size());
//        digitsMQ.printAllMyQueue();
//        digitsMQ.add("Six");
//        System.out.println("digitsMQ.size() = " + digitsMQ.size());
//        digitsMQ.printAllMyQueue();
//        digitsMQ.clear();
//        System.out.println("digitsMQ.size() = " + digitsMQ.size());
//        digitsMQ.printAllMyQueue();
//        digitsMQ.add("Seven");
//        System.out.println("digitsMQ.size() = " + digitsMQ.size());
//        digitsMQ.printAllMyQueue();

        MyStack<String> digitsMS = new MyStack<String>();

        digitsMS.push("One");
        digitsMS.push("Two");
        digitsMS.push("Three");
        digitsMS.push("Four");
        digitsMS.push("Five");

        System.out.println("digitsMS.size() = " + digitsMS.size());
        digitsMS.printAllMyStack();
        System.out.println("digitsMS.peek() = " + digitsMS.peek());
        digitsMS.remove(0);
        System.out.println("digitsMS.size() = " + digitsMS.size());
        digitsMS.printAllMyStack();
        System.out.println("digitsMS.pop() = " + digitsMS.pop());
        System.out.println("digitsMS.size() = " + digitsMS.size());
        digitsMS.printAllMyStack();
        System.out.println("digitsMS.pop() = " + digitsMS.pop());
        System.out.println("digitsMS.size() = " + digitsMS.size());
        digitsMS.printAllMyStack();
        digitsMS.clear();
        System.out.println("digitsMS.size() = " + digitsMS.size());
        digitsMS.printAllMyStack();
        digitsMS.push("Six");
        System.out.println("digitsMS.size() = " + digitsMS.size());
        digitsMS.printAllMyStack();
    }
}
