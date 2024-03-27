package algorithm.programmers.lv2;

import java.util.*;

/**
 * 2024-03-27
 * 최댓값과 최솟값 (Lv1)
 * solved ✅
 */
public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String num : s.split(" ")) {
            int n = Integer.parseInt(num);
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }
        return min + " " + max;
    }
}
