package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024.02.28
 * 11725번: 트리의 부모 찾기  (실버2)
 * solved ⭕
 */
public class Dfs_9 {
    static int n;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ch = new int[n + 1];
        ch[1] = 1;
        dfs(1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int key : list) {
            System.out.println(map.get(key));
        }
    }

    private static void dfs(int v) {
        for (int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                map.put(nv, v);
                dfs(nv);
            }
        }
    }
}
