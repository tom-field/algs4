package chapter1.section3exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise15 {

    private static void printItems(edu.princeton.cs.algs4.Queue<String> queue, int k) {
        int count = 0;

        for (String item : queue) {
            count++;

            if (count == queue.size() - (k - 1)) {
                StdOut.println(item);
                break;
            }
        }
    }

    // 示例: 3 "A B C D E F"
    public static void main (String[] args) {
        int k = Integer.parseInt(args[0]);

        String input = args[1];
        String[] stringsInput = input.split("\\s");

        edu.princeton.cs.algs4.Queue<String> queue = new Queue<>();

        for (String string : stringsInput) {
            queue.enqueue(string);
        }

        printItems(queue, k);
    }
}
