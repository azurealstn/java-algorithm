package algorithm.programmers.lv1;

import java.time.*;
import java.util.*;
import java.io.*;

/**
 * 2024-03-12
 * 2016년 (Lv1)
 * not solved ❌
 */
public class Year2016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(solution(a, b));
    }

    private static String solution(int a, int b) {
        // Java 8 - LocalDate 라이브러리 활용
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }
}
