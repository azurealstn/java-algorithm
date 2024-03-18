package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-18
 * 대충 만든 자판 (Lv1)
 * solved ✅
 */
public class 대충_만든_자판 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] keymap = new String[n];
        String[] targets = new String[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            keymap[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            targets[i] = st.nextToken();
        }
        System.out.println(Arrays.toString(solution(keymap, targets)));

    }

    private static int[] solution(String[] keymap, String[] targets) {
        int n = keymap.length;
        int m = targets.length;

        int[] result = new int[m];
        int i = 0;
        for (String target : targets) {
            int clickSum = 0;
            for (char c : target.toCharArray()) {
                int min = Integer.MAX_VALUE;
                for (String key : keymap) {
                    int index = key.indexOf(c);
                    if (index != -1 && index < min) {
                        min = index;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    clickSum = -1;
                    break;
                } else {
                    clickSum += min + 1;
                }
            }
            result[i] = clickSum;
            i++;
        }
        return result;
    }
}
