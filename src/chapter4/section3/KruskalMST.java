package chapter4.section3;

import edu.princeton.cs.algs4.*;

public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();                           // 从pq得到权重最小的边和它的顶点
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;               // 忽略失效的边
            uf.union(v, w);                                 // 合并分量
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
