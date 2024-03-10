package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-10
 * [1차] 비밀지도 (Lv1)
 * solved ✅
 */
public class 비밀지도_1차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String bs1 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String bs2 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(bs1.charAt(j));
                if (map[i][j] == 0) {
                    map[i][j] = Character.getNumericValue(bs2.charAt(j));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }
}
