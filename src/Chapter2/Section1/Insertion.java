package Chapter2.Section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--){
                exch(a, j, j-1);
            }
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
        // 在单行中打印数组
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }
}
