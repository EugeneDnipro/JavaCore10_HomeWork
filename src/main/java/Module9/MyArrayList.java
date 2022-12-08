package Module9;

import java.util.Arrays;

public class MyArrayList<E> {

    private int size;
    private Object[] elementsStorage;
    private static final Object[] empty = {};

    public MyArrayList() {
        this.elementsStorage = empty;
        size = 0;
    }

    public void add(Object value){
        elementsStorage = Arrays.copyOf(elementsStorage, size + 1);
        elementsStorage[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public E get(int index){
        return (E) elementsStorage[index];
    }

    public void remove(int index){
        if (index < 0 || index >= elementsStorage.length){
            System.out.println("Index is incorrect!");
        } else {
            for (int i = 0; i < elementsStorage.length; i++) {
                if (i == index) {
                    for (int j = i; j < elementsStorage.length - 1; j++) {
                        elementsStorage[j] = elementsStorage[j + 1];
                    }
                    break;
                }
            }
            size -= 1;
            elementsStorage = Arrays.copyOf(elementsStorage, size);
        }
    }

    public void clear(){
        elementsStorage = Arrays.copyOf(elementsStorage, 0);
        size = 0;
    }

    public void printAllMyArrayList () {
        for(Object item: elementsStorage) {
            System.out.println(item);
        }
    }
}
