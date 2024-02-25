package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024.02.25
 * 2606번: 바이러스 (실버3)
 * solved ⭕
 */
public class Dfs_2 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

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

        ch = new int[n + 1];
        ch[1] = 1;
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int v) {
        for (int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                count++;
                dfs(nv);
            }
        }
    }
}
