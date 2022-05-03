package chapter5.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 计数排序法 也称 键索引计数法
 * 适用于小整数排序
 * @author tomfield
 * @date 2022/5/3 17:58
 * @page 458
 */
public class CountSort {

    public class Student {
        private String name;    // 名字
        private int group;      // 组

        public Student(String name, int group) {
            this.name = name;
            this.group = group;
        }

        public String name() {
            return name;
        }

        public int key() {
            return group;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", group=" + group +
                    '}';
        }
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        Student[] a = new CountSort.Student[20];
        a[0] = countSort.new Student("Anderson",2);
        a[1] = countSort.new Student("Brown",3);
        a[2] = countSort.new Student("Davis",3);
        a[3] = countSort.new Student("Garcia",4);
        a[4] = countSort.new Student("Harris",1);
        a[5] = countSort.new Student("Jackson",3);
        a[6] = countSort.new Student("Johnson",4);
        a[7] = countSort.new Student("Jones",3);
        a[8] = countSort.new Student("Martin",1);
        a[9]= countSort.new Student("Martinez",2);
        a[10] = countSort.new Student("Miller",2);
        a[11] = countSort.new Student("Moore",1);
        a[12] = countSort.new Student("Robinson",2);
        a[13] = countSort.new Student("Smith",4);
        a[14] = countSort.new Student("Taylor",3);
        a[15] = countSort.new Student("Thomas",4);
        a[16] = countSort.new Student("Thompson",4);
        a[17] = countSort.new Student("White",2);
        a[18] = countSort.new Student("Williams",3);
        a[19] = countSort.new Student("Wilson",4);

        int N = a.length;
        int R = 5;  // 0-4组 总共5个数,虽然没有0组但是加上比较好算些

        Student[] aux = new CountSort.Student[N];
        int[] count = new int[R];

        // 计数
        for (int i = 0; i < N; i++) {
            count[a[i].key()]++;
        }
        // 统计计数的累积值
        for (int r = 1; r < R; r++) {
            count[r] = count[r] + count[r-1];
        }
        // 将元素放到正确位置
        for (int i = 0; i < N; i++) {
            aux[count[a[i].key()]-1] = a[i];
            count[a[i].key()]--;
        }
        // 输出
        for (int i = 0; i < N; i++) {
            StdOut.println(aux[i]);
        }
    }
}
