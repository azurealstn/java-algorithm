package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-19
 * 숫자 짝궁 (Lv1)
 * not solved ❌
 */
public class 숫자_짝궁 {
    public static void main(String[] args) {
        String X = "5525";
        String Y = "1255";
        System.out.println(solution(X, Y));
    }

    private static String solution(String X, String Y) {
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        for (char c : X.toCharArray()) {
            int x = Character.getNumericValue(c);
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
        }

        for (char c : Y.toCharArray()) {
            int y = Character.getNumericValue(c);
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (char c : X.toCharArray()) {
            int key = Character.getNumericValue(c);
            if (mapY.containsKey(key) && mapX.get(key) > 0 && mapY.get(key) > 0) {
                list.add(key);
                mapX.put(key, mapX.get(key) - 1);
                mapY.put(key, mapY.get(key) - 1);
            }
        }

        if (list.size() == 0) {
            return "-1";
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (int x : list) {
            result.append(x);
        }

        String answer = result.toString();
        if (answer.replaceAll("0", "").length() == 0) {
            return "0";
        }

        return answer;
    }
}
