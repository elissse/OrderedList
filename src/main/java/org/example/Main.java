package org.example;

public class Main {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        list.addNode(1);
        list.addNode(8);
        list.addNode(3);
        list.addNode(9);
        list.addNode(0);
        list.printList();
        OrderedList<Character> listt = new OrderedList<>();
        listt.addNode('d');
        listt.addNode('a');
        listt.addNode('c');
        listt.addNode('b');
        listt.addNode('e');
        listt.printList();
    }
}