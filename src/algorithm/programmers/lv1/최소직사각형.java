package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-06
 * 최소직사각형 (Lv1)
 * not solved ❌
 */
public class 최소직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지갑의 개수
        int[][] sizes = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sizes[i][0] = Integer.parseInt(st.nextToken()); // 가로길이
            sizes[i][1] = Integer.parseInt(st.nextToken()); // 세로길이
        }
        System.out.println(solution(sizes));
    }

    private static int solution(int[][] sizes) {
        int result = 0;
        int n = sizes.length;
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            // 가로길이 = 가로와 세로 길이 중 max 값을 설정
            // 세로길이 = 가로와 세로 길이 중 min 값을 설정
            // 마지막으로 가로의 최대길이와 세로의 최대길이를 구한다.
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            if (maxWidth < width) {
                maxWidth = width;
            }
            if (maxHeight < height) {
                maxHeight = height;
            }
        }

        result = maxWidth * maxHeight;

        return result;
    }
}
