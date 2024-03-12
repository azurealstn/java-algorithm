package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-12
 * 폰켓몬 (Lv1)
 * solved ✅
 */
public class 폰켓몬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(nums));

    }

    private static int solution(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return Math.min(map.size(), n / 2);
    }
}
