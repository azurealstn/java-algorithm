package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-04
 * 부족한 금액 계산하기 (Lv1)
 * solved ✅
 */
public class 부족한_금액_계산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        System.out.println(solution(price, money, count));
    }

    private static long solution(int price, int money, int count) {
        long answer;
        int oriPrice = price;
        long total = 0L;

        // 총 금액 구하기
        for (int i = 1; i <= count; i++) {
            total += (long) oriPrice * i;
        }

        // 지불해야할 금액이 내가 가진 money보다 많은 경우 부족한 금액 출력
        // 그렇지 않으면 부족하지 않으므로 0 출력
        if (total > money) {
            answer = total - (long) money;
        } else {
            answer = 0;
        }

        return answer;
    }

}
