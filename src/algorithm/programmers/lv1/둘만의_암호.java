package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-19
 * 둘만의 암호 (Lv1)
 * not solved ❌
 */
public class 둘만의_암호 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }

    private static String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                c += 1;
                if (c > 'z') {
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))) {
                    i--;
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}
