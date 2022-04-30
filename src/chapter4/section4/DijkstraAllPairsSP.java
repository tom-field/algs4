package chapter4.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

// 利用迪杰斯特拉算法求任意两点间的最短路径
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;

    DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DijkstraSP(G, v);
        }
    }

    Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    double dist(int s, int t) {
        return all[s].distTo(t);
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
        DijkstraAllPairsSP allSp = new DijkstraAllPairsSP(G);
        StdOut.println(allSp.path(0, 6));
    }
}
