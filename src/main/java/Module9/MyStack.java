package Module9;

import java.util.Arrays;

public class MyStack<E> {

    private int size;
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] elementsStorage;

    public MyStack() {
        this.elementsStorage = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(Object value) {
        if (size == elementsStorage.length) {
            elementsStorage = Arrays.copyOf(elementsStorage, size * 2);
        }
        elementsStorage[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0)
            return null;
        return (E) elementsStorage[size - 1];
    }

    public void remove(int index) {
        validateIndex(index);
        int length = elementsStorage.length;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                for (int j = i; j < size - 1; j++) {
                    elementsStorage[j] = elementsStorage[j + 1];
                }
                break;
            }
        }
        elementsStorage[size - 1] = null;
        size--;
        if ((size <= length / 2) && (size + 1 > DEFAULT_CAPACITY)) {
            elementsStorage = Arrays.copyOfRange(elementsStorage, 0, length / 2);
        }
    }

    public E pop() {
        if (size == 0)
            return null;
        E last = (E) elementsStorage[size - 1];
        int length = elementsStorage.length;
        if ((size - 1 <= length / 2) && (size > DEFAULT_CAPACITY)) {
            elementsStorage = Arrays.copyOfRange(elementsStorage, 0, length / 2);
        } else {
            elementsStorage[size - 1] = null;
        }
        size--;
        return last;
    }

    public void clear() {
        elementsStorage = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void printAllMyStack() {
        for (Object item : elementsStorage) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println("======================================");
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
    }
}
