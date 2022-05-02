package chapter4.section4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author tomfield
 * @date 2022/5/2 17:07
 * @page 444
 * 货币兑换中的套汇(理想情况:排除了手续费过夜费,并且所有货币对都可以双向交易等情况)
 */
public class Arbitrage {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        String[] name = new String[V];
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v] = StdIn.readString();
            for (int w = 0; w < V; w++) {
                double rate = StdIn.readDouble();
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate));
                G.addEdge(e);
            }
        }
        BellmanFordSP spt = new BellmanFordSP(G, 0);
        if (spt.hasNegativeCycle()) {
            double stake = 1000.0;
            for (DirectedEdge e : spt.negativeCycle()) {
                StdOut.printf("%10.5f %s", stake, name[e.from()]);
                stake *= Math.exp(-e.weight());
                StdOut.printf("=%10.5f %s\n", stake, name[e.to()]);
            }
        } else {
            StdOut.println("No arbitrage opportunity");
        }
    }
}
