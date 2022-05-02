package chapter4.section4;

public class AcyclicLP {

    private AcyclicSP acyclicSP;

    public AcyclicLP(EdgeWeightedDigraph G, int s) {
        EdgeWeightedDigraph negatedEdgeWeightedDigraph = new EdgeWeightedDigraph(G.V());

        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge edge : G.adj(v)) {
                DirectedEdge negatedDirectedEdge = new DirectedEdge(edge.from(), edge.to(), edge.weight() * -1);
                negatedEdgeWeightedDigraph.addEdge(negatedDirectedEdge);
            }
        }

        acyclicSP = new AcyclicSP(negatedEdgeWeightedDigraph, s);
    }

    public double distTo(int v) {
        if (acyclicSP.distTo(v) == 0) {
            return 0;
        }
        return acyclicSP.distTo(v) * -1;
    }

    public boolean hasPathTo(int v) {
        return acyclicSP.hasPathTo(v);
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        return acyclicSP.pathTo(v);
    }
}
