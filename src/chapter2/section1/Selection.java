package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序
 */
public class Selection {
    public static void sort(Comparable[] a) {
        // 将a按照升序排列
        int N = a.length;
        for (int i = 0; i < a.length; i++) {
            // 将a[i]和a[i...N]中最小元素交互
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[j - 1])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        // 对元素进行比较
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        // 将元素交换位置
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i] + " ");
        }
        StdOut.println();
    }

}
