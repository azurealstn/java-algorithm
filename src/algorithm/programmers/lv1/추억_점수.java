package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-11
 * 추억 점수 (Lv1)
 * solved ✅
 */
public class 추억_점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        int[] yearning = new int[n];
        for (int i = 0; i < n; i++) {
            yearning[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[][] photo = new String[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                photo[i][j] = st.nextToken();
            }
        }
        System.out.println(Arrays.toString(solution(name, yearning, photo)));

    }

    private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.get(photo[i][j]) != null) {
                    sum += map.get(photo[i][j]);
                }
            }
            result[i] = sum;
        }
        return result;
    }
}
