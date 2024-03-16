package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-16
 * [1차] 다트 게임 (Lv1)
 * not solved ❌
 */
public class 다트_게임_1차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String dartResult = br.readLine();
        System.out.println(solution(dartResult));
    }

    private static int solution(String dartResult) {
        int result = 0;
        int[] dart = new int[3];
        int index = 0;
        int n = 0;
        String numStr = "";

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c == 'S') {
                n = Integer.parseInt(numStr);
                dart[index] = (int) Math.pow(n, 1);
                index++;
                numStr = "";
            } else if (c == 'D') {
                n = Integer.parseInt(numStr);
                dart[index] = (int) Math.pow(n, 2);
                index++;
                numStr = "";
            } else if (c == 'T') {
                n = Integer.parseInt(numStr);
                dart[index] = (int) Math.pow(n, 3);
                index++;
                numStr = "";
            } else if (c =='*') {
                dart[index - 1] *= 2;
                if (index - 2 >= 0) {
                    dart[index - 2] *= 2;
                }
            } else if (c == '#') {
                dart[index - 1] *= - 1;
            } else {
                numStr += c;
            }
        }

        result = dart[0] + dart[1] + dart[2];

        return result;
    }
}
