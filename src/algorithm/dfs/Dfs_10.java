package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024.02.28
 * 2583번: 영역 구하기  (실버1)
 * solved ⭕
 */
public class Dfs_10 {
    static int m, n, k;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();
    static int count, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j <= y2 - 1; j++) {
                for (int l = x1; l <= x2 - 1; l++) {
                    board[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    count++;
                    result++;
                    dfs(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(result);
        Collections.sort(list);
        for (int x : list) {
            System.out.print(x + " ");
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                count++;
                dfs(nx, ny);
            }
        }
    }
}
