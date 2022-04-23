package chapter4.section3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedGraph {
    private final int V;            // 顶点总数
    private int E;                  // 边的总数
    private Bag<Edge>[] adj;        // 邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());         // 读取V并将图初始化
        int E = in.readInt();       // 读取E
        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    b.add(e);
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        for (Edge e : G.edges()) {
            System.out.println(e);
        }
    }
}
