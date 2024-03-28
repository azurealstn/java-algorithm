package algorithm.programmers.lv2;

import java.util.*;

/**
 * 2024-03-28
 * 숫자의 표현 (Lv1)
 * solved ✅
 */
public class 숫자의_표현 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int result = 0;
        int sum = 0;
        int lt = 1;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            while (sum > n) {
                sum -= lt;
                lt++;
            }
            if (sum == n) {
                result++;
            }
        }

        return result;
    }
}
