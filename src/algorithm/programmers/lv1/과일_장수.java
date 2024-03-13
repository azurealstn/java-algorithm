package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-13
 * 과일 장수 (Lv1)
 * solved ✅
 */
public class 과일_장수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(k, m, score));
    }

    private static int solution(int k, int m, int[] score) {
        int result = 0;
        int n = score.length;

        List<Integer> list = new ArrayList<>();
        for (int x : score) {
            list.add(x);
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n / m; i++) {
            int[] tmp = new int[m];
            int index = 0;
            for (int j = i * m; j < i * m + m; j++) {
                if (list.get(j) <= k) {
                    tmp[index] = list.get(j);
                    index++;
                }
            }
            int min = Arrays.stream(tmp).min().getAsInt();
            result += min * m;
        }

        return result;
    }
}
