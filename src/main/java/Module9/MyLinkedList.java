package Module9;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        size = 0;
    }

    public void add(E value){
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public E get(int index){
        validateIndex(index);
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.item;
    }

    public void remove(int index){
        validateIndex(index);
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }

    public void clear(){
        Node<E> x = first;
        while (x != null){
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public void printAllMyLinkedList() {
        Node<E> x = first;
        for (int i = 0; i < size; i++){
            System.out.println(x.item);
            x = x.next;
        }
    }

    private void validateIndex (int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Illegal index: "+ index);
        }
    }
}
