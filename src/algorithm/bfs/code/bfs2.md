# 7576번: 토마토

## 문제

- https://www.acmicpc.net/problem/7576
- solved ⭕
- 골드5

## 풀이 접근

- 네 방향 `dx`, `dy` 초기화
- dis 배열을 선언하여 최소 거리 기록
- tomato 배열을 저장할 때 Queue에 익은 토마토들을 먼저 삽입한다.

```java
import java.util.*;
import java.io.*;

/**
 * 2024-02-29
 * 7576번: 토마토 (골드5)
 * solved ⭕
 */
class Point2 {
    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Bfs_2 {
    static int m, n;
    static int[][] tomato;
    static int[][] dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    static Queue<Point2> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomato = new int[n][m];
        dis = new int[n][m];

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) { // 토마토가 익은 경우
                    Q.offer(new Point2(i, j));
                    dis[i][j] = 0;
                } else if (tomato[i][j] == 0) {
                    flag = false;
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태
        if (flag) {
            System.out.println(0);
            return;
        }

        bfs();

        flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    flag = false;
                    break;
                }
                answer = Math.max(answer, dis[i][j]);
            }
            if (!flag) break;
        }

        if (flag) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        while (!Q.isEmpty()) {
            Point2 cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tomato[nx][ny] == 0) {
                    tomato[nx][ny] = 1;
                    Q.offer(new Point2(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }
}
```