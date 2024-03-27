package algorithm.programmers.lv2;

import java.util.*;

/**
 * 2024-03-27
 * JadenCase 문자열 만들기 (Lv1)
 * solved ✅
 */
public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        String s = "for the  last week";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        boolean isFirstLetter = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isFirstLetter && Character.isAlphabetic(ch)) {
                ch = Character.toUpperCase(ch);
            }
            sb.append(ch);
            isFirstLetter = false;
            if (ch == ' ') {
                isFirstLetter = true;
            }
        }

        return sb.toString();
    }
}
