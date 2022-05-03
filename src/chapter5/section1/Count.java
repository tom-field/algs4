package chapter5.section1;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author tomfield
 * @date 2022/5/3 14:36
 * @page 454
 */
public class Count {
    public static void main(String[] args) {
        Alphabet alpha = new Alphabet(args[0]);
        int R = alpha.R();
        int[] count = new int[R];

        String s = StdIn.readAll();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alpha.contains(s.charAt(i))) {
                count[alpha.toIndex(s.charAt(i))]++;
            }
        }

        for (int i = 0; i < R; i++) {
            StdOut.println(alpha.toChar(i) + " " + count[i]);
        }
    }
}
