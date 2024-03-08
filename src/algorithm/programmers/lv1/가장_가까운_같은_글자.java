package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-08
 * 가장 가까운 같은 글자 (Lv1)
 * not solved ❌
 */
public class 가장_가까운_같은_글자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String s = br.readLine();
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            answer[i] = i - map.getOrDefault(x, i + 1);
            map.put(x, i);
        }

        return answer;
    }
}
