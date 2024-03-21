package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-21
 * 햄버거 만들기 (Lv1)
 * not solved ❌
 */
public class 햄버거_만들기 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }

    private static int solution(int[] ingredient) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int x : ingredient) {
            list.add(x);
            while (list.size() >= 4) {
                int n = list.size();
                if (!(list.get(n - 4) == 1 &&
                        list.get(n - 3) == 2 &&
                        list.get(n - 2) == 3 &&
                        list.get(n - 1) == 1)) {
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    list.remove(list.size() - 1);
                }
                result++;
            }
        }
        return result;
    }
}
