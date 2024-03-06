package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-06
 * 크기가 작은 부분 문자열 (Lv1)
 * solved ✅
 */
public class 크기가_작은_부분_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String t = br.readLine();
        String p = br.readLine();
        System.out.println(solution(t, p));
    }

    private static int solution(String t, String p) {
        int result = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < p.length() + i; j++) {
                sb.append(t.charAt(j));
            }
            Long tv = Long.parseLong(sb.toString());
            Long pv = Long.parseLong(p);
            if (tv <= pv) {
                result++;
            }
        }

        return result;
    }
}
