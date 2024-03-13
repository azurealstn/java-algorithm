package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-13
 * 기사단원의 무기 (Lv1)
 * solved ✅
 */
public class 기사단원의_무기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());
        System.out.println(solution(number, limit, power));
    }

    private static int solution(int number, int limit, int power) {
        int result = 0;
        int[] knight = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            int count = 0;
            int sqrt = (int) Math.sqrt(i);

            // 약수를 구할 때는 반복문에서 제곱근까지만 반복한다.
            // 안그러면 시간초과 발생
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    count++;
                    if (j != i / j) {
                        count++;
                    }
                }
            }
            knight[i] = count;
        }
        for (int x : knight) {
            if (x > limit) {
                result += power;
            } else {
                result += x;
            }
        }

        return result;
    }
}
