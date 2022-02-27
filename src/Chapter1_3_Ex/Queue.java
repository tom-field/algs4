package Chapter1_3_Ex;

// 1.3.29 环形链
public class Queue<Item> {
    private Node<Item> last;
    private int N;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void enqueue(Item item) {
        // 空队列
        if (last == null) {
            Node last = new Node();
            last.item = item;
            last.next = last;
        } else {
            Node currentNode = new Node();
            currentNode.item = item;
            currentNode.next = last.next;
            last.next = currentNode;
            last = currentNode;
        }
    }
}
