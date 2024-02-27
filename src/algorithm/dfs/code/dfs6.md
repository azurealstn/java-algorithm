# 10026번: 적록색약

## 문제

- https://www.acmicpc.net/problem/10026
- solved ⭕
- 골드5

## 풀이 접근

- 방향을 나타내는 배열 선언 `dx`, `dy`
- 2차원 배열을 돌면서 `board[i][j]`의 값이 '0'이 아닌 경우 dfs 재귀 호출
- 재귀 안에서는 방향으로 이동하면서 `board[i][j]`의 값을 '0'으로 변경
  - `boardA[nx][ny] == c`: 이전과 같은 character 값인 경우

```java
/**
 * 2024.02.27
 * 10026번: 적록색약  (골드5)
 * solved ⭕
 */
public class Dfs_6 {
  static int n;
  static char[][] boardA;
  static char[][] boardB;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    n = Integer.parseInt(br.readLine());
    boardA = new char[n][n];
    boardB = new char[n][n];
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        boardA[i][j] = str.charAt(j);
        if (str.charAt(j) == 'G') {
          boardB[i][j] = 'R';
        } else {
          boardB[i][j] = str.charAt(j);
        }
      }
    }

    int a = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char c = boardA[i][j];
        if (c != '0') {
          boardA[i][j] = '0';
          a++;
          dfsA(i, j, c);
        }
      }
    }

    int b = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char c = boardB[i][j];
        if (c != '0') {
          boardB[i][j] = '0';
          b++;
          dfsB(i, j, c);
        }
      }
    }

    System.out.print(a + " " + b);
  }

  // 적록색약이 아닌 사람
  private static void dfsA(int x, int y, char c) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < n && boardA[nx][ny] == c) {
        boardA[nx][ny] = '0';
        dfsA(nx, ny, c);
      }
    }
  }

  // 적록색약인 사람
  private static void dfsB(int x, int y, char c) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < n && boardB[nx][ny] == c) {
        boardB[nx][ny] = '0';
        dfsB(nx, ny, c);
      }
    }
  }
}
```