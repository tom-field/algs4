package chapter1.section3exercise;

import java.util.Iterator;

public class Exercise28<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int size;
    private Node first;

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
    }

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
    
    public int max() {
        if (isEmpty()) {
            return 0;
        }
        int currentMaxValue = (Integer) first.item;
        return getMax(first, currentMaxValue);
    }

    private int getMax(Node currentNode,int currentMaxValue) {
        if (currentNode == null) {
            return currentMaxValue;
        }
        int currentValue = (Integer) currentNode.item;
        if (currentValue > currentMaxValue) {
            currentMaxValue = currentValue;
        }
        return getMax(currentNode.next, currentMaxValue);
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

    public static void main(String[] args) {
        Exercise28<Integer> list = new Exercise28<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.max());
    }
}



