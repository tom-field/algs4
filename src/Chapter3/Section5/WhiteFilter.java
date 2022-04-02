package Chapter3.Section5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

public class WhiteFilter {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.contains(word)) {
                StdOut.print(word + " ");
            }
        }
    }
}
