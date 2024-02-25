package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024-02-25
 * 1260번: DFS와 BFS (실버2)
 * not solved ❌
 */
public class Dfs_1 {
    static int n, m, v;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        ch = new int[n + 1];
        dfs(v);
        System.out.println();

        ch = new int[n + 1];
        bfs(v);
    }

    private static void dfs(int v) {
        if (ch[v] == 1) {
            return;
        }

        ch[v] = 1;
        System.out.print(v + " ");

        for (int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                dfs(nv);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        ch[v] = 1;
        while (!Q.isEmpty()) {
            Integer cv = Q.poll();
            System.out.print(cv + " ");

            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    Q.offer(nv);
                    ch[nv] = 1;
                }
            }
        }
    }
}