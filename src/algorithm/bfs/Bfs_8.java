package algorithm.bfs;

import java.util.*;
import java.io.*;

/**
 * 2024-03-02
 * 16234번: 인구 이동 (골드4)
 * not solved ❌
 */
class Point8 {
    int x;
    int y;

    public Point8(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Bfs_8 {
    private static int n, l, r;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] board, ch;
    private static ArrayList<Point8> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());

    }

    private static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            ch = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ch[i][j] == 0) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            int avg = sum / list.size();
                            for (Point8 o : list) {
                                board[o.x][o.y] = avg;
                            }
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return result;
            result++;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point8> Q = new LinkedList<>();
        list = new ArrayList<>();
        Q.offer(new Point8(x, y));
        list.add(new Point8(x, y));
        ch[x][y] = 1;

        int sum = board[x][y];
        while (!Q.isEmpty()) {
            Point8 cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == 0) {
                    int diff = Math.abs(board[cur.x][cur.y] - board[nx][ny]);
                    if (l <= diff && diff <= r) {
                        Q.offer(new Point8(nx, ny));
                        list.add(new Point8(nx, ny));
                        sum += board[nx][ny];
                        ch[nx][ny] = 1;
                    }
                }
            }
        }
        return sum;
    }
}
