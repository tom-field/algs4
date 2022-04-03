package chapter3.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

public class DeDup {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.print(key + " ");
            }
        }
    }
}
