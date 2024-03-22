package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-22
 * 성격 유형 검사하기 (Lv1)
 * not solved ❌
 */
public class 성격_유형_검사하기 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    private static String solution(String[] survey, int[] choices) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            if (choice > 0 && choice < 4) {
                char ch = survey[i].charAt(0);
                map.put(ch, map.getOrDefault(ch, 0) + 4 - choice);
            } else if (choice > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.getOrDefault(ch, 0) + choice - 4);
            }
        }

        result.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        result.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        result.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        result.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');

        return result.toString();
    }
}
