package chapter1.section3exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    // 1.3.20 删除链表的第k个元素
    public void delete(int k) {
        if (k <= n) {
            Node<Item> currentNode = first;
            for (int i = 0; i != (k -1); i++) {
                currentNode = currentNode.next;
                n--;
            }
            currentNode.next = currentNode.next.next;
        } else {
            throw new StackOverflowError("元素越界");
        }
    }

    // 1.3.21 查找字符串key
    public Boolean find(String k) {
        // for遍历
        // Node<Item> currentNode;
        // for ( currentNode = first; currentNode != null; currentNode = currentNode.next) {
        //     if (currentNode.item.equals(k)) {
        //         return true;
        //     }
        // }
        // return false;

        // while遍历
        Node<Item> currentNode = first;
        while (currentNode != null) {
            if (currentNode.item.equals(k)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // 1.3.24 接受一个链表节点并删除该节点的后续节点
    public void removeAfter(Node<Item> x) {
        if (x == null || x.next == null) {
            return;
        }
        Node current = x.next;
        Node next = current.next;
        x.next = null;
        while (current.next != null) {
            current.next = null;
            current = next;
            next = next.next;
        }
    }

    // 1.3.25
    public void insertAfter(Node<Item> x, Node<Item> y) {
        if (x == null || y == null) {
            return;
        }
        y.next = x.next;
        x.next = y;
    }

    // 1.3.26 删除节点数据是key的节点
    public void remove(Item key) {
        if (first == null) {
            return;
        }
        Node<Item> prevNode = first;
        Node<Item> currentNode = prevNode.next;
        while (currentNode != null) {
            if(currentNode.item.equals(key)) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        if (first.item.equals(key)) {
            first = first.next;
        }
    }

    // 1.3.27 返回链表中最大节点的值,假设其他都为正整数
    // public int max() {
    //     int max=0;//所有键为正整数,最小就为0了
    //     Node currentNode = first;
    //     while (currentNode != null) {
    //         if ((Integer) currentNode.item > max) {
    //             max = (Integer) currentNode.item;
    //         }
    //         currentNode = currentNode.next;
    //     }
    //     return max;
    // }

    // 1.3.28 1.3.27递归实现
    public int max(Node<Integer> first) {
        int max = 0;
        if (first == null) {
            return 0;
        }
        if (first.next == null) {
            return (Integer) first.item;
        }
        // 通过比较first与first.next的值
        if (first.next.item > first.item) {
            return max(first.next);
        } else {
            //去掉原来的first.next
            first.next = first.next.next;
            return max(first);
        }
    }

    // 1.3.30 将链表反转
    public Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    @Override // TODO
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stack.push(item);
        }
        StdOut.println("(" + stack.size() + " left on stack)");
        // 测试1.3.20
        stack.delete(2);
        StdOut.println("(" + stack.size() + " left on stack)");
        StdOut.println("存在not " + stack.find("not"));
        StdOut.println("存在hello " + stack.find("hello"));
        stack.removeAfter(stack.first.next);
        StdOut.println(stack);
        stack.push("x");
        stack.push("y");
        stack.push("z");
        stack.remove("y");
        StdOut.println(stack);

        Stack<Integer> numStack = new Stack<>();
        numStack.push(1);
        numStack.push(3);
        numStack.push(2);
//        StdOut.println("最大值：" + numStack.max());
//        StdOut.println("最大值：" + numStack.max(numStack.first));
        StdOut.println(numStack.reverse(numStack.first).item);
    }
}
