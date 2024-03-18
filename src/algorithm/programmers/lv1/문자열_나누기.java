package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-18
 * 문자열 나누기 (Lv1)
 * not solved ❌
 */
public class 문자열_나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int result = 1;
        char tmp = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (count == 0) {
                result++;
                tmp = s.charAt(i);
            }

            if (tmp == s.charAt(i)) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}
