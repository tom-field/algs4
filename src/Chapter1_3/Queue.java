package Chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

// 1.3 page(95) 先进先出队列
public class Queue<Item> implements Iterable {
    private Node first; // 指向最早添加的结点的链接
    private Node last;  // 指向最近添加的结点的链接
    private int N;      // 队列中的元素数量

    // 定义结点的嵌套类 
    private static class Node<Item> {
        private Item item;
        private Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    };
    
    public int size() {
        return N;
    };
    
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    };
    
    public Item dequeue() {
        Item item = (Item) first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        N--;
        return item;
    };
    
    @Override // TODO
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
