package Chapter1_3;
import java.util.Iterator;

public class Bag<Item> implements Iterable {
    private Node first;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public void add(Item item) {
        // oldFirst的地址指向的也是first指向的地址,
        // 这时两个地址都指向了一块内存区
        Node oldFirst = first;
        // 改变first的指向
        // 将数据写入first指向的内存区
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
    }


    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
}
