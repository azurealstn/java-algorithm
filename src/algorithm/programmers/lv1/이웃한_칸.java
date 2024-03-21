package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-21
 * 이웃한 칸 (Lv1)
 * solved ✅
 */
public class 이웃한_칸 {
    public static void main(String[] args) {
        String[][] board = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
        };
        int h = 1;
        int w = 1;
        System.out.println(solution(board, h, w));
    }

    private static int solution(String[][] board, int h, int w) {
        int result = 0;
        int n = board.length;
        String originColor = board[h][w];
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny].equals(originColor)) {
                result++;
            }
        }
        return result;
    }
}
