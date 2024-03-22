package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-22
 * 키패드 누르기 (Lv1)
 * not solved ❌
 */
public class 키패드_누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(numbers, hand));

    }

    private static String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();

        int left = 10;
        int right = 12;

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                result.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = n;
                result.append("R");
            } else {
                if (n == 0) {
                    n = 11;
                }
                int leftDiff = (Math.abs(n - left) / 3) + (Math.abs(n - left) % 3);
                int rightDiff = (Math.abs(n - right) / 3) + (Math.abs(n - right) % 3);

                if (leftDiff < rightDiff) {
                    left = n;
                    result.append("L");
                } else if (leftDiff > rightDiff) {
                    right = n;
                    result.append("R");
                } else {
                    if ("left".equals(hand)) {
                        left = n;
                        result.append("L");
                    } else {
                        right = n;
                        result.append("R");
                    }
                }
            }
        }

        return result.toString();
    }
}
