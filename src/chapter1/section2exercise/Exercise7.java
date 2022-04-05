package chapter1.section2exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise7 {
    public static void main(String[] args) {

        String s = "hello world";

        StdOut.println(mystery(s));
        StdOut.println("Expected: dlrow olleh");
    }

    public static String mystery(String s) {
        int n = s.length();

        if (n <= 1) return s;
        String a = s.substring(0, n/2);
        String b = s.substring(n/2, n);
        return mystery(b) + mystery(a);
    }
}
