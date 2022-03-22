package Chapter3.Section1;

public class SequentialSearchST<Key, Value> {
    private Node first; // 链表首节点

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // 查找给定的值,返回相关的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val; // 命中
        }
        return null; // 未命中
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)){
                x.val = val; // 命中更新
                return;
            }
        }
        first = new Node(key, val, first); // 未命中, 新建节点
    }
}
