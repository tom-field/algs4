package chapter5.section1;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 字符串低位优先排序
 * 字符串长度要一致
 * @author tomfield
 * @date 2022/5/4 11:26
 * page 459
 */
public class LSD {
    public static void sort(String[] a, int W) {
        // 通过前W个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            // 根据第d个字符用键索引计数法排序
            int[] count = new int[R + 1];           // 计算出现频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {          // 将频率转换为索引
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {          // 将元素分类
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {          // 回写
                a[i] = aux[i];
            }
        }
    }
}
