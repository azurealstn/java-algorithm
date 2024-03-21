package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-21
 * 크레인 인형뽑기 (Lv1)
 * solved ✅
 */
public class 크레인_인형뽑기 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> S = new Stack<>();
        int n = board.length;
        for (int move : moves) {
            for (int i = 0; i < n; i++) {
                int doll = board[i][move - 1];
                if (doll != 0) {
                    board[i][move - 1] = 0;
                    if (S.isEmpty()) {
                        S.push(doll);
                    } else {
                        if (S.peek() == doll) {
                            S.pop();
                            result += 2;
                        } else {
                            S.push(doll);
                        }
                    }
                    break;
                }
            }
        }

        return result;
    }
}
