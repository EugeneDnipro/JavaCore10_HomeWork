package Module9;

public class MyHashMap<K, V> {

    private Node<K, V> first;
    private int size;

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key = " + key +
                    ", value = " + value + " HP" +
                    '}';
        }
    }

    public MyHashMap() {
        size = 0;
    }

    public void put(K key, V value) {
        validateKeyForPut(key);
        Node<K, V> f = first;
        Node<K, V> newNode = new Node<K, V>(key, value, f);
        first = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> x = first;
        V result = null;
        for (int i = 0; i < size; i++) {
            if (key.equals(x.key)) {
                result = x.value;
                break;
            }
            x = x.next;
        }
        return result;
    }

    public void remove(K key) {
        validateKeyForRemove(key);
        Node<K, V> x = first;
        Node<K, V> result = null;
        Node<K, V> prev = null;
        for (int i = 0; i < size; i++) {
            if (key.equals(x.key)) {
                result = x;
                break;
            }
            prev = x;
            x = x.next;
        }
        if (first.key.equals(result.key)) {
            first = first.next;
        } else {
            prev.next = result.next;
            result.next = null;
        }
        size--;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public void printAllMyHashMap() {
        Node<K, V> x = first;
        for (int i = 0; i < size; i++) {
            System.out.println(x);
            x = x.next;
        }
        System.out.println("=================================================");
    }

    private void validateKeyForPut(K key) {
        Node<K, V> x = first;
        for (int i = 0; i < size; i++) {
            if (x.key.equals(key)) {
                throw new IllegalArgumentException("There is already existing the node with such a key!");
            }
            x = x.next;
        }
    }

    private void validateKeyForRemove(K key) {
        Node<K, V> x = first;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!(x.key.equals(key))) {
                count++;
            }
            x = x.next;
        }
        if (count == size) {
            throw new IllegalArgumentException("There is no any node with such a key!");
        }
    }
}