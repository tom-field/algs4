package chapter4.section2;

import edu.princeton.cs.algs4.In;

public class TransitiveClosure {
    private DirectedDFS[] all;

    TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    boolean reachable(int v, int w) {
        return all[v].marked(w);
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        TransitiveClosure tc = new TransitiveClosure(G);
    }
}
