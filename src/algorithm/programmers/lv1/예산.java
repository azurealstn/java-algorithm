package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-06
 * 예산 (Lv1)
 * solved ✅
 */
public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        int budget = Integer.parseInt(br.readLine());

        System.out.println(solution(d, budget));
    }

    private static int solution(int[] d, int budget) {
        int result = 0;
        Arrays.sort(d);
        int sum = 0;
        for (int x : d) {
            if (sum + x > budget) {
                break;
            } else {
                sum += x;
                result++;
            }
        }
        return result;
    }
}
