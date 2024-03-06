package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-05
 * 최대공약수와 최소공배수 (Lv1)
 * not solved ❌
 */
public class 최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(Arrays.toString(solution(n, m)));
    }

    private static int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    // 최대공약수 구하기 (유클리드 호제법 이용)
    private static int gcd(int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수 구하기
    // 최소공배수 * 최대공약수 = n * m 임을 이용
    // 따라서 최소공배수 = n * m / 최대공약수
    private static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

}
