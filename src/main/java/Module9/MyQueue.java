package Module9;

import java.util.Arrays;

public class MyQueue<E> {

    private int size;
    private static final int defaultCapacity = 8;
    private Object[] elementsStorage;

    public MyQueue() {
        this.elementsStorage = new Object[defaultCapacity];
        size = 0;
    }

    public void add(Object value) {
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
        return (E) elementsStorage[0];
    }

    public E poll() {
        E first = (E) elementsStorage[0];
        int length = elementsStorage.length;
        if (size == 0)
            return null;
        if ((size - 1 <= length / 2) && (size > defaultCapacity)) {
            elementsStorage = Arrays.copyOfRange(elementsStorage, 1, length / 2 + 1);
        } else {
            elementsStorage = Arrays.copyOfRange(elementsStorage, 1, length + 1);
        }
        size--;
        return first;
    }

    public void clear() {
        elementsStorage = new Object[defaultCapacity];
        size = 0;
    }

    public void printAllMyQueue() {
        for (Object item : elementsStorage) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println("======================================");
    }
}

