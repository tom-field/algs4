package chapter4.section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Topological {
    private Iterable<Integer> order;            // 顶点的拓扑顺序

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        // 构造书中的图
        Digraph G = new Digraph(13);
        G.addEdge(0, 1);
        G.addEdge(0, 5);
        G.addEdge(0, 6);
        G.addEdge(2,0);
        G.addEdge(2, 3);
        G.addEdge(3,5);
        G.addEdge(5,4);
        G.addEdge(6, 4);
        G.addEdge(6, 9);
        G.addEdge(7,6);
        G.addEdge(8,7);
        G.addEdge(9,10);
        G.addEdge(9, 11);
        G.addEdge(9, 12);
        G.addEdge(11,12);

        Topological top = new Topological(G);

        for (int v : top.order) {
            StdOut.print(v + " ");
        }
    }
}
