package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-12
 * 모의고사 (Lv1)
 * solved ✅
 */
public class 모의고사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(answers));
    }

    private static ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = answers.length;
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < n; i++) {

            if (answers[i] == a1[i % a1.length]) {
                sum1++;
            }
            if (answers[i] == a2[i % a2.length]) {
                sum2++;
            }
            if (answers[i] == a3[i % a3.length]) {
                sum3++;
            }
        }
        int max = Math.max(Math.max(sum1, sum2), sum3);
        if (max == sum1) {
            list.add(1);
        }
        if (max == sum2) {
            list.add(2);
        }
        if (max == sum3) {
            list.add(3);
        }
        Collections.sort(list);
        return list;
    }
}
