package chapter1.section3exercise;

import java.util.Iterator;

public class Exercise19<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int size;
    private Node first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node current;
            for (current = first; current.next != null; current = current.next);

            Node newNode = new Node();
            newNode.item = item;
            current.next = newNode;
        }
        size++;
    }

    public void deleteLastNode() {
        if (!isEmpty()) {
            if (size == 1) {
                first = null;
            } else {
                Node current = first;
                for (int i = 0; i < size - 2; i++) {
                    current = current.next;
                }
                current.next = null;
            }

            size--;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder s = new StringBuilder();
            Node current = first;
            s.append(first.item);
            for (int i = 0; i < size - 1; i++) {
                current = current.next;
                s.append(current.item);
            }
            return s.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        Exercise19<String> list = new Exercise19<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        list.deleteLastNode();
        System.out.println(list);
    }
}



