package Module9;

import java.util.Arrays;

public class MyArrayList<E> {

    private int size;
    private Object[] elementsStorage;

    public MyArrayList() {
        this.elementsStorage = new Object[0];
        size = 0;
    }

    public void add(Object value) {
        elementsStorage = Arrays.copyOf(elementsStorage, size + 1);
        elementsStorage[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        validateIndex(index);
        return (E) elementsStorage[index];
    }

    public void remove(int index) {
        validateIndex(index);
        for (int i = 0; i < elementsStorage.length; i++) {
            if (i == index) {
                for (int j = i; j < elementsStorage.length - 1; j++) {
                    elementsStorage[j] = elementsStorage[j + 1];
                }
                break;
            }
        }
        size--;
        elementsStorage = Arrays.copyOf(elementsStorage, size);
    }

    public void clear() {
        elementsStorage = new Object[0];
        size = 0;
    }

    public void printAllMyArrayList() {
        for (Object item : elementsStorage) {
            System.out.println(item);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= elementsStorage.length) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
    }
}
