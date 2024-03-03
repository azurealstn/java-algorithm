package algorithm.bfs;

import java.util.*;
import java.io.*;

/**
 * 2024-03-03
 * 5014번: 스타트링크 (실버1)
 * solved ⭕
 */
public class Bfs_10 {
    private static int f, s, g, u, d;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken()); // 총 층수
        s = Integer.parseInt(st.nextToken()); // 현재 위치한 층수
        g = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 위치의 층수
        u = Integer.parseInt(st.nextToken()); // 위로 U층을 가는 버튼
        d = Integer.parseInt(st.nextToken()); // 아래로 D층을 가는 버튼

        visited = new boolean[f + 1];
        int count = bfs();
        if (count == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(count);
        }
    }

    private static int bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        visited[s] = true;
        int L = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int cv = Q.poll();
                if (cv == g) {
                    return L;
                }
                int up = cv + u;
                if (up >= 1 && up <= f && !visited[up]) {
                    visited[up] = true;
                    Q.offer(up);
                }
                int down = cv - d;
                if (down >= 1 && down <= f && !visited[down]) {
                    visited[down] = true;
                    Q.offer(down);
                }
            }
            L++;
        }
        return -1;
    }
}
