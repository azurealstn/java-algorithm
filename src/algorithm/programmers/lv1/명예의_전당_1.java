package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-11
 * 명예의 전당 (1) (Lv1)
 * solved ✅
 */
public class 명예의_전당_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(solution(k, score)));
    }

    private static int[] solution(int k, int[] score) {
        int n = score.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(score[j]);
            }
            Collections.sort(list, Collections.reverseOrder());
            if (i < k - 1) {
                result[i] = list.get(i);
            } else {
                result[i] = list.get(k - 1);
            }
        }
        return result;
    }
}
