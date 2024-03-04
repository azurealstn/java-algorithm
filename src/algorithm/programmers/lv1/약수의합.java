package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-04
 * 약수의합 (Lv1)
 * solved ✅
 */
public class 약수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1]; // 각 숫자에 대한 체크 배열
        for (int i = 1; i <= n; i++) {
            // 나머지가 0이고, 약수들이 체크가 안되어 있을 경우
            if (n % i == 0 && ch[i] == 0 && ch[n / i] == 0) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    answer += i;
                }
                if (ch[n / i] == 0) {
                    ch[n / i] = 1;
                    answer += n / i;
                }


            }
        }
        return answer;
    }
}
