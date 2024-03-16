package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-16
 * 로또의 최고순위와 최저순위 (Lv1)
 * solved ✅
 */
public class 로또의_최고순위와_최저순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = 6;
        int[] lottos = new int[n];
        int[] win_nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lottos[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            win_nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        int[] result = new int[2];
        int n = 6;
        int highCount = 0;
        int lowCount = 0;
        int oriCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (win_nums[i] == lottos[j]) {
                    highCount++;
                    lowCount++;
                    oriCount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (lottos[i] == 0) {
                highCount++;
                lowCount--;
            }
        }

        result[0] = calcRank(highCount);
        if (oriCount > lowCount) {
            result[1] = calcRank(oriCount);
        } else {
            result[1] = calcRank(lowCount);
        }

        return result;
    }

    private static int calcRank(int count) {
        switch (count) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
