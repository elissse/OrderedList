package org.example;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    Node() {}

    @Override
    public int compareTo(Node<T> n) {
        return value.compareTo(n.value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
