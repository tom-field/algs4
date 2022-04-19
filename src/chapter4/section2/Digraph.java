package chapter4.section2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());         // 读取V并将图初始化
        int E = in.readInt();       // 读取E
        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();   // 读取一个顶点
            int w = in.readInt();   // 读取另一个顶点
            addEdge(v,w);           // 添加一条连接它们的边
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    // 图的邻接表的字符串表示(Graph的实例方法)
    public String toString() {
        String s = V + " vertices " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        System.out.println(G);
    }
}
