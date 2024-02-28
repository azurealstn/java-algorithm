# 2468번: 안전 영역

## 문제

- https://www.acmicpc.net/problem/2468
- solved ⭕
- 실버1

## 풀이 접근

- 방향을 나타내는 배열 선언 `dx`, `dy`
- 최대 높이: maxHeight
- 1부터 maxHeight까지 완전탐색 루프를 돌린다.
- 그 안에서 tmp라는 2차원 배열을 만들어서 침수된 곳은 0으로, 아닌 곳은 1로 초기화한다.
- 2차원 배열을 배열을 돌면서 재귀 함수를 호출한다.

```java
import java.util.*;
import java.io.*;

/**
 * 2024.02.28
 * 2468번: 안전 영역  (실버1)
 * solved ⭕
 */
public class Dfs_7 {
  static int n;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    n = Integer.parseInt(br.readLine());
    int[][] area = new int[n][n];
    int maxHeight = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        area[i][j] = Integer.parseInt(st.nextToken());
        if (area[i][j] > maxHeight) {
          maxHeight = area[i][j];
        }
      }
    }

    int max = 0;
    for (int i = 1; i <= maxHeight; i++) {
      int count = 0;
      int[][] tmp = new int[n][n];
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (area[j][k] <= i) {
            tmp[j][k] = 0;
          } else {
            tmp[j][k] = 1;
          }
        }
      }

      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (tmp[j][k] == 1) {
            count++;
            tmp[j][k] = 0;
            dfs(j, k, tmp);
          }
        }
      }

      max = Math.max(max, count == 0 ? 1 : count);
    }
    System.out.println(max);
  }

  private static void dfs(int x, int y, int[][] tmp) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n && tmp[nx][ny] == 1) {
        tmp[nx][ny] = 0;
        dfs(nx, ny, tmp);
      }
    }
  }
}
```