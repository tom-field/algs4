package chapter4.section1;

import edu.princeton.cs.algs4.In;

// 判断是否是二分图 (双色问题)
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    // 染色法，即从其中一个顶点开始，将跟它邻接的点染成与其不同的颜色，
    // 如果邻接的点有相同颜色的，则说明不是二分图
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        TwoColor twoColor = new TwoColor(G);
        System.out.println(twoColor.isBipartite());
    }
}
