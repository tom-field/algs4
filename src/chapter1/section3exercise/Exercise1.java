package chapter1.section3exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1 {

    public static void main(String[] args) {
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack(2);
        StdOut.println("Is Full 1: " + fixedCapacityStack.isFull() + " Expected: false");

        fixedCapacityStack.push("a");
        fixedCapacityStack.push("b");
        StdOut.println("Is Full 2: " + fixedCapacityStack.isFull() + " Expected: true");
    }
}

class FixedCapacityStack<T> {
    private T[] a;
    private int N;
    public FixedCapacityStack(int cap) {
        a = (T[])new Object[cap];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void push(T item) {
        a[N++] = item;
    }
    public T pop() {
        return a[--N];
    }
    public boolean isFull() { return N == a.length; }
}
