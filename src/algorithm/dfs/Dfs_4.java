package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024.02.26
 * 1012번: 유기농 배추 (실버2)
 * solved ⭕
 */
public class Dfs_4 {
    static int n, m, k;
    static int[][] vegetables;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            vegetables = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                vegetables[x][y] = 1;
            }

            int answer = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (vegetables[x][y] == 1) {
                        vegetables[x][y] = 0;
                        answer++;
                        dfs(x, y);
                    }
                }
            }
            System.out.println(answer);
        }

    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && vegetables[nx][ny] == 1) {
                vegetables[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}
