package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-26
 * 가장 많이 받은 선물 (Lv1)
 * not solved ❌
 */
public class 가장_많이_받은_선물 {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" };
        System.out.println(solution(friends, gifts));
    }

    private static int solution(String[] friends, String[] gifts) {
        int result = 0;
        int n = friends.length;
        HashMap<String, Integer> map = new HashMap<>();
        int[] giftPrefer = new int[n];
        int[][] giftGraph = new int[n][n];

        // 1. friends Map 세팅
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }

        // 2. giftPrefer, giftGraph 설정
        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            String given = arr[0];
            String receiver = arr[1];
            giftPrefer[map.get(given)]++;
            giftPrefer[map.get(receiver)]--;
            giftGraph[map.get(given)][map.get(receiver)]++;
        }

        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) { // 본인인 경우
                    continue;
                }

                if (giftGraph[i][j] > giftGraph[j][i] ||
                        giftGraph[i][j] == giftGraph[j][i] && giftPrefer[i] > giftPrefer[j]) {
                    num++;
                }
            }
            if (result < num) {
                result = num;
            }

        }

        return result;
    }
}
