package chapter1.section3exercise;

import java.util.Iterator;

public class Exercise26<Item> implements Iterable<Item> {

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

    public void remove(Item key) {
        if (isEmpty() || key == null) {
            return;
        }
        // 判断首节点
        while (first != null && first.item.equals(key)) {
            first = first.next;
            size--;
        }
        // 判断其他节点
        Node current;
        for (current = first; current != null; current = current.next) {
            Node next = current.next;
            while (next != null && next.item.equals(key)) {
                next = next.next;
                size--;
            }
            current.next = next;
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
            s.append(" 节点数量" + size());
            return s.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        Exercise26<String> list = new Exercise26<>();
        list.add("A");
        list.add("B");
        list.add("B");
        list.add("C");
        list.remove("B");
        System.out.println(list);
    }
}



