package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
// 并查集
public class UF {
    private final int[] id;  // 分量id(以触点作为索引)
    public int count; // 分量数量
    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
             id[i] = i;
        }
    }
    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 2.0 quick union
    private int find(int p){
        // 找出分量的名称
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q){
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    // 1.0 quick find
    // public int find(int p) {
    //     return id[p];
    // }

    // public void union(int p, int q) {
    //     int pId = find(p);
    //     int qId = find(q);
    //     if (pId == qId) return;
    //     for (int i = 0; i < id.length; i++) {
    //         if(id[i] == pId) id[i] = qId;
    //     }
    //     count--;
    // }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) {
                continue;
            }
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + "components");
    }
}
