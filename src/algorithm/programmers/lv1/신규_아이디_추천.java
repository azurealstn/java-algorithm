package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-23
 * 신규 아이디 추천 (Lv1)
 * solved ✅
 */
public class 신규_아이디_추천 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }

    private static String solution(String new_id) {
        new_id = new_id.toLowerCase();

        char[] chArr = {'-', '_', '.'};
        List<Character> list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(chArr[i]);
        }
        StringBuilder id = new StringBuilder();
        for (char ch : new_id.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || list.contains(ch)) {
                id.append(ch);
            }
        }
        new_id = id.toString();

        id = new StringBuilder();
        id.append(new_id.charAt(0));
        for (int i = 1; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (ch == '.' && new_id.charAt(i - 1) == ch) {
                continue;
            }
            id.append(ch);
        }
        new_id = id.toString();

        id = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if ((i == 0 && ch == '.') || (i == new_id.length() - 1) && ch == '.') {
                continue;
            }
            id.append(ch);
        }
        new_id = id.toString();

        if (new_id.equals("")) {
            new_id = "a";
        }

        id = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (i > 14) {
                break;
            } else if (i == 14 && ch == '.') {
                continue;
            }
            id.append(ch);
        }
        new_id = id.toString();

        if (new_id.length() <= 2) {
            char endCh = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += endCh;
            }
        }

        return new_id;
    }
}
