# 1389번: 케빈 베이컨의 6단계 법칙

## 문제

- https://www.acmicpc.net/problem/1389
- not solved ❌
- 실버1

## 풀이 접근

- 모든 정점에 대해 탐색을 해서 count를 구한다.
- 구한 count의 최소값을 구하고, 그 최소값의 정점을 구한다.

```java
import java.util.*;
import java.io.*;

/**
 * 2024-03-03
 * 1389번: 케빈 베이컨의 6단계 법칙 (실버1)
 * not solved ❌
 */
public class Bfs_9 {
    private static int n, m;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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

        solution();

    }

    private static void solution() {
        int minCount = Integer.MAX_VALUE;
        int minVex = 0;
        for (int i = 1; i <= n; i++) {
            int count = bfs(i);
            if (minCount > count) {
                minCount = count;
                minVex = i;
            }
        }
        System.out.println(minVex);
    }

    private static int bfs(int v) {
        int count = 0;
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Q.offer(v);
        visited[v] = true;
        dist[v] = 0;
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    dist[nv] = dist[cv] + 1;
                    count += dist[nv];
                    Q.offer(nv);
                }
            }
        }

        return count;

    }
}
```