# 2667번: 단지번호붙이기

## 문제

- https://www.acmicpc.net/problem/2667
- solved ⭕
- 실버1

## 풀이 접근

- 방향을 나타내는 배열 선언 `dx`, `dy`
- 2차원 배열을 돌면서 `board[i][j]`의 값이 1인 경우 dfs 재귀 호출
- 루프 돌면서 `board[i][j]`의 값을 다시 0으로 초기화 (재방문을 안하기 위해)

```java
import java.util.*;
import java.io.*;

/**
 * 2024.02.26
 * 2667번: 단지번호붙이기 (실버1)
 * solved ⭕
 */
public class Dfs_3 {
    static int n;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static int count = 1;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        // 2차원 배열 선언
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0; // 재방문을 안하기 위해 0으로 변경
                    dfs(i, j);
                    list.add(count);
                    count = 1; // 현재 위치에 대한 1 초기화
                }
            }
        }

        Collections.sort(list);
        System.out.println(answer);
        for (int x : list) {
            System.out.println(x);
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 이동할 수 있는 범위
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                count++;
                dfs(nx, ny);
            }
        }
    }
}
```