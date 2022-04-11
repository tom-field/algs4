package chapter4.section1;

import edu.princeton.cs.algs4.In;

// 判断是否有环(假设不存在自环或平行边)
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }
    // 深度优先遍历图，如果在遍历的过程中，发现某个结点有一条边指向已访问过的结点，
    // 并且这个已访问过的结点不是上一步访问的结点，则表示存在环。
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle () {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(G);
        System.out.println(cycle.hasCycle);
    }
}
