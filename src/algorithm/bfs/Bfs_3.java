package algorithm.bfs;

import java.util.*;
import java.io.*;

/**
 * 2024-03-01
 * 14502번: 연구소 (골드4)
 * not solved ❌
 */
class Point3 {
    int x;
    int y;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Bfs_3 {
    static int n, m;
    static int[][] research;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        research = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                research[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    // 벽 3개를 설치한 모든 경우의 수
    private static void dfs(int L) {
        if (L == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (research[i][j] == 0) {
                    research[i][j] = 1;
                    dfs(L+1);
                    research[i][j] = 0;
                }
            }
        }
    }

    // 바이러스를 퍼트리는 메서드
    private static void bfs() {
        Queue<Point3> Q = new LinkedList<>();
        int[][] newResearch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newResearch[i][j] = research[i][j];
                if (newResearch[i][j] == 2) {
                    Q.offer(new Point3(i, j));
                }
            }
        }

        while (!Q.isEmpty()) {
            Point3 cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && newResearch[nx][ny] == 0) {
                    newResearch[nx][ny] = 2;
                    Q.offer(new Point3(nx, ny));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newResearch[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
