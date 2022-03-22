package Chapter3.Section2;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;           // 键
        private Value val;          // 值
        private Node left, right;   // 指向子树的节点
        private int N;              // 以节点为根的子树中的节点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", N=" + N +
                    '}';
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // 在以x为根节点的子树中查找并返回key所对应的值
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        // 查找key,找到则更新它的值,否则为它创建一个新的节点
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        // 如果key存在于以x为根节点的子树中则更新它的值;
        // 否则将以key和val为键值对的新节点插入到该子树中
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    // 254页测试用例
    public static void main(String[] args) {
        BST bst = new BST();
        bst.put('S', 0);
        bst.put('E', 1);
        bst.put('A', 2);
        bst.put('R', 3);
        bst.put('C', 4);
        bst.put('H', 5);
        bst.put('E', 6);
        bst.put('X', 7);
    }
}
