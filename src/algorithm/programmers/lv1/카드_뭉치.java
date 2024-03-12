package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-12
 * 카드 뭉치 (Lv1)
 * not solved ❌
 */
public class 카드_뭉치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] cards1 = new String[n];
        String[] cards2 = new String[m];
        String[] goal = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards1[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cards2[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            goal[i] = st.nextToken();
        }
        System.out.println(solution(cards1, cards2, goal));
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        String result = "Yes";

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            if (p1 < cards1.length && word.equals(cards1[p1])) {
                p1++;
            } else if (p2 < cards2.length && word.equals(cards2[p2])) {
                p2++;
            } else {
                return "No";
            }
        }

        return result;
    }
}
