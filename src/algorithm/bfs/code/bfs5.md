# 7562번: 나이트의 이동

## 문제

- https://www.acmicpc.net/problem/7562
- not solved ❌
- 실버1

## 풀이 접근

- 나이트가 이동할 수 있는 8방향 초기화
- bfs 안에서 나이트가 이동하려는 지점에 도착했을 때 return

```java
import java.util.*;
import java.io.*;

/**
 * 2024-03-01
 * 7562번: 나이트의 이동 (실버1)
 * not solved ❌
 */
class Point5 {
    int x;
    int y;

    public Point5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Bfs_5 {
    private static int t, l, x2, y2;
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[][] board, dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            board = new int[l][l];
            dis = new int[l][l];

            bfs(x1, y1);

            System.out.println(dis[x2][y2]);
        }
    }

    private static void bfs(int x1, int y1) {
        Queue<Point5> Q = new LinkedList<>();
        Q.offer(new Point5(x1, y1));
        while (!Q.isEmpty()) {
            Point5 cur = Q.poll();
            // 나이트가 이동하려는 지점에 도착했을 때 return
            if (cur.x == x2 && cur.y == y2) {
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < l && ny >= 0 && ny < l && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point5(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }
}
```