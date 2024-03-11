package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-11
 * 콜라 문제 (Lv1)
 * solved ✅
 */
public class 콜라_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(solution(a, b, n));
    }

    private static int solution(int a, int b, int n) {
        int result = 0;

        while (n / a > 0) {
            int c = n / a * b;
            int r = n % a;
            n = c + r;
            result += c;
        }

        return result;
    }
}
