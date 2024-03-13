package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-13
 * 소수 만들기 (Lv1)
 * not solved ❌
 */
public class 소수_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int result = 0;
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }

        }
        for (int x : list) {
            if (isPrime(x)) {
                result++;
            }
        }

        return result;
    }

    // 소수인지 판별하는 메서드는 제곱근까지만 루프를 돈다.
    // 나누어 떨어지면 바로 false를 반환한다..
    private static boolean isPrime(int sum) {
        for (int i = 2; i <= (int) Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
