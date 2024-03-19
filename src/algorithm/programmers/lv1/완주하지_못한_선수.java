package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-19
 * 완주하지 못한 선수 (Lv1)
 * solved ✅
 */
public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    private static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        for (String person : completion) {
            if (map.containsKey(person)) {
                map.put(person, map.get(person) - 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        return null;
    }
}
