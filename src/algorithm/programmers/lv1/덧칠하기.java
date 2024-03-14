package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-14
 * 덧칠하기 (Lv1)
 * not solved ❌
 */
public class 덧칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] section = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            section[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, section));
    }

    private static int solution(int n, int m, int[] section) {
        int result = 0;
        int start = section[0];
        result++;

        for (int x : section) {
            if (start + m > x) {
                continue;
            }
            start = x;
            result++;
        }

        return result;
    }
}
