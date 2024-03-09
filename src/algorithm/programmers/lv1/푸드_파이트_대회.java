package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-09
 * 푸드 파이트 대회 (Lv1)
 * solved ✅
 */
public class 푸드_파이트_대회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] food = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(food));
    }

    private static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int n = food.length;
        for (int i = 1; i < n; i++) { // 1번 음식, 2번 음식, 3번 음식
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(sb).append(0);
        String rs = sb.reverse().toString();
        result.append(rs);
        return result.toString();
    }
}
