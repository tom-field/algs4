package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;
/*
* 希尔排序(缩小增量排序)
* 插入排序的改进版
* Not Stable
* */
public class Shell {
    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        // 初始化h的间隔, 间隔依次递减,
        // 当h固定为1的话,就是插入排序
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    // 让j,和j-h有序
                    exch(a, j, j - h);
                }
            }
            // 这里只要递减就行,不一定是除以3
            h /= 3;
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
