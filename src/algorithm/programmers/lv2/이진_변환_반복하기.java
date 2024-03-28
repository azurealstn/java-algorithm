package algorithm.programmers.lv2;

import java.util.*;

/**
 * 2024-03-28
 * 이진 변환 반복하기 (Lv1)
 * solved ✅
 */
public class 이진_변환_반복하기 {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int[] result = new int[2];
        int transCount = 0;
        int zeroCount = 0;

        while (!"1".equals(s)) {
            String tmp = "";
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    zeroCount++;
                } else {
                    tmp += ch;
                }
            }
            int c = tmp.length();
            s = Integer.toBinaryString(c);
            transCount++;
        }
        result[0] = transCount;
        result[1] = zeroCount;

        return result;
    }
}
