# 7576번: 토마토

## 문제

- https://www.acmicpc.net/problem/7569
- not solved ❌
- 골드5

## 풀이 접근

- 여섯 방향 `dx`, `dy`, `dz` 초기화
- 3차원 배열

```java
import java.util.*;
import java.io.*;

/**
 * 2024-03-01
 * 7569번: 토마토 (골드5)
 * not solved ❌
 */
class Point4 {
  int z;
  int x;
  int y;

  public Point4(int z, int x, int y) {
    this.z = z;
    this.x = x;
    this.y = y;
  }
}
public class Bfs_4 {
  static int m, n, h;
  static int[][][] tomato, dis;
  static int[] dx = {-1, 0, 1, 0, 0, 0};
  static int[] dy = {0, 1, 0, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int answer;
  static Queue<Point4> Q = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    tomato = new int[h][n][m];
    dis = new int[h][n][m];

    boolean flag = true;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
          tomato[i][j][k] = Integer.parseInt(st.nextToken());
          if (tomato[i][j][k] == 1) {
            Q.offer(new Point4(i, j, k));
          } else if (tomato[i][j][k] == 0) {
            flag = false;
          }
        }
      }
    }


    if (flag) {
      System.out.println(0);
      return;
    }

    bfs();

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (tomato[i][j][k] == 0) {
            System.out.println(-1);
            return;
          }
          answer = Math.max(answer, dis[i][j][k]);
        }
      }
    }

    System.out.println(answer);
  }

  private static void bfs() {
    while (!Q.isEmpty()) {
      Point4 cur = Q.poll();
      for (int i = 0; i < 6; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        int nz = cur.z + dz[i];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && tomato[nz][nx][ny] == 0) {
          tomato[nz][nx][ny] = 1;
          Q.offer(new Point4(nz, nx, ny));
          dis[nz][nx][ny] = dis[cur.z][cur.x][cur.y] + 1;
        }
      }
    }

  }
}
```