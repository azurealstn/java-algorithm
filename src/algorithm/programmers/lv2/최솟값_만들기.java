package algorithm.programmers.lv2;

import java.util.*;

/**
 * 2024-03-27
 * 최솟값 만들기 (Lv1)
 * solved ✅
 */
public class 최솟값_만들기 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution(A, B));
    }

    private static int solution(int[] A, int[] B) {
        int result = 0;
        int k = A.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < k; i++) {
            result += A[i] * B[k - i - 1];
        }

        return result;
    }
}
