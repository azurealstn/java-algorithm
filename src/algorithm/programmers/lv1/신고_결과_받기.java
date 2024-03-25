package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-25
 * 신고 결과 받기 (Lv1)
 * not solved ❌
 */
public class 신고_결과_받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        for (int x : solution(id_list, report, k)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            map.put(id, new HashSet<>());
            indexMap.put(id, i);
        }

        for (String str : report) {
            String[] arr = str.split(" ");
            map.get(arr[1]).add(arr[0]);
        }

        for (String id : id_list) {
            HashSet<String> set = map.get(id); // 신고한 사람
            if (set.size() >= k) {
                for (String name : set) {
                    result[indexMap.get(name)]++;
                }
            }
        }

        return result;
    }
}
