import java.util.*;

public class graph {
    private int vertices;

    private LinkedList<Integer> mat[];
    boolean vis[];

    public graph(int v) {
        vis = new boolean[v];
        vertices = v;
        mat = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            mat[i] = new LinkedList<>();
        }
    }

    void edge(int v, int w) {
        mat[v].add(w);
    }

    void bfs(int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean vis[] = new boolean[vertices];
        vis[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " ");
            Iterator<Integer> i = mat[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (vis[n] != true) {
                    vis[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void dfs(int s) {
        if (vis[s] != true) {
            vis[s] = true;
            System.out.println(s + " ");
            Iterator<Integer> i = mat[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!vis[n]) {
                    dfs(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        graph gr = new graph(4);
        gr.edge(0, 1);
        gr.edge(0, 2);
        gr.edge(1, 2);
        gr.edge(2, 0);
        gr.edge(2, 3);
        gr.edge(3, 0);
        System.out.println("bfs");
        gr.bfs(0);
        System.out.println("dfs");
        gr.dfs(0);
    }
}