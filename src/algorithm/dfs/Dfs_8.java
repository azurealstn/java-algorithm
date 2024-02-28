package algorithm.dfs;

import java.util.*;
import java.io.*;

/**
 * 2024.02.28
 * 4963번: 섬의 개수  (실버2)
 * solved ⭕
 */
public class Dfs_8 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] island = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (island[i][j] == 1) {
                        island[i][j] = 0;
                        count++;
                        dfs(i, j, w, h, island);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y, int w, int h, int[][] island) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w && island[nx][ny] == 1) {
                island[nx][ny] = 0;
                dfs(nx, ny, w, h, island);
            }
        }
    }
}
