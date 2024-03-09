package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-09
 * 숫자 문자열과 영단어 (Lv1)
 * solved ✅
 */
public class 숫자_문자열과_영단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        String result = "";
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                sb.append(x);
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(sb.toString())) {
                        result += String.valueOf(i);
                        sb = new StringBuilder();
                        break;
                    }
                }
            } else {
                result += String.valueOf(Character.getNumericValue(x));
            }
        }
        return Integer.parseInt(result);
    }
}
