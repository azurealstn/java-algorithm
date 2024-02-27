package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024.02.27
 * 11724번: 연결 요소의 개수 (실버2)
 * not solved ❌
 */
public class Dfs_5 {
    static int n, m;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 모든 정점을 dfs 재귀 호출
        // 이미 방문했던 정점은 지나간다.
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 1) {
                continue;
            }

            ch[i] = 1;
            dfs(i);
            answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int vex) {
        for (int nv : graph.get(vex)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                dfs(nv);
            }
        }
    }
}
