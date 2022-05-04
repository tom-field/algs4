package chapter5.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 高位优先排序 属于 基数排序
 * @author tomfield
 * @date 2022/5/4 12:53
 * @page 462
 */
public class MSD {
    private static int R = 256;             // 基数
    private static String[] aux;            // 根据分类的辅助数组

    private static int chartAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        // 以第d个字符为键将a[lo]至a[hi]排序
         if (hi <= lo) {
             return;
         }

        int[] count = new int[R + 2];       // 计算频率
        for (int i = lo; i <= hi; i++) {
            count[chartAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) {   // 将频率转换为索引
            count[r + 1] += count[r];
        }

        for (int i = lo; i <= hi; i++) {    // 回写
            aux[count[chartAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] a = {"she", "shells", "seashells", "by", "the", "shells", "she", "sells", "are", "surely", "seashells"};
        MSD.sort(a);
        for (String s : a) {
            StdOut.println(s);
        }
    }
}
