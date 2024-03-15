package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-15
 * 실패율 (Lv1)
 * not solved ❌
 */
public class 실패율 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] stages = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stages[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : solution(N, stages)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int N, int[] stages) {
        HashMap<Integer, Integer> stageMap = new HashMap<>();
        HashMap<Integer, Double> failMap = new HashMap<>();
        int total = stages.length;

        // 1. 각 스테이지별 개수 카운트
        for (int stage : stages) {
            stageMap.put(stage, stageMap.getOrDefault(stage, 0) + 1);
        }

        // 2. 각 스테이지별 확률 추가
        for (int i = 1; i <= N; i++) {
            if (stageMap.containsKey(i)) {
                failMap.put(i, (double) stageMap.get(i) / total);
                total -= stageMap.get(i);
            } else {
                failMap.put(i, 0.0);
            }
        }

        // 3. 정렬
        List<Integer> keys = new ArrayList<>(failMap.keySet());
        Collections.sort(keys, (k1, k2) -> failMap.get(k2).compareTo(failMap.get(k1)));

        return keys;
    }
}
