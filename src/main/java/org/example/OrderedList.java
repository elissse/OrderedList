package org.example;

public class OrderedList<T extends Comparable<T>> {
    public Node<T> head;
    public Node<T> tail;
    public int length;

    OrderedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void addNodeEnd(Node<T> node) {
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
            this.head.next = node;
            this.tail.prev = node;
        } else {
            this.tail.next = node;
            this.head.prev = node;
            node.prev = tail;
            node.next = head;
            this.tail = node;
        }
    }

    public void addNodeBeg(Node<T> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            this.head.prev = node;
            this.tail.next = node;
        } else {
            this.tail.next = node;
            this.head.prev = node;
            node.prev = tail;
            node.next = head;
            this.head = node;
        }
    }

    public void addNode(T value) {
        Node<T> node = new Node<>(value);
        Node<T> current = head;
        if (head == null || node.compareTo(head) < 0) {
            addNodeBeg(node);
        } else if (tail == null || node.compareTo(tail) > 0) {
            addNodeEnd(node);
        } else {
            while (node.compareTo(current) > 0) {
                current = current.next;
            }
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }
        this.length++;
    }

    public Node<T> deleteNode(T value) {
        length--;
        if (head != null) {
            if (head.value.equals(value) & length == 0) {
                head = null;
                tail = null;
            } else if (head.value.equals(value)) {
                head.next.prev = tail;
                tail.next = head.next;
                head = tail.next;
                return tail;
            } else {
                Node<T> current = head;
                for (int i = 0; i <= length; i++) {
                    if (current.next.value.equals(value))
                        break;
                    current = current.next;
                }
                if (current.next.value.equals(value)) {
                    current.next.next.prev = current.next;
                    current.next = current.next.next;
                    return current;
                }
            }
        }
        return null;
    }

    public void printList() {
        Node<T> current = head;
        for (int i = 0; i < this.length; i++) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }


    public int getLength() {
        return this.length;
    }

    public void swap(Node<T> n1, Node<T> n2) {
        T tmp = n1.value;
        n1.value = n2.value;
        n2.value = tmp;
    }
}
