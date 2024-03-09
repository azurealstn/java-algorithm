package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-09
 * K번째수 (Lv1)
 * solved ✅
 */
public class K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int[][] commands = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                commands[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int index = 0;
            int[] tmp = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                tmp[index] = array[j];
                index++;
            }
            Arrays.sort(tmp);
            result[i] = tmp[commands[i][2] - 1];
        }

        return result;
    }
}
