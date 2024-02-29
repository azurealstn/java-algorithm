package algorithm.bfs;

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 2024-02-29
 * 2178번: 미로 탐색 (실버1)
 * solved ⭕
 */
public class Bfs_1 {
    static int n, m;
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        dis[0][0] = 1;
        bfs(0, 0);
        System.out.println(dis[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            Point cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }
}
