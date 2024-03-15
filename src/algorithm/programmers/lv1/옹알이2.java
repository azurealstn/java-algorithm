package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-15
 * 옹알이 (2) (Lv1)
 * not solved ❌
 */
public class 옹알이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] babbling = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            babbling[i] = st.nextToken();
        }
        System.out.println(solution(babbling));
    }

    private static int solution(String[] babbling) {
        int result = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        String[] wordRepeats = {"ayaaya", "yeye", "woowoo", "mama"};
        for (String str : babbling) {
            for (int i = 0; i < words.length; i++) {
                str = str.replaceAll(wordRepeats[i], "A").replaceAll(words[i], " ");
            }
            if (str.trim().length() == 0) {
                result++;
            }
        }

        return result;
    }
}
