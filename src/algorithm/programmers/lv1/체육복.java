package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

public class 체육복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] lost = new int[a];
        int[] reserve = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            lost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            reserve[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, lost, reserve));

    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int result = 0;
        HashSet<Integer> rSet = new HashSet<>();
        HashSet<Integer> lSet = new HashSet<>();

        for (int x : reserve) {
            rSet.add(x);
        }
        for (int x : lost) {
            if (rSet.contains(x)) {
                rSet.remove(x);
            } else {
                lSet.add(x);
            }
        }

        for (int x : rSet) {
            if (lSet.contains(x - 1)) {
                lSet.remove(x - 1);
            } else if (lSet.contains(x + 1)) {
                lSet.remove(x + 1);
            }
        }

        result = n - lSet.size();
        return result;
    }
}
