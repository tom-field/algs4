package chapter4.section1;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
    private boolean[] marked;   // 到大该顶点的最短路径已知吗?
    private int[] edgeTo;       // 到大该顶点的已知路径上的最后一个顶点
    private final int s;        // 起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;               // 标记起点
        queue.enqueue(s);               // 将它加入队列
        while (!queue.isEmpty()) {
            int v = queue.dequeue();    // 从队列中删去下一顶点
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;      // 保存最短路径的最后一条边
                    marked[w] = true;   // 标记它,因为最短路径已知
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths search = new BreadthFirstPaths(G,s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.println(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
            }
            StdOut.println();
        }
    }
}
