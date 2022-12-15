package Module9;

import java.util.Objects;

public class MyHashMap<K, V> {

    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash = " + hash +
                    ", key = " + key +
                    ", value = " + value + " HP" +
                    '}';
        }
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key) & (table.length - 1);
        if (table[index] == null) {
            table[index] = new Node<K, V>(hash(key), key, value, null);
            size++;
        } else if ((hash(table[index].key) == hash(key)) && (table[index].key.equals(key))) {
            table[index].value = value;
        } else {
            table[index].next = new Node<K, V>(hash(key), key, value, null);
            size++;
        }
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = hash(key) & (table.length - 1);
        Node<K, V> x = null;
        V result = null;
        if (table[index] == null) {
            return result;
        }
        if ((key != null && key.equals(table[index].key)) || ((key == null) && table[index] != null)) {
            result = table[index].value;
        } else if ((key != null) && (table[index].next != null)) {
            x = table[index].next;
            do {
                if (key.equals(x.key)) {
                    return x.value;
                }
                x = x.next;
            } while (x != null);
        }
        return result;
    }

    public void remove(K key) {
        int index = hash(key) & (table.length - 1);
        Node<K, V> x = null;
        Node<K, V> prev = null;
        Node<K, V> result = null;
        if ((table[index] == null) || ((key != null) && !(key.equals(table[index].key)) && (table[index].next == null))) {
            throw new IllegalArgumentException("There is no such element in this collection!");
        } else if (((key != null) && (key.equals(table[index].key)) && (table[index].next == null)) || ((key == null) && table[index] != null)) {
            table[index] = null;
            size--;
            return;
        }
        if ((key != null) && (table[index].next != null)) {
            x = table[index];
            do {
                if (key.equals(x.key)) {
                    result = x;
                    break;
                }
                prev = x;
                x = x.next;
            } while (x != null);
            if ((result != null) && (table[index].key.equals(result.key))) {
                table[index] = table[index].next;
            } else if ((prev != null) && (result != null)) {
                prev.next = result.next;
                result.next = null;
            }
            size--;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void printAllMyHashMap() {
        Node<K, V> x = null;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (table[i].next == null) {
                    System.out.println(table[i]);
                } else {
                    x = table[i];
                    do {
                        System.out.println(x);
                        x = x.next;
                    } while (x != null);
                }
            }
        }
    }
}
