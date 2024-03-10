package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-10
 * 두 개 뽑아서 더하기 (Lv1)
 * solved ✅
 */
public class 두_개_뽑아서_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : solution(numbers)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        for (Integer x : set) {
            list.add(x);
        }
        Collections.sort(list);
        return list;
    }
}
